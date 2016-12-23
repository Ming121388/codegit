package sy.dao;

import sy.model.RoleUser;

public interface RoleUserMapper {
    int deleteByPrimaryKey(RoleUser key);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);
}