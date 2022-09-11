package org.comit.course.dao;

import java.util.List;

import org.comit.course.bean.Inventory;
import org.comit.course.dao.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryDao {

	List<Inventort> inventory;

	@Autowired
	JdbcTemplate jdbcTemplate;


	public List<Inventory> listInventory(){

		String sql = "SELECT * FROM INVENTORY";

		return jdbcTemplate.query(sql, new InventoryMapper());
	}

	public Inventory findUser(int idUser) {

		String sql = "SELECT * FROM INVENTORY WHERE IN_ID = ?";

		return jdbcTemplate.queryForObject(sql, new InventryMapper(), idInventory);
	}

	public Inventory findByUsername(String username) {

		String sql = "SELECT * FROM INVENTORY WHERE USERNAME = ?";

		List<Inventory> inventory = jdbcTemplate.query(sql, new InventoryMapper(), username);

		return inventory.isEmpty()?null:inventory.get(0);
	}

	public void createUser(User user) {

        String sql = "INSERT INVENTORY(USERNAME,PASSWORD,IN_NAME,CATEGORY,QUANTITY,STATUS) " +
                     "VALUES(?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql,new Object[] {inventory.getUsername(), user.getPassword(), user.getIn_Name(),
        		                              user.geCategory(), user.getQuantity(), user.getStatus()});
	}

    public void modifyUser(Inventory inventory) {

        String sql = "UPDATE INVENTORY SET USERNAME = ?, IN_NAME = ?, CATEGORY = ?, QUANTITY= ?, STATUS= ?" +
                     "WHERE IN_ID= ?";

        jdbcTemplate.update(sql,new Object[] {inventory.getUsername(), inventory.getIn_Name(),
        		inventory.getCategory(), inventory.Quantity(),inventory.Status(), inventory.getIn_Idr()});
    }

    public void deleteInventory(int In_Id) {

		String sql = "DELETE FROM INVENTORY WHERE IN_ID = ?";

        jdbcTemplate.update(sql,new Object[] {In_Id});
    }



}
