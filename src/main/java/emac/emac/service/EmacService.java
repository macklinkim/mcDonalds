package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emac.entity.CustomerEntity;
import emac.entity.Emcdonald;
import emac.entity.EmployeeEntity;
import emac.entity.UserEntity;
import emac.repository.EmacRepository;

@Component
public class EmacService {
	@Autowired
	EmacRepository emacRepository;

	public void customerReg(CustomerEntity customer) {
		emacRepository.customerReg(customer);
	}

	public UserEntity customerCheck(UserEntity user) {
		return emacRepository.customerCheck(user);
	}

	public void employeeReg(EmployeeEntity employee) {
		emacRepository.employeeReg(employee);
	}
	
	public EmployeeEntity employeeCheck(UserEntity user) {
		return emacRepository.employeeCheck(user);
	}

	public List<EmployeeEntity> employeeList() {
		return emacRepository.employeeList();
	}

	public void infoChange(String password, String name, String phone,String address, String id) {
		emacRepository.infoChange(password,name,phone,address,id);
	}

	public void dropOut(CustomerEntity ce) {
		emacRepository.dropOut(ce);
	}

	public List<Emcdonald> personalOrderList(CustomerEntity ce) {
		return emacRepository.personalOrderList(ce);
	}

	public List<CustomerEntity> customerList() {
		return emacRepository.customerList();
	}

	public void userDelete(String id) {
		emacRepository.userDelete(id);
	}

	
}
