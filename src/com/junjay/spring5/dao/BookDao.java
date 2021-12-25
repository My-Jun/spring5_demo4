package com.junjay.spring5.dao;

import java.util.List;

import com.junjay.spring5.entity.Book;

public interface BookDao {

	void addBook(Book book);

	void updateBook(Book book);

	void delBook(String id);

	int findCount();

	Book findOne(String id);

	List<Book> findAll();

	void bathAdd(List<Object[]> bathargs);

	void bathUpdate(List<Object[]> bathargs);

	void bathDel(List<Object[]> bathargs);

}
