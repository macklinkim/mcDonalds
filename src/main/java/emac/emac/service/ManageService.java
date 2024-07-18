package emac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import emac.entity.HappyEntity;
import emac.entity.MenuEntity;
import emac.entity.SnackEntity;
import emac.repository.ManageRepositry;

@Component
public class ManageService {

	@Autowired
	private ManageRepositry manageRep;

	public List<MenuEntity> selectAll() {
		return manageRep.selectAll();
	}
	public List<HappyEntity> selectAll2() {
		return manageRep.selectAll2();
	}
	public List<SnackEntity> selectAll3() {
		return manageRep.selectAll3();
	}
	
	
}
