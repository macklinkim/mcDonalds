package emac.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import emac.entity.Emcdonald;
import emac.entity.orderdetail;
import emac.service.EmcdonaldService;


@Controller
public class EmcdonaldController {
	@Autowired
	private EmcdonaldService emcdonaldService;
	
	@RequestMapping("/emcdonaldOrder")
	public String emcdonaldOrder(Model model){
		model.addAttribute("emcdonald", new Emcdonald());
		return "views/emcdonaldOrder";
	}
	
	@RequestMapping("/orderRegResult")
	public String orderRegResult(@Valid@ModelAttribute Emcdonald emcdonald , BindingResult result){
		if(result.hasErrors()){
			return "views/emcdonaldOrder";
		}else{
			emcdonaldService.registOrder(emcdonald);
			return "views/orderResult";
		}		
	}
	@RequestMapping("/emcdonaldOrderlist")
	public String getBoardList(Model model,HttpSession session){
		model.addAttribute("emcdonaldOrderlist",emcdonaldService.getOrderList());
		orderdetail order =(orderdetail)session.getAttribute("revenue");
	
		return "views/emcdonaldOrderlist";
	}
	@RequestMapping("emcdonaldDetail/{menu_name}")
	public String emcdonaldDetail(@PathVariable(value="menu_name")String menu_name, Model model){
		model.addAttribute("emcdonald", new Emcdonald());
		emcdonaldService.emcdonaldDetail(model, menu_name);
		return "/views/emcdonaldDetail";
	}
	@RequestMapping("emcdonaldDelete/{customer_id}")
	public String emcdonaldDelete(@PathVariable(value="customer_id")String customer_id, Model model){
		model.addAttribute("emcdonald", new Emcdonald());
		emcdonaldService.emcdonaldDelete(model, customer_id);
		return "redirect:/orderList";
	}

	@RequestMapping(value="/orderList")
	public String selectOrderForm1(Model model){
		model.addAttribute("emcdonald", new Emcdonald());
		model.addAttribute("emcdonaldOrderlist",emcdonaldService.getOrder());
		return "views/orderView";
	}
	@RequestMapping("graph")
	public String goGraph(Model model){
		List<Integer> graphTen = emcdonaldService.getTenData();
		model.addAttribute("graphTen",graphTen);
		List<Integer> graphMonth = emcdonaldService.getThreeMonth();
		model.addAttribute("graphMonth",graphMonth);
		
		return "views/graph";
	}
}