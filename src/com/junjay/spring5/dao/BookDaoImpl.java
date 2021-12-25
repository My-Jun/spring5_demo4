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

	// ע��jdbctemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addBook(Book book) {
		// ��������sql���
		String sql = " INSERT INTO test.book (USER_ID, USERNAME, STATE) VALUES (?,?,?) ";
		// ����ʵ�ַ���
		Object[] obj = { book.getUserId(), book.getUsername(), book.getState() };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// ����ֵiΪӰ��ִ���˼���
		System.out.println("Ӱ��������" + i);

	}

	@Override
	public void updateBook(Book book) {
		// �޸�
		String sql = " UPDATE test.book SET  USERNAME=?, STATE=? WHERE (USER_ID=?) ";
		// ����ʵ�ַ���
		Object[] obj = { book.getUsername(), book.getState(), book.getUserId() };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// ����ֵiΪӰ��ִ���˼���
		System.out.println("Ӱ��������" + i);
	}

	@Override
	public void delBook(String id) {
		// ɾ��
		String sql = " DELETE FROM test.book WHERE (USER_ID=?) ";
		// ����ʵ�ַ���
		Object[] obj = { id };
		int i = jdbcTemplate.update(sql, obj);
		// int i = jdbcTemplate.update(sql,
		// book.getUserId(),book.getUsername(),book.getState());
		// ����ֵiΪӰ��ִ���˼���
		System.out.println("Ӱ��������" + i);
	}

	@Override
	public int findCount() {
		// ��ѯ���ݿ�����ж���������
		String sql = " SELECT COUNT(1) FROM book ";
		// ����ʵ�ַ���
		int i = jdbcTemplate.queryForObject(sql, int.class);
		// ����ֵiΪ �����м�������
		System.out.println("book�У�" + i + "������");
		return i;

	}

	@Override
	public Book findOne(String id) {
		String sql = " SELECT * FROM book where USERID = ? ";
		// �������� 
		// 1��sql��䣬
		// 2��rowmapper �ǽӿڣ����ز�ͬ�������ݣ�ʹ������ӿ�ʵ������ɶ����ݽ��з�װ
		// ��ѯ����ֵ
		Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		String sql = " SELECT * FROM book   ";
		// �������� 
		// 1��sql��䣬
		// 2��rowmapper �ǽӿڣ����ز�ͬ�������ݣ�ʹ������ӿ�ʵ������ɶ����ݽ��з�װ
		// ��ѯ����ֵ
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
		System.out.println("�޸���Ŀ��"+Arrays.toString(is));
		
	}

	@Override
	public void bathDel(List<Object[]> bathargs) {
		String sql = " DELETE FROM test.book WHERE (USERID=?) ";
		int[] is = jdbcTemplate.batchUpdate(sql,bathargs);
		System.out.println("ɾ����Ŀ��"+Arrays.toString(is));
		
	}

}
