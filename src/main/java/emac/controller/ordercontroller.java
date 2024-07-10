package emac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import emac.entity.orderdetail;
import emac.service.orderserviceimpl;

@Controller
public class ordercontroller {

	@Autowired
	private orderserviceimpl impl;
	
	@RequestMapping(value="/orderform")
	public String orderform(Model model){
		
		model.addAttribute("orderform", new emac.entity.order());
		return "views/orderForm";
	}
	@RequestMapping(value="/order")
	public String order(Model model, @ModelAttribute("orderform") emac.entity.order abc){
		
		impl.saveOrder(abc);
		model.addAttribute("order", abc);
		model.addAttribute("orderdetail", new orderdetail());
		return "views/orderDetailForm";
	}
	@RequestMapping(value="/orderdetailform")
	public String orderDetailForm(Model model, @ModelAttribute("orderdetail")emac.entity.orderdetail def){
		impl.saveOrderDetail(def);
		model.addAttribute("check", def);
		return "views/orderCheck";
	}
	
}
