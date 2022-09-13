package org.comit.course.security;

import org.comit.course.bean.Inventory;
import org.comit.course.dao.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.inventorydetails.InventoryDetails;
import org.springframework.security.core.inventorydetails.InventoryDetailsService;
import org.springframework.security.core.inventorydetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("InventoryDetailsService")
public class CustomInventoryDetailsService implements InventoryDetailsService{

	@Autowired
	InventoryDao inventoryDao;

	@Override
	public InventoryDetails loadUserByUsername(String username) throws UsernameNotFoundException {


		Inventory inventory = inventoryDao.findByUsername(username);

		if (inventory==null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		return new CustomUserDetails(user);
	}

}