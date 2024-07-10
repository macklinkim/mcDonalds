package emac.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import emac.entity.Emcdonald;
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
	public String getBoardList(Model model){
		model.addAttribute("emcdonaldOrderlist",emcdonaldService.getOrderList());
		return "views/emcdonaldOrderlist";
	}
	@RequestMapping("emcdonaldDetail/{menu_name}")
	public String emcdonaldDetail(@PathVariable(value="menu_name")String menu_name, Model model){
		emcdonaldService.emcdonaldDetail(model, menu_name);
		return "/views/emcdonaldDetail";
	}
}
