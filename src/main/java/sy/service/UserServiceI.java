package sy.service;

import java.util.List;

import sy.model.User;

public interface UserServiceI {
	public User getUserById(Integer id);
	
	public void setUser(String name,String psw);
	
	public List<User> getAll();
	
	public User getUserByName(String name);
	
}
