package com.nowcoder.wendaFreemarker;

import com.nowcoder.wendaFreemarker.dao.UserDAO;
import com.nowcoder.wendaFreemarker.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WendaFreemarkerApplication.class)
public class InitDatabaseTests {

	@Test
	public void contextLoads() throws IOException {
		//mybatis的配置文件
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession(true);
		UserDAO userDAO=session.getMapper(UserDAO.class);

		Random random = new Random();
		for (int i = 90; i < 100; ++i) {
			User user = new User();
			user.setHeadUrl(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
			user.setName(String.format("USER%d", i));
			user.setPassword("");
			user.setSalt("");
			userDAO.addUser(user);

//			user.setPassword("newpassword");
//			userDAO.updatePassword(user);
//
//			Question question = new Question();
//			question.setCommentCount(i);
//			Date date = new Date();
//			date.setTime(date.getTime() + 1000 * 3600 * 5 * i);
//			question.setCreatedDate(date);
//			question.setUserId(i + 1);
//			question.setTitle(String.format("TITLE{%d}", i));
//			question.setContent(String.format("Balaababalalalal Content %d", i));
//			questionDAO.addQuestion(question);
		}
//		session.commit();
//		Assert.assertEquals("newpassword", userDAO.selectById(1).getPassword());
//		userDAO.deleteById(1);
//		Assert.assertNull(userDAO.selectById(1));

//		/**
//		 * 映射sql的标识字符串，
//		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
//		 * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
//		 */
//		String statement = "com.nowcoder.wendaFreemarker.userMapper.getUser";//映射sql的标识字符串
//		//执行查询返回一个唯一user对象的sql
//		User user = session.selectOne(statement, 2);
//		System.out.println(user);
	}

}
