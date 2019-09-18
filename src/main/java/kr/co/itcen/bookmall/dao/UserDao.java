package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.User;

public class UserDao {

	public Boolean insert(User vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "insert into user values(null,?,?)";
			pstmt = connection.prepareStatement(sql);
		    pstmt.setString(1, vo.getAdmin_no());
		    pstmt.setString(2, vo.getPassword());
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
	public List<User> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<User> result = new ArrayList<User>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select no,admin,password from user order by no asc";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	String admin_no = rs.getString(2);
	        	String password = rs.getString(3);
	        	User vo = new User();
	        	vo.setNo(no);
	        	vo.setAdmin_no(admin_no);
	        	vo.setPassword(password);
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
	public void delete() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    try {
	    	connection = getConnection();
	    	String sql = "delete from user";
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
	public Long FindUserNo(String user_admin_no) {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs =null;
	    Long result=null;
	    try {  
	    	connection = getConnection();
	        String sql = "select no from user where admin=?";
	        pstmt = connection.prepareStatement(sql);
	        pstmt.setString(1,user_admin_no);
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
