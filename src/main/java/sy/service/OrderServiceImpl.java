package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.DetailMapper;
import sy.dao.OrderMapper;
import sy.model.Detail;
import sy.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderServiceI {

	private OrderMapper orderMapper;

	private OrderMapper getOrderMapper() {
		return orderMapper;
	}

	@Autowired
	private void setOrderMapper(OrderMapper orderMapper) {
		this.orderMapper = orderMapper;
	}

	private DetailMapper detailMapper;

	private DetailMapper getDetailMapper() {
		return detailMapper;
	}

	@Autowired
	private void setDetailMapper(DetailMapper detailMapper) {
		this.detailMapper = detailMapper;
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return orderMapper.getAllOrder();
	}

	@Override
	public void setOrder(Order order) {
		// TODO Auto-generated method stub
		orderMapper.insert(order);
	}

	@Override
	public void setOrderIsComplete(long orderId, int iscomplete) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderIscomplete(iscomplete);
		orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public void setOrderIsCancel(long orderId, int isCancel) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderIscancel(isCancel);
		orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public void setOrderCompleter(long orderId, String completer) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setOrderId(orderId);
		order.setOrderCompleter(completer);
		orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public List<Detail> getAllDetail() {
		return detailMapper.getAllDetal();
	}
	
	public Detail getDetailByDetailId(long detailId){
		return detailMapper.selectByPrimaryKey(detailId);
	}
	
	public List<Detail> getDetailByOrderId(Long orderId){
		return detailMapper.getDetailByOrderId(orderId);
	}

	@Override
	public void setDetail(Detail detail) {
		detailMapper.insert(detail);
	}

	@Override
	public void setdetailIsComplete(long detailId, int isComplete) {
		Detail detail = new Detail();
		detail.setDetailId(detailId);
		detail.setdetailIsComplete(isComplete);
		System.out.println("already seted");
		detailMapper.updateByPrimaryKeySelective(detail);
	}

	@Override
	public void setdetailIsCancel(long detailId, int isCancel) {
		Detail detail = new Detail();
		detail.setDetailId(detailId);
		detail.setdetailIsCancel(isCancel);
		System.out.println("already seted");
		detailMapper.updateByPrimaryKeySelective(detail);
	}
	
	public void setDetailCompleter(long detailId, String completer){
		Detail detail=new Detail();
		detail.setDetailId(detailId);
		detail.setDetailCompleter(completer);
		detailMapper.updateByPrimaryKeySelective(detail);
		
	}

}
