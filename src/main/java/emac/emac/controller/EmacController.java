package emac.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import emac.entity.CustomerEntity;
import emac.entity.Emcdonald;
import emac.entity.EmployeeEntity;
import emac.entity.MenuEntity;
import emac.entity.UserEntity;
import emac.service.EmacService;

@Controller
public class EmacController {
	
	@Autowired
	EmacService emacService;
	
	@RequestMapping("customerList")
	public String customerList(Model model) {
		List<CustomerEntity> customerList = emacService.customerList();
		model.addAttribute("customerList", customerList);
		return "/views/customerList";
	}
	@RequestMapping("userDelete")
	public String userDelete(@RequestParam String id) {
		emacService.userDelete(id);
		return "redirect:customerList";
	}
	
	@RequestMapping("personalOrderList")
	public String personalOrderList(HttpSession session,Model model) {
		CustomerEntity ce = (CustomerEntity) session.getAttribute("customer");
		List<Emcdonald> customerList = emacService.personalOrderList(ce);
		model.addAttribute("emcdonaldOrderlist", customerList);
		return "views/personalOrderList";
	}
	
	@RequestMapping("dropOut")
	public String dropOut(HttpSession session) {
		CustomerEntity ce = (CustomerEntity) session.getAttribute("customer");
		emacService.dropOut(ce);
		session.invalidate();
		return "redirect:main.jsp";
	}
	
	@RequestMapping("userInfoChange")
	public String userInfoChange(HttpSession session,Model model) {
		CustomerEntity ce = (CustomerEntity)session.getAttribute("customer");
		model.addAttribute("infoChange", ce);
		return "/views/userInfoChange";
	}
	
	@RequestMapping("infoChangeResult")
	public String infoChangeResult(HttpSession session,@RequestParam String password,String name,String phone,String address) {
		CustomerEntity ce = (CustomerEntity) session.getAttribute("customer");
		emacService.infoChange(password,name,phone,address,ce.getId());
		session.invalidate();
		return "redirect:main.jsp";
	}
	
	@RequestMapping("loginproc")
	public String login() {
		return "/views/login";
	}
	@RequestMapping("myPage")
	public String myPage() {
		return "/views/myPage";
	}
	@RequestMapping("customerRegForm")  //main의 회원가입링크 -> 고객회원가입 폼
	public String customerRegForm(Model model) {
		model.addAttribute("customer", new CustomerEntity());
		return "/views/customerRegForm";
	}
	@RequestMapping("customerRegResult") //고객회원가입폼의 등록 -> 고객등록결과
	public String customerRegResult(@ModelAttribute CustomerEntity customer,Model model) {
		emacService.customerReg(customer);
		return "redirect:main.jsp";
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
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.jsp";	}
	@RequestMapping("employeeList")
	public String employeeList(Model model) {
		List<EmployeeEntity> employeeList = emacService.employeeList();
		model.addAttribute("employeeList", employeeList);
		return "views/employeeList";
	}
//	@RequestMapping("orderform")
//	public String orderform() { return "views/orderform"; }
}

