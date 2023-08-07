package com.example.service;

import com.example.model.Product;
import com.example.utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService {
	
	private Connection con = ConnectDB.getConnection();
	private final String GET_ALL_USERS = "SELECT * FROM product";
	private final String GET_ALL_USERS_ORDER_BY = "SELECT * FROM product ORDER BY ?";
	private final String GET_USER_BY_ID = "SELECT * FROM product WHERE id = ?";
	private final String DELETE_BY_ID = "DELETE FROM product WHERE id = ?";
	private final String INSERT_USER = "INSERT INTO product (name,description,price) VALUES (?,?,?)";
	private final String UPDATE_USER = "UPDATE product SET name=?,description=?,price=? WHERE id = ?";
	
	public List<Product> getList() {
		List<Product> list = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(GET_ALL_USERS);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				list.add(new Product(id, name, description, price));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public void save(Product product) {
		if (product.getId() == 0) {
			try {
				PreparedStatement ps = con.prepareStatement(INSERT_USER);
				ps.setString(1, product.getName());
				ps.setString(2, product.getDescription());
				ps.setDouble(3, product.getPrice());
				ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} else {
			try {
				PreparedStatement ps = con.prepareStatement(UPDATE_USER);
				ps.setString(1, product.getName());
				ps.setString(2, product.getDescription());
				ps.setDouble(3, product.getPrice());
				ps.setInt(4, product.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}
	
	public void delete(int id) {
		try {
			PreparedStatement ps = con.prepareStatement(DELETE_BY_ID);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Product findById(int id) {
		System.out.println("ID: "+id);
		Product product = new Product();
		try {
			PreparedStatement ps = con.prepareStatement(GET_USER_BY_ID);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return product;
	}
	
	
	public void sort(String action) {
//        switch (action) {
//            case "STT":
//                list.sort(Comparator.comparingInt(Product::getId));
//                break;
//            case "NAME":
//                list.sort(Comparator.comparing(Product::getName).reversed());
//                break;
//            case "PRICE":
//                list.sort(Comparator.comparingDouble(Product::getPrice));
//                break;
//            default:
//                break;
//        }
	}
}
