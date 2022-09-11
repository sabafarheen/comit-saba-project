package org.comit.course.dao.mapper;

import java.sql.ResultSet;

public class InventoryMapper implements RowMapper<Inventory> {

	@Override
	public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {

		Inventory inventory = new Inventory();

		inventory.setIn_Id(rs.getInt("IN_ID"));
		inventory.setIn_Name(rs.getString("IN_NAME"));
		inventory.setCategory(rs.getString("CATEGORY"));
		inventory.setUsername(rs.getString("USERNAME"));
		inventory.setQuantity(rs.getInt("QUANTITY"));
		inventory.setStatus(rs.getString("STATUS"));
		inventory.setPassword(rs.getString("PASSWORD"));

		return inventory;
	}

}