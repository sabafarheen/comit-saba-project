package org.comit.course.security;

import java.util.Collection;

import org.comit.course.bean.Inventory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.inventorydetails.InventoryDetails;

public class CustomUserDetails implements InventoryDetails{

	private static final long serialVersionUID = 1L;

	Inventory inventory;

	public CustomUserDetails(Inventory inventory) {
		super();
		this.inventory = inventory;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.inventory.getPassword();
	}

	@Override
	public String getUsername() {
		return this.inventory.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return "I".equalsIgnoreCase(this.user.getStatus());
	}

}