package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderInfo;



public class OrderInfoDao {
	public List<OrderInfo> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<OrderInfo> result = new ArrayList<OrderInfo>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select bookmall.order.no,userinfo.name,userinfo.email,(saletable.price-saletable.saleprice)*orderbook.amount,bookmall.order.post from (select book.no as no,book.title,book.category_no,book.price,sale.saleprice from book LEFT JOIN sale on sale.book_no=book.no) as saletable,orderbook,userinfo,bookmall.user,bookmall.order where saletable.no=orderbook.book_no and orderbook.order_no=bookmall.order.no and bookmall.order.user_no=bookmall.user.no and bookmall.user.no=userinfo.user_no";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	String name = rs.getString(2);
	        	String email=rs.getString(3);
	        	Long price=rs.getLong(4);
	        	String from=rs.getString(5);
	        	OrderInfo vo = new OrderInfo();
	        	vo.setNo(no);
	        	vo.setEmail(email);
	        	vo.setFrom(from);
	        	vo.setName(name);
	        	vo.setPrice(price);
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
