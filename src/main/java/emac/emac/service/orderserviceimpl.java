package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emac.entity.CustomerEntity;
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

	public void saveOrderDetail(orderdetail def,CustomerEntity cs) {
		// TODO Auto-generated method stub
		
		if(def.getMenu().equals("set1")){
			int price=6500;
			def.setPrice(price);
		}
		else if(def.getMenu().equals("set2")){
			int price=6900;
			def.setPrice(price);
		}
		else if(def.getMenu().equals("set3")){
			int price=6300;
			def.setPrice(price);
		}	
		else if(def.getMenu().equals("set4")){
			int price=5500;
			def.setPrice(price);
		}
		else if(def.getMenu().equals("set5")){
			int price=7500;
			def.setPrice(price);
		}
		def.setAllprice(def.getAllprice());
		def.setTax(def.getTax());
		def.setRevenue(def.getRevenue());
		System.out.println(def.getAllprice()+"sdasdad");
		repo.saveOrderDetail(def,cs);
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

	public void saveOrderDetail(orderdetail def) {
		// TODO Auto-generated method stub
		repo.saveOrderDetail(def);
	}

}