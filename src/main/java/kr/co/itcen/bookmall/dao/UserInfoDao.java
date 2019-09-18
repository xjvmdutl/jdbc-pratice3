package kr.co.itcen.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.itcen.bookmall.vo.UserInfo;

public class UserInfoDao {

	public Boolean insert(UserInfo vo) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Boolean result = false;
		ResultSet rs =null;
		try {
			connection = getConnection();
			String sql = "insert into userinfo values(null,?,?,?,?)";
			pstmt = connection.prepareStatement(sql);
		    pstmt.setString(1, vo.getName());
		    pstmt.setString(2, vo.getPhone());
		    pstmt.setString(3, vo.getEmail());
		    if(vo.getUser_no()!=null)
		    	pstmt.setLong(4, vo.getUser_no());
		    else
		    	pstmt.setString(4, null);
		    int count = pstmt.executeUpdate();
		    result = (count==1);
		    stmt=connection.createStatement();
		    rs =stmt.executeQuery("select last_insert_id()");
		    if(rs.next()) {
		    	Long no=rs.getLong(1);
		        vo.setNo(no);
		    }
		    System.out.println("gdgdf");
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

	public List<UserInfo> getList() {
		Connection connection = null;
	    PreparedStatement pstmt = null;
	    List<UserInfo> result = new ArrayList<UserInfo>();
	    ResultSet rs =null;
	    try {  
	    	connection = getConnection();
	        String sql = "select * from userinfo order by no asc";
	        pstmt = connection.prepareStatement(sql);
	        rs= pstmt.executeQuery();
	        while(rs.next()) {
	        	Long no=rs.getLong(1);
	        	String name = rs.getString(2);
	        	String phone = rs.getString(3);
	        	String email = rs.getString(4);
	        	Long user_no = rs.getLong(5);
	        	UserInfo vo = new UserInfo();
	        	vo.setNo(no);
	        	vo.setName(name);
	        	vo.setEmail(email);
	        	vo.setPhone(phone);
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
