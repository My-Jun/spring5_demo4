package com.junjay.spring5.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junjay.spring5.entity.Book;
import com.junjay.spring5.service.BookService;

public class TextBean {

	
	@Test
	public void testJdabAddBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		Book book = new Book("1","java-JdbcTemplate","1");
		bookService.addBook(book);
	}
	
	@Test
	public void testJdabUpdateBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		Book book = new Book("1","java-update","2");
		bookService.updateBook(book);
	}
	
	@Test
	public void testJdabDelBook() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		bookService.delBook("1");
	}
	
	@Test
	public void testJdabfindCount() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		System.err.println(bookService.findCount());
	}
	
	@Test
	public void testJdabfindOne() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		Book findOne = bookService.findOne("1");
		System.out.println(findOne.toString());
	}
	
	@Test
	public void testJdabfindAll() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		List<Book> findAll = bookService.findAll();
		System.out.println(findAll.toString());
	}

	@Test
	public void testJdabBathAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		List<Object[]> bathargs =new ArrayList<>();
		Object[] a1 = {"13","张三","3"};
		Object[] a2 = {"14","李四","4"};
		Object[] a3 = {"15","王五","5"};
		bathargs.add(a1);
		bathargs.add(a2);
		bathargs.add(a3);
		bookService.bathAdd(bathargs);
	}
	
	@Test
	public void testJdabBathUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		List<Object[]> bathargs =new ArrayList<>();
		Object[] a1 = {"张三1","5","13"};
		Object[] a2 = {"李四2","5","14"};
		Object[] a3 = {"王五3","6","15"};
		bathargs.add(a1);
		bathargs.add(a2);
		bathargs.add(a3);
		bookService.bathUpdate(bathargs);
	}
	
	@Test
	public void testJdabBathDel() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		BookService bookService = context.getBean("bookService",BookService.class);
		List<Object[]> bathargs =new ArrayList<>();
		Object[] a1 = {"13"};
		Object[] a2 = {"14"};
		bathargs.add(a1);
		bathargs.add(a2);
		bookService.bathDel(bathargs);
	}

}
