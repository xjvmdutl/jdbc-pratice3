package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.vo.OrderBook;

public class OrderBookDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		OrderBookDao dao =new OrderBookDao();
		OrderBook vo1 = new OrderBook();
		vo1.setBook_no(1L);
		vo1.setAmount(2L);
		vo1.setOrder_no(1L);
		dao.insert(vo1);
		
		OrderBook vo2 = new OrderBook();
		vo2.setBook_no(3L);
		vo2.setAmount(1L);
		vo2.setBook_no(1L);
		dao.insert(vo2);
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		OrderBookDao dao= new OrderBookDao();
		List<OrderBook> list=dao.getList();
		for(OrderBook orderbook:list) 
			System.out.println(orderbook);
	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new OrderBookDao().delete();
//	}
}
