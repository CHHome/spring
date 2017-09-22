package demo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import demo.mapper.UserMapper;
import demo.model.User;

@Service("userService")
public class UserServiceImpl {
	@Resource
	private UserMapper mapper;

	public User login(String username, String password) {
		return mapper.login(username, password);
	}

	public void save(User user) {
		mapper.save(user);
	}

	public void addBatch(List<User> userList) {
		for (User user : userList) {
			mapper.save(user);
		}
	}

	public List<User> find() {
		return mapper.find();
	}

	public List<User> page(int pageNumber, int pageSize) {
		return mapper.findByPage((pageNumber - 1) * pageSize, pageSize, null);
	}
	
	public int count(){
		return mapper.count(null).intValue();
	}
	
	public void delete(int id){
		mapper.delete(id);
	}
	
	public void update(User user){
		mapper.update(user);
	}
}
