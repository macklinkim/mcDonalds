package emac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import emac.entity.HappyEntity;
import emac.entity.MenuEntity;
import emac.entity.SnackEntity;
import emac.service.ManageService;

@Controller
public class ManageController {

	@Autowired
	private ManageService service;
	
	@RequestMapping("/menuList")
	public String menuList(Model model){
		List<MenuEntity> menuList = service.selectAll();
		model.addAttribute("menuList", menuList);
		return "/views/menuList";
	}
	
	@RequestMapping("menu_happy")
	public String menu_happy(Model model) {
		List<HappyEntity> happyList = service.selectAll2();
		model.addAttribute("happyList", happyList);
		return "views/menu_happy";
	}
	
	@RequestMapping("menu_snack")
	public String menu_snack(Model model) {
		List<SnackEntity> snackList = service.selectAll3();
		model.addAttribute("snackList", snackList);
		return "views/menu_snack";
	}
}
