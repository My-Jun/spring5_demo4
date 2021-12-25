package com.junjay.spring5.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.junjay.spring5.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	// 注入jdbctemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addBook(Book book) {
		// 创建插入sql语句
		String sql = " INSERT INTO test.book (USER_ID, USERNAME, STATE) VALUES (?,?,?) ";
		// 调用实现方法
		Object[] obj = { book.getUserId(), book.getUsername(), book.getState() };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// 返回值i为影响执行了几行
		System.out.println("影响行数：" + i);

	}

	@Override
	public void updateBook(Book book) {
		// 修改
		String sql = " UPDATE test.book SET  USERNAME=?, STATE=? WHERE (USER_ID=?) ";
		// 调用实现方法
		Object[] obj = { book.getUsername(), book.getState(), book.getUserId() };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// 返回值i为影响执行了几行
		System.out.println("影响行数：" + i);
	}

	@Override
	public void delBook(String id) {
		// 删除
		String sql = " DELETE FROM test.book WHERE (USER_ID=?) ";
		// 调用实现方法
		Object[] obj = { id };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// 返回值i为影响执行了几行
		System.out.println("影响行数：" + i);
	}

	@Override
	public int findCount() {
		// 查询数据库表中有多少条数据
		String sql = " SELECT COUNT(1) FROM book ";
		// 调用实现方法
		int i = jdbcTemplate.queryForObject(sql, int.class);
		// 返回值i为 表中有几条数据
		System.out.println("book有：" + i + "条数据");
		return i;

	}

	@Override
	public Book findOne(String id) {
		String sql = " SELECT * FROM book where USERID = ? ";
		// 三个参数 
		// 1：sql语句，
		// 2：rowmapper 是接口，返回不同类型数据，使用这个接口实现类完成对数据进行封装
		// 查询条件值
		Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		String sql = " SELECT * FROM book   ";
		// 三个参数 
		// 1：sql语句，
		// 2：rowmapper 是接口，返回不同类型数据，使用这个接口实现类完成对数据进行封装
		// 查询条件值
		List<Book> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Book.class));
		return query;
	}

	@Override
	public void bathAdd(List<Object[]> bathargs) {
		String sql = " INSERT INTO test.book (USERID, USERNAME, STATE) VALUES (?,?,?) ";
		int[] is = jdbcTemplate.batchUpdate(sql,bathargs);
		System.out.println(Arrays.toString(is));
	}

	@Override
	public void bathUpdate(List<Object[]> bathargs) {
		String sql = " UPDATE test.book SET  USERNAME=?, STATE=? WHERE (USERID=?) ";
		int[] is = jdbcTemplate.batchUpdate(sql,bathargs);
		System.out.println("修改条目："+Arrays.toString(is));
		
	}

	@Override
	public void bathDel(List<Object[]> bathargs) {
		String sql = " DELETE FROM test.book WHERE (USERID=?) ";
		int[] is = jdbcTemplate.batchUpdate(sql,bathargs);
		System.out.println("删除条目："+Arrays.toString(is));
		
	}

}
