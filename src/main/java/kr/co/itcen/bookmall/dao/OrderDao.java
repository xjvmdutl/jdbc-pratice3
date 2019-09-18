package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.Order;

public class OrderDao {
	public Boolean insert(Order vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "insert into bookmall.order values(null,null,?,?)";
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, vo.getFrom());
			if(vo.getUser_no()!=null)
				pstmt.setLong(2, vo.getUser_no());
			else
				pstmt.setString(2, null);
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
	public List<Order> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<Order> result = new ArrayList<Order>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select * from bookmall.order order by no asc";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	Long price = rs.getLong(2);
	        	String from=rs.getString(3);
	        	Long user_no=rs.getLong(4);
	        	Order vo = new Order();
	        	vo.setNo(no);
	        	vo.setPrice(price);
	        	vo.setFrom(from);
	        	vo.setUser_no(user_no);
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
	    	String sql = "delete from order";
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
	public Boolean updatePrice(Long price,Long no) {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs =null;
	    Boolean result=null;
	    try {  
	    	connection = getConnection();
	        String sql = "update bookmall.order set price=? where no=?";
	        pstmt = connection.prepareStatement(sql);
	        
	        pstmt.setLong(1, price);
	        pstmt.setLong(2, no);
	        
	        rs = pstmt.executeQuery();
	        int count = pstmt.executeUpdate();
		    result = (count==1);
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
	            e.printStackTrace();
	         }
	      }
	    return result;
	}
	public Long FindOrderNo(Long user_admin_no) {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs =null;
	    Long result=null;
	    try {  
	    	connection = getConnection();
	        String sql = "select no from bookmall.order where user_no=?";
	        pstmt = connection.prepareStatement(sql);
	        if(user_admin_no!=null)
	        	pstmt.setLong(1,user_admin_no);
	        else
	        	pstmt.setString(1, null);
	        rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	result=rs.getLong(1);
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
	            e.printStackTrace();
	         }
	      }
	    return result;
	}
	
}
