package com.junjay.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junjay.spring5.dao.BookDao;
import com.junjay.spring5.entity.Book;

@Service
public class BookService {

	// ×¢Èëdao½Ó¿Ú
	@Autowired
	private BookDao bookDao;

	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	public void delBook(String id) {
		bookDao.delBook(id);
	}

	public int findCount() {
		return bookDao.findCount();
	}

	public Book findOne(String id) {
		return bookDao.findOne(id);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public void bathAdd(List<Object[]> bathargs) {
		bookDao.bathAdd(bathargs);
	}
	
	public void bathUpdate(List<Object[]> bathargs) {
		bookDao.bathUpdate(bathargs);
	}
	
	public void bathDel(List<Object[]> bathargs) {
		bookDao.bathDel(bathargs);
	}

}
