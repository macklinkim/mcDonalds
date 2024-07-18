package emac.service;

import java.util.List;

import emac.entity.order;
import emac.entity.orderdetail;

public interface orderservice {

	public void saveOrder(emac.entity.order abc);
	public void saveOrderDetail(orderdetail def);
	public void deleteOrder(int no);
	public void deleteOrderDetail(int no);
	public List<order> selectOrderALL();
	public List<orderdetail> selectOrderDetailALL();
}
