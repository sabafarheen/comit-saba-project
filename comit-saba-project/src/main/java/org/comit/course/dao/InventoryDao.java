package org.comit.course.dao;

import java.util.List;

import org.comit.course.bean.Inventory;
import org.comit.course.dao.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryDao {

	List<Inventory> inventory;

	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<Inventory> listInventory(){

		String sql = "SELECT * FROM INVENTORY";

		return jdbcTemplate.query(sql, new InventoryMapper());
	}

	public Inventory findUser(int idUser) {

		String sql = "SELECT * FROM INVENTORY WHERE IN_ID = ?";

		return jdbcTemplate.queryForObject(sql, new InventoryMapper(), in_Id);
	}

	public Inventory findByUsername(String username) {

		String sql = "SELECT * FROM INVENTORY WHERE USERNAME = ?";

		List<Inventory> inventory = jdbcTemplate.query(sql, new InventoryMapper(), username);

		return inventory.isEmpty()?null:inventory.get(0);
	}

	public void createInventory(Inventory inventory) {

        String sql = "INSERT INVENTORY(USERNAME,PASSWORD,IN_NAME,CATEGORY,QUANTITY,STATUS) " +
                     "VALUES(?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {inventory.getUsername(), inventory.getPassword(), inventory.getIn_Name(),
        		                              inventory.getCategory(), inventory.getQuantity(), inventory.getStatus()});
	}

    public void modifyUser(Inventory inventory) {

        String sql = "UPDATE INVENTORY SET USERNAME = ?, IN_NAME = ?, CATEGORY = ?, QUANTITY= ?, STATUS= ?" +
                     "WHERE IN_ID= ?";

        jdbcTemplate.update(sql,new Object[] {inventory.getUsername(), inventory.getIn_Name(),
        		inventory.getCategory(), inventory.Quantity(),inventory.Status(), inventory.getIn_Id()});
    }

    public void deleteInventory(int In_Id) {

		String sql = "DELETE FROM INVENTORY WHERE IN_ID = ?";

        jdbcTemplate.update(sql,new Object[] {idInventory});
    }



}
