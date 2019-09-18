package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.OrderBook;

public class OrderBookDao {

	public Boolean insert(OrderBook vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "insert into orderbook values(null,?,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setLong(1, vo.getAmount());
			if(vo.getOrder_no()!=null)
				pstmt.setLong(2, vo.getOrder_no());
			else
				pstmt.setString(2, null);
			if(vo.getBook_no()!=null)
				pstmt.setLong(3, vo.getBook_no());
			else
				pstmt.setString(3, null);
			int count = pstmt.executeUpdate();
		    result = (count==1);
		    stmt=connection.createStatement();
		    rs =stmt.executeQuery("select last_insert_id()");
		    if(rs.next()) {
		    	Long no=rs.getLong(1);
		        vo.setNo(no);
		    }
		}catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try{
				if(pstmt != null) {
					pstmt.close();
		        }if(rs!=null) {
		        	rs.close();
		        }if(stmt!=null) {
		        	stmt.close();
		        }if(connection != null){
		        	connection.close();
		        }
		     }catch (Exception e) {
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
	public List<OrderBook> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<OrderBook> result = new ArrayList<OrderBook>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select * from orderbook order by no asc";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	Long amount = rs.getLong(2);
	        	Long order_no=rs.getLong(3);
	        	Long book_no=rs.getLong(4);
	        	OrderBook vo = new OrderBook();
	        	vo.setNo(no);
	        	vo.setAmount(amount);
	        	vo.setBook_no(book_no);
	        	vo.setOrder_no(order_no);
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
	public void delete() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    try {
	    	connection = getConnection();
	    	String sql = "delete from orderbook";
	        pstmt = connection.prepareStatement(sql);
	        pstmt.executeUpdate();
	      }catch (SQLException e) {
	    	  System.out.println("error : " + e);
	      }finally {
	    	  try{
	    		  if (pstmt != null) {
	              pstmt.close();
	            }
	    		  if(connection != null) {
	    			  connection.close();
	            }
	    	  }catch (Exception e) {
	            e.printStackTrace();
	         }
	      }
	}
}
