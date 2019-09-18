package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.dao.UserInfoDao;
import kr.co.itcen.bookmall.vo.UserInfo;



public class UserInfoDaoTest {

	public static void main(String[] args) {
		insertTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		UserInfoDao dao=new UserInfoDao();
		UserInfo vo1 = new UserInfo();
		vo1.setName("김준호");
		vo1.setPhone("010-1111-2222");
		vo1.setEmail("jdjkd@naver.com");
		vo1.setUser_no(FindUser("111111-111111"));
		dao.insert(vo1);
		Long l=FindUser("112222-22222222");
		System.out.println(l);
		
		UserInfo vo2 = new UserInfo();
		vo2.setName("김준호2");;
		vo2.setPhone("010-2222-3333");
		vo2.setEmail("fda@naver.com");
		vo2.setUser_no(FindUser("1122222222-222222"));
		dao.insert(vo2);
//		
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		UserInfoDao dao= new UserInfoDao();
		List<UserInfo> list=dao.getList();
		for(UserInfo user:list) 
			System.out.println(user);
	}
	private static Long FindUser(String user_admin_no) {
		UserDao dao =new UserDao();
		Long uno = dao.FindUserNo(user_admin_no);
		return uno;
	}
}
