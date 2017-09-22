package demo.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo.mapper.OrderMapper;
import demo.mapper.UserMapper;
import demo.model.User;
import demo.service.UserServiceImpl;

public class SpringTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void test() {
		UserMapper mapper = context.getBean(UserMapper.class);

		System.out.println(mapper.login("萧十一", "6"));
	}

	@Test
	public void test2() {
		SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sessionFactory");
		org.apache.ibatis.logging.LogFactory.useStdOutLogging();
		Configuration config = factory.getConfiguration();
		// config.setLogImpl(StdOutImpl.class);

		System.out.println(config.getLogImpl());

		SqlSession session = factory.openSession();
		UserMapper mapper = context.getBean(UserMapper.class);

		System.out.println(mapper.login("萧十一", "6"));
	}

	@Test
	public void test3() {
		OrderMapper mapper = context.getBean(OrderMapper.class);
		System.out.println(mapper.selectAll());
	}

	@Test
	public void test4() {
		UserServiceImpl service = (UserServiceImpl) context.getBean("userService");
		System.out.println(service.login("萧十一", "6"));
	}

	@Test
	public void test5() {
		List<User> list = new ArrayList<User>();
		for (int i = 8; i < 30; i++) {
			User user = new User();
			user.setPassword("12321");
			user.setUsername("asdfe" + i);
			list.add(user);
		}
		UserServiceImpl service = (UserServiceImpl) context.getBean("userService");
		service.addBatch(list);
	}
}
