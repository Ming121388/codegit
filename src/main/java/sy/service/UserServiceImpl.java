package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private UserMapper userMapper;

	// private UserMapper getUserMapper() {
	// return userMapper;
	// }
	@Autowired
	private void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(Integer id) {

		return userMapper.selectByPrimaryKey(id);
	}
	@Override
    public void setUser(String name ,String psw){
    	User u=new User();
    	u.setName(name);
    	u.setPsw(psw);
    	userMapper.insert(u);
    }
	@Override
	public List<User> getAll(){
		return userMapper.getAll();
		
	}
	@Override
	public User getUserByName(String name){
		
		return userMapper.selectByName(name);
		
	}
}
