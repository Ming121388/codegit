package sy.service;

import java.util.List;

import sy.model.Detail;
import sy.model.Order;

public interface OrderServiceI {
	public List<Order> getAllOrder();
	
	public void setOrder(Order order);
	
	public void setOrderIsComplete(long orderId,int isComplete);
	
	public void setOrderIsCancel(long orderId,int isCancel);
	
	public void setOrderCompleter(long orderId,String completer);
	
	public List<Detail> getAllDetail();
	
	public List<Detail> getDetailByOrderId(Long orderId);
	
	public void setDetail(Detail detail);
	
	public Detail getDetailByDetailId(long detailId);
	
	public void setdetailIsComplete(long detailId,int isComplete);
	
	public void setdetailIsCancel(long detailId,int isCancel);
	
	public void setDetailCompleter(long detailId,String completer);
	

}
