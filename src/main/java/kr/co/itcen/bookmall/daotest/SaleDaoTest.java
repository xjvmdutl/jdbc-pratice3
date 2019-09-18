package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.SaleDao;
import kr.co.itcen.bookmall.vo.Sale;


public class SaleDaoTest {

	public static void main(String[] args) {
		insertTest();
		selectTest();
		//deleteAllTest();
		//selectTest();
	}
	private static void insertTest() {
		System.out.println("insert test---------------");
		SaleDao dao =new SaleDao();
		Sale vo1 = new Sale();
		vo1.setSaleprice(100L);
		vo1.setSaletitle("노인과바다");
		vo1.setBooknum(FindBookNo("노인과바다"));
		dao.insert(vo1);
		BookDaoTest bookdao=new BookDaoTest();
		bookdao.updatePriceTest(vo1.getBooknum(),vo1.getSaleprice());
		
		Sale vo2 = new Sale();
		vo2.setSaleprice(500L);
		vo2.setSaletitle("차세대");
		//vo2.setBooknum(FindBookNo(3L));
		dao.insert(vo2);
		bookdao.updatePriceTest(vo2.getBooknum(),vo2.getSaleprice());	
	}
	private static void selectTest() {
		System.out.println("select test---------------");
		SaleDao dao= new SaleDao();
		List<Sale> list=dao.getList();
		for(Sale sale:list) 
			System.out.println(sale);
	}
	private static Long FindBookNo(String title) {
		BookDao dao = new BookDao();
		Long bno=dao.FindNo(title);
		return bno;
	}
//	private static void deleteAllTest() {
//		System.out.println("delete test---------------");
//		new SaleDao().delete();
//	}
}
