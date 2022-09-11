package org.comit.course.service;

import java.util.List;


@Service
public class inventoryService {
	@Autowired
	inventoryDao inventoryDao;
	
	
	public List<Inventory> listInventory(){

		List<inventory> inventories = inventoryDao.listinventories();

		inventories.forEach(System.out::println);

		inventories.removeIf(inventory-> !"A".equals(inventory.getStatus()));

		return inventories;
	}

	public inventory findinventory(int idinventory) {

		return inventoryDao.findinventory(idinventory);
	}

	public void createinventory(inventory inventory) {

		this.validateinventory(inventory);
		inventory.setStatus("I");
        inventoryDao.createinventory(inventory);
	}

    public void modifyinventory(inventory inventory) {

    	this.validateinventory(inventory);
    	inventoryDao.modifyinventory(inventory);
    }

    public void deleteinventory(int idinventory) {

    	inventoryDao.deleteinventory(idinventory);
    }

    private void validateinventory(inventory inventory) {

    	if (inventory.getInName().isEmpty() ||
    		inventory.getCategory().isEmpty() ||
    		inventory.getinventoryname().isEmpty()) {
    		throw new RuntimeException("Invalid inventory Data " + inventory);
    	}
    }
}

}
