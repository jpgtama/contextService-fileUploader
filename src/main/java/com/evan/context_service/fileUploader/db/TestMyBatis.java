/**
 * 
 */
package com.evan.context_service.fileUploader.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.evan.context_service.fileUploader.db.entity.Book;
import com.evan.context_service.fileUploader.db.entity.User;
import com.evan.context_service.fileUploader.db.entity.UserBook;
import com.evan.context_service.fileUploader.db.mapper.BookMapper;
import com.evan.context_service.fileUploader.db.mapper.UserBookMapper;
import com.evan.context_service.fileUploader.db.mapper.UserMapper;

/**
 * @author 310199253
 *
 */
public class TestMyBatis {

	public static void main(String[] args) throws IOException {

		SqlSession session = null;

		try {
			session = getSession();

//			testUser(session);
			
//			testBook(session);
			
			testUserBook(session);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static void testUser(SqlSession session) {
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		// add user
		User user = new User();
		user.setName("FanFan");
		mapper.insert(user);
		session.commit();
		
		
		System.out.println(user);
		
		// select user
//			System.out.println(mapper.select(2));
	}
	
	private static void testBook(SqlSession session) {
		BookMapper mapper = session.getMapper(BookMapper.class);
		
		// add user
		Book book = new Book();
		book.setName("Hello America");
		book.setPrivateOnly(true);
		
		mapper.insert(book);
		session.commit();
		
		
		System.out.println(book);
		
		// select user
//			System.out.println(mapper.select(1));
	}
	
	private static void testUserBook(SqlSession session) {
		UserBookMapper mapper = session.getMapper(UserBookMapper.class);
		
		// add user
		UserBook entity = new UserBook();
		entity.setBookId(1);
		entity.setUserId(1);
		
		mapper.insert(entity);
		session.commit();
		
		
		System.out.println(entity);
		
		// select user
//			System.out.println(mapper.select(1));
	}

	private static SqlSession getSession() throws IOException {
		SqlSession session;
		String resource = "mybatis-config.xml";
		try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		}

		return session;
	}
}
