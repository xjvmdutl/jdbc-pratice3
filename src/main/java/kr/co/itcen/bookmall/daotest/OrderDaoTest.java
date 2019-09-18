package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.vo.Order;


public class OrderDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
//		deleteAllTest();
//		selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		OrderDao dao =new OrderDao();
		Order vo1 = new Order();
		vo1.setPrice(700L);
		vo1.setFrom("수원시영통구이의동");
		vo1.setUser_no(1L);
		dao.insert(vo1);
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		OrderDao dao= new OrderDao();
		List<Order> list=dao.getList();
		for(Order order:list) 
			System.out.println(order);
	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new OrderDao().delete();
//	}
}
