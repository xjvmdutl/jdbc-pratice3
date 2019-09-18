package kr.co.itcen.bookmall.daotest;

import java.util.List;

import kr.co.itcen.bookmall.dao.SaleBookDao;
import kr.co.itcen.bookmall.vo.SaleBook;

public class SaleBookDaoTest {

	public static void main(String[] args) {
		selectAll();
	}
	private static void selectAll() {
		List<SaleBook> list=new SaleBookDao().getList();
		for(SaleBook vo:list)
			System.out.println(vo);
	}

}
