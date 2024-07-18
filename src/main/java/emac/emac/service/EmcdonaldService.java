package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import emac.entity.Emcdonald;
import emac.repository.EmcdonaldRepository;

@Component
public class EmcdonaldService {
	@Autowired
	private EmcdonaldRepository emcdonaldRepository;
	
	public void registOrder(Emcdonald emcdonald) {
		emcdonaldRepository.registOrder(emcdonald);
	}

	public List<Emcdonald> getOrderList() {
		// TODO Auto-generated method stub
		return emcdonaldRepository.getOrderList();
	}

	public List<Emcdonald> emcdonaldDetail(Model model, String menu_name) {
		return emcdonaldRepository.emcdonaldDetail(model,menu_name);
		
	}
	public List<Emcdonald> getOrder() {
		// TODO Auto-generated method stub
		return emcdonaldRepository.getOrder();
	}
public List<Integer> getTenData() {
		
		return emcdonaldRepository.getTenData();
	}

public List<Integer> getThreeMonth() {
	
	return emcdonaldRepository.getThreeMonth();
}

public void emcdonaldDelete(Model model, String customer_id) {
	emcdonaldRepository.emcdonaldDelete(model,customer_id);	
}

}
