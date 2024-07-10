package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emac.entity.order;
import emac.entity.orderdetail;
import emac.repository.orderrepository;

@Component
public class orderserviceimpl {

	@Autowired
	private orderrepository repo;

	public void saveOrder(emac.entity.order abc) {
		// TODO Auto-generated method stub
		repo.saveOrder(abc);
	}

	public void saveOrderDetail(orderdetail def) {
		// TODO Auto-generated method stub
		repo.saveOrderDetail(def);
	}
	public void deleteOrder(int no){
		repo.deleteOrder(no);
	}
	public void deleteOrderDetail(int no){
		repo.deleteOrderDetail(no);
	}
	public List<order> selectOrderALL(){
		
		return repo.selectOrderAll();
	}
	public List<orderdetail> selectOrderDetailALL(){
		
		return repo.selectOrderDetailAll();
	}
	


	
	
}
