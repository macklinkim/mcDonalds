package emac.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import emac.entity.CustomerEntity;
import emac.entity.EmployeeEntity;
import emac.entity.UserEntity;
import emac.service.EmacService;

@Controller
public class EmacController {
	
	@Autowired
	EmacService emacService;
	
	@RequestMapping("customerRegForm")  //main의 회원가입링크 -> 고객회원가입 폼
	public String customerRegForm(Model model) {
		model.addAttribute("customer", new CustomerEntity());
		return "/views/customerRegForm";
	}
	@RequestMapping("customerRegResult") //고객회원가입폼의 등록 -> 고객등록결과
	public String customerRegResult(@ModelAttribute CustomerEntity customer,Model model) {
		emacService.customerReg(customer);
		return "/views/customerRegResult";
	}
	@RequestMapping("employeeRegForm") //관리자 main의 관리자회원가입링크-> 관리자회원가입 폼 
	public String employeeRegForm(Model model) {
		model.addAttribute("employee", new EmployeeEntity());
		return "/views/employeeRegForm";
	}
	@RequestMapping("employeeRegResult") //고객회원가입폼의 등록 -> 고객등록결과
	public String employeeRegResult(@ModelAttribute EmployeeEntity employee,Model model) {
		emacService.employeeReg(employee);
		return "/views/employeeRegResult";
	}
	@RequestMapping("login") //main의 로그인 -> 로그인 된 main
	public String login(HttpSession session, @ModelAttribute UserEntity user) {
		CustomerEntity customer = (CustomerEntity)emacService.customerCheck(user);
		EmployeeEntity employee = (EmployeeEntity)emacService.employeeCheck(user);
		if(employee == null && customer != null){
			session.setAttribute("customer", customer);
			return "redirect:main.jsp";}
		else if(customer == null && employee != null){
			session.setAttribute("employee", employee);
			return "redirect:main.jsp";}
		else return "/views/loginFail";
	}
	@RequestMapping("logout") // 로그인 된 main -> logout
	public String logout() {		return "views/logout";	}
	@RequestMapping("employeeList")
	public String employeeList(Model model) {
		List<EmployeeEntity> employeeList = emacService.employeeList();
		model.addAttribute("employeeList", employeeList);
		return "views/employeeList";
	}
//	@RequestMapping("orderform")
//	public String orderform() { return "views/orderform"; }
	
}

