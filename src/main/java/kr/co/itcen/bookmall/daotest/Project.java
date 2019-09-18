package kr.co.itcen.bookmall.daotest;

import java.util.List;
import java.util.Scanner;

import kr.co.itcen.bookmall.dao.BookDao;
import kr.co.itcen.bookmall.dao.CartDao;
import kr.co.itcen.bookmall.dao.CategoryDao;
import kr.co.itcen.bookmall.dao.OrderBookDao;
import kr.co.itcen.bookmall.dao.OrderBookInfoDao;
import kr.co.itcen.bookmall.dao.OrderDao;
import kr.co.itcen.bookmall.dao.OrderInfoDao;
import kr.co.itcen.bookmall.dao.SaleBookDao;
import kr.co.itcen.bookmall.dao.SaleDao;
import kr.co.itcen.bookmall.dao.UserDao;
import kr.co.itcen.bookmall.dao.UserInfoDao;
import kr.co.itcen.bookmall.vo.Book;
import kr.co.itcen.bookmall.vo.Cart;
import kr.co.itcen.bookmall.vo.Category;
import kr.co.itcen.bookmall.vo.Order;
import kr.co.itcen.bookmall.vo.OrderBook;
import kr.co.itcen.bookmall.vo.OrderBookInfo;
import kr.co.itcen.bookmall.vo.OrderInfo;
import kr.co.itcen.bookmall.vo.Sale;
import kr.co.itcen.bookmall.vo.SaleBook;
import kr.co.itcen.bookmall.vo.User;
import kr.co.itcen.bookmall.vo.UserInfo;
public class Project {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(true) {
			System.out.println("-------------Menual------------");
			System.out.println("1.User");
			System.out.println("2.Category");
			System.out.println("3.Book");
			System.out.println("4.Cart");
			System.out.println("5.Order");
			System.out.println("6.OrderBook");
			System.out.println("7.Sale");
			System.out.println("8.SaleBook");
			System.out.println("9.Order_Book_Info");
			System.out.println("10.Order_Info");
			System.out.print(">>");
			int choice=sc.nextInt();
			int num;
			switch(choice){
			case 1:	
				System.out.println("1.InsertUser");
				System.out.println("2.SelectUser");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertUser();
					break;
				case 2:
					selectUser();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 2:
				System.out.println("1.InsertCategory");
				System.out.println("2.SelectCategory");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertCategory();
					break;
				case 2:
					selectCategory();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 3:
				System.out.println("1.InsertBook");
				System.out.println("2.SelectBook");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				
				switch(num) {
				case 1:
					insertBook();
					break;
				case 2:
					selectBook();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 4:
				System.out.println("1.InsertCart");
				System.out.println("2.SelectCart");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertCart();
					break;
				case 2:
					selectCart();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 5:
				System.out.println("1.InsertOrder");
				System.out.println("2.SelectOrder");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertOrder();
					break;
				case 2:
					selectOrder();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 6:
				System.out.println("1.InsertOrderBook");
				System.out.println("2.SelectOrderBook");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertOrderBook();
					break;
				case 2:
					selectOrderBook();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 7:
				System.out.println("1.InsertSale");
				System.out.println("2.SelectSale");
				System.out.print(">>");
				num=sc.nextInt();
				sc.nextLine();
				switch(num) {
				case 1:
					insertSale();
					break;
				case 2:
					selectSale();
					break;
				default:
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 8:
				System.out.println("SelectSaleBook");
				selectSaleBook();
				break;
			case 9:
				System.out.println("SelectOrderBookInfo");
				selectOrderBookInfo();
				break;
			case 10:
				System.out.println("SelectOrderInfo");
				SelectOrderInfo();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
	}
	private static void SelectOrderInfo() {
		List<OrderInfo> list=new OrderInfoDao().getList();
		for(OrderInfo vo:list) {
			new OrderDao().updatePrice(vo.getPrice(),vo.getNo());
			System.out.println(vo);
		}
	}
	private static void selectOrderBookInfo(){
		List<OrderBookInfo> list=new OrderBookInfoDao().getList();
		for(OrderBookInfo vo:list)
			System.out.println(vo);
	}
	private static void selectSaleBook() {
		List<SaleBook> list=new SaleBookDao().getList();
		for(SaleBook vo:list)
			System.out.println(vo);
	}
	private static void insertSale() {
		SaleDao dao = new SaleDao();
		BookDao bdao = new BookDao();
		Sale vo = new Sale();
		System.out.print("할인 가격>>");
		Long saleprice = sc.nextLong();
		sc.nextLine();
		System.out.print("도서제목>>");
		String title = sc.nextLine();
		vo.setSaleprice(saleprice);
		vo.setSaletitle(title);
		vo.setBooknum(bdao.FindNo(title));
		dao.insert(vo);
		//updateBookPrice(vo.getBooknum(),vo.getSaleprice());
	}
//	private static void updateBookPrice(Long no,Long price) {
//		BookDao dao =new BookDao();
//		Book vo1 = new Book();
//		vo1.setPrice(price);
//		vo1.setNo(no);
//		dao.update(vo1);
//	}
	private static void selectSale() {
		SaleDao dao = new SaleDao();
		List<Sale> list=dao.getList();
		for(Sale sale:list) 
			System.out.println(sale);
	}
	private static void insertOrderBook() {
		
		OrderBookDao dao = new OrderBookDao();
		OrderBook vo = new OrderBook();
		OrderDao odao= new OrderDao(); 
		BookDao bdao=new BookDao();
		UserDao udao= new UserDao();
		System.out.print("수량>>");
		Long amount = sc.nextLong();
		sc.nextLine();
		System.out.print("주민번호>>");
		String user_no = sc.nextLine();
		System.out.print("도서제목>>");
		String title = sc.nextLine();
		vo.setAmount(amount);
		vo.setBook_no(bdao.FindNo(title));
		vo.setOrder_no(odao.FindOrderNo(udao.FindUserNo(user_no)));
		dao.insert(vo);

	}
	private static void selectOrderBook() {
		OrderBookDao dao = new OrderBookDao();
		List<OrderBook> list=dao.getList();
		for(OrderBook order:list) 
			System.out.println(order);
	}
	private static void insertOrder() {
		OrderDao dao = new OrderDao();
		UserDao udao = new UserDao();
		Order vo = new Order();
		System.out.print("받는주소>>");
		String from = sc.nextLine();
		System.out.print("주민번호>>");
		String admin_no=sc.nextLine();
		vo.setFrom(from);
		vo.setUser_no(udao.FindUserNo(admin_no));
		dao.insert(vo);
	}
	private static void selectOrder() {
		OrderDao dao = new OrderDao();
		List<Order> list=dao.getList();
		for(Order order:list) 
			System.out.println(order);
	}
	private static void insertCart() {
		
		CartDao dao = new CartDao();
		BookDao bdao = new BookDao();
		UserDao udao = new UserDao();
		Cart vo = new Cart();
		System.out.print("수량>>");
		Long amount = sc.nextLong();
		sc.nextLine();
		System.out.print("도서 제목>>");
		String title = sc.nextLine();
		System.out.print("주민번호>>");
		String admin_no= sc.nextLine();
		vo.setTitle(title);
		vo.setAmount(amount);
		vo.setBook_no(bdao.FindNo(title));
		vo.setUser_no(udao.FindUserNo(admin_no));
		dao.insert(vo);
	
	}
	private static void selectCart() {
		CartDao dao = new CartDao();
		List<Cart> list=dao.getList();
		for(Cart cart:list) 
			System.out.println(cart);
	}
	private static void insertBook() {
		
		BookDao dao = new BookDao();
		Book vo = new Book();
		System.out.print("제목>>");
		String title=sc.nextLine();
		System.out.print("가격>>");
		Long price=sc.nextLong();
		sc.nextLine();
		System.out.print("카테고리 이름>>");
		String catname= sc.nextLine();
		vo.setPrice(price);
		vo.setTitle(title);
		vo.setCategorynum(FindCategory(catname));
		dao.insert(vo);
		
	}
	private static Long FindCategory(String categoryname) {
		CategoryDao dao =new CategoryDao();
		Long cno = dao.FindCateNo(categoryname);
		return cno;
	}
	private static void selectBook() {
		BookDao dao = new BookDao();
		List<Book> list=dao.getList();
		for(Book book:list) 
			System.out.println(book);
	}
	private static void insertCategory() {
		
		CategoryDao cdao = new CategoryDao();
		Category vo = new Category();
		System.out.print("카테고리>>");
		String category=sc.nextLine();
		vo.setCategory(category);
		cdao.insert(vo);
	}
	private static void selectCategory() {
		CategoryDao cdao = new CategoryDao();
		List<Category> list=cdao.getList();
		for(Category cat:list) 
			System.out.println(cat);
	}
	private static void insertUser() {
		
		UserDao dao=new UserDao();
		User vo = new User();
		System.out.print("주민번호>>");
		String admin_no=sc.nextLine();
		System.out.print("비밀번호>>");
		String password=sc.nextLine();
		vo.setAdmin_no(admin_no);
		vo.setPassword(password);
		dao.insert(vo);
		UserInfoDao udao = new UserInfoDao();
		UserInfo uvo = new UserInfo();
		System.out.print("이름>>");
		String name=sc.nextLine();
		System.out.print("번호>>");
		String phone=sc.nextLine();
		System.out.print("이메일>>");
		String email=sc.nextLine();	
		uvo.setName(name);
		uvo.setEmail(email);
		uvo.setPhone(phone);
		uvo.setUser_no(dao.FindUserNo(vo.getAdmin_no()));
		udao.insert(uvo);
	}	
	private static void selectUser() {
		UserInfoDao dao= new UserInfoDao();
		List<UserInfo> list=dao.getList();
		for(UserInfo userinfo:list) 
			System.out.println(userinfo);
	}
}