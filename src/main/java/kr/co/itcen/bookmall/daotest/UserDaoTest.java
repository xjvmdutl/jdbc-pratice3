package kr.co.itcen.bookmall.daotest;
import java.util.List;

import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.vo.User;

public class UserDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
		
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		UserDao dao=new UserDao();
		User vo1 = new User();
		vo1.setAdmin_no("111111-111111");
		vo1.setPassword("1234");
		dao.insert(vo1);
		
		User vo2 = new User();
		vo2.setAdmin_no("222222-2222222");;
		vo2.setPassword("4567");
		dao.insert(vo2);
		
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		UserDao dao= new UserDao();
		List<User> list=dao.getList();
		for(User user:list) 
			System.out.println(user);
	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new UserDao().delete();
//	}
}
