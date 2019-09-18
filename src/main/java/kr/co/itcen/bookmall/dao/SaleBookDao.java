package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.SaleBook;

public class SaleBookDao {
	public List<SaleBook> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<SaleBook> result = new ArrayList<SaleBook>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select book.no,book.title,book.category_no,book.price,sale.saleprice from book LEFT JOIN sale on sale.book_no=book.no";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	String title=rs.getString(2);
	        	Long categoryno = rs.getLong(3);
	        	Long price = rs.getLong(4);
	        	Long saleprice=rs.getLong(5);
	        	
	        	SaleBook vo = new SaleBook();
	        	vo.setNo(no);
	        	vo.setPrice(price-saleprice);
	        	vo.setCategorynum(categoryno);
	        	vo.setSaleprice(saleprice);
	        	vo.setTitle(title);
	        	result.add(vo);
	         }
	      }catch (SQLException e) {
	         System.out.println("error : " + e);
	      }finally {
	         try {
	        	if(rs!=null) {
	        		rs.close();
	        	}
	            if (pstmt != null) {
	               pstmt.close();
	            }
	            if (connection != null) {
	               connection.close();
	            }
	         } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	         }
	      }
	      return result;
	}
	private Connection getConnection() throws SQLException{
		Connection connection=null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
	        String url = "jdbc:mariadb://192.168.1.86:3306/bookmall?characterEncoding=utf8";
	        connection = DriverManager.getConnection(url, "bookmall", "bookmall");
		}catch (ClassNotFoundException e) {
	         System.out.println("Fail to Loading Driver :" + e);
	    }
		return connection;
	}
}
