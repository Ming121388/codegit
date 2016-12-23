package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sy.dao.RoleMapper;
import sy.dao.RoleUserMapper;
import sy.model.Role;
import sy.model.RoleUser;

public class RoleServiceImpl implements RoleServiceI {
	private RoleMapper roleMapper;
	private RoleUserMapper roleUserMapper;

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public RoleUserMapper getRoleUserMapper() {
		return roleUserMapper;
	}

	@Autowired
	public void setRoleUserMapper(RoleUserMapper roleUserMapper) {
		this.roleUserMapper = roleUserMapper;
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRoleByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoleUser(RoleUser r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRole(String name, String role) {
		// TODO Auto-generated method stub

	}

}
