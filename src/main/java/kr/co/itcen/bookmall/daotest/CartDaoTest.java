package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.vo.Cart;

public class CartDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		CartDao dao =new CartDao();
		Cart vo1 = new Cart();
		vo1.setAmount(2L);
		vo1.setBook_no(FindBook("webmaster"));
		vo1.setUser_no(1L);
		dao.insert(vo1);
		
		Cart vo2 = new Cart();
		vo2.setAmount(5L);
		vo2.setBook_no(FindBook("노인과바다"));
		vo2.setUser_no(3L);
		dao.insert(vo2);
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		CartDao dao= new CartDao();
		List<Cart> list=dao.getList();
		for(Cart cart:list) 
			System.out.println(cart);
	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new CartDao().delete();
//	}
	private static Long FindBook(String title) {
		BookDao dao = new BookDao();
		Long bno=dao.FindNo(title);
		return bno;
	}
}
