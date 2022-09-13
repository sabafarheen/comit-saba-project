package org.comit.course.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.comit.course.bean.Inventory;
import org.comit.course.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InventoryController {

	@Autowired
	Inventoryservice inventoryService;

	@GetMapping({"/","/index"})
	public String index() {
		System.out.println("Show Index Page");

		return "index";
	}

	@GetMapping("/list")
	public ModelAndView listUsers() {
		System.out.println("Inventory List");

		List<Inventory> inventories = this.inventoryService.listInventory();

		return new ModelAndView("list","inventories", inventories);
	}

	@GetMapping("/create")
	public String showCreate() {
		System.out.println("Show Create");

		return "create";
	}

	@PostMapping("/create")
	public String createUser(HttpServletRequest request) {
		System.out.println("Create Inventory");

		String in_name = request.getParameter("in_name");
		String category = request.getParameter("category");
		String username = request.getParameter("username");
		String quantity = request.getParameter("quantity");
		String status = request.getParameter("status");
		String password = request.getParameter("password");
		

        Inventory inventory = this.createInventory(null,in_name, category, username,quantity,status, password);

        this.inventoryService.createInventory(inventory);

		return "redirect:/list";
	}

	@GetMapping("/update/{in_id}")
	public ModelAndView showUpdate(@PathVariable("in_id") int in_id) {

		System.out.println("Show Update");

		Inventory inventory = this.inventoryService.findInventory(in_id);

		return new ModelAndView("update","inventory",inventory);
	}

	@PostMapping("/update")
	public String updateUser(HttpServletRequest request) {
		System.out.println("Update Inventory");

		String in_id = request.getParameter("in_id");
		String in_name = request.getParameter("in_name");
		String category = request.getParameter("category");
		String username = request.getParameter("username");
		String quantity = request.getParameter("quantity");
		String status = request.getParameter("status");
		String password = request.getParameter("password");

		Inventory inventory = this.createInventory(in_id,in_name, category, username,quantity,status,password);

		this.inventoryService.modifyInventoryser(inventory);

		return "redirect:/list";
	}

	@GetMapping("/delete/{in_id}")
	public String deleteUser(@PathVariable("in_id") int in_id) {
		System.out.println("Delete Item");

		this.inventoryService.deleteInventory(in_id);

		return "redirect:/list";
	}

	private Inventory createInventory(String in_id, String in_name, String category, String username, String quantity, String status, String password) {

		Inventory inventory = new Inventory(Util.parseId(in_id),in_name.trim(),category.trim(),username.trim(),Util.parseQuantity(quantity),status.trim(),password);

		return inventory;
	}

}
