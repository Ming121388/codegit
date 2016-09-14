package sy.dao;

import java.util.List;

import sy.model.Detail;

public interface DetailMapper {
    int deleteByPrimaryKey(Long detailId);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Long detailId);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
    
    List<Detail> getAllDetal();
    
    List<Detail> getDetailByOrderId(Long orderId);
    
}