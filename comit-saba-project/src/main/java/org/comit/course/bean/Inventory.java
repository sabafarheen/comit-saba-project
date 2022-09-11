package org.comit.course.bean;

import java.util.Date;

public class Inventory {

	int idInventory;
	String in_Name;
	String category;
	String username;
	int quantity;
	String status;
	String password;
	

	public Inventory() {

	}
	public Inventory(int idInventory, String in_Name, String category, String username, int quantity, String status, String password) {
		super();
		this.idInventory = idInventory;
		this.in_Name = in_Name;
		this.category = category;
		this.username = username;
		this.quantity = quantity;
		this.status = status;
		this.password = password;
	}

	public int getIdInventory() {
		return idInventory;
	}
	public void setIdInventory(int idInventory) {
		this.idIventory = idInventory;
	}
	public String getIn_Name) {
		return in_Name;
	}
	public void setIn_Name(String in_Name) {
		this.in_Name = in_Name;
	}
	public String getCategory
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (idInventory != other.idInventory)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [idInventory=" + idInventory + ", in_Name=" + in_Name + ", category=" + category + ", username="
				+ username + ",quantity=" + quantity +", status=" + status + ", password=" + password + "]";
	}
}