package sy.service;

import java.util.List;

import sy.model.Role;
import sy.model.RoleUser;

public interface RoleServiceI {
     List<Role> getAllRole();
     
     String getRoleByName(String name);
     
     void setRoleUser(RoleUser r);
     
     void setRole(String name,String role);
     
}
