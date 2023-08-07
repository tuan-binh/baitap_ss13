package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Home", value = "/Home")
public class ProductController extends HttpServlet {
	
	private final ProductService productService = new ProductService();
	private int page = 1;
	private final int limit = 3;
	private int pages;
	private int count = 0;
	private int myPage = limit;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action == null) {
			showListProduct(req, resp);
		} else {
			switch (action) {
				case "EDIT":
					System.out.println("ID: " + req.getParameter("id"));
					System.out.println("ACtion : " + action);
					Product product = productService.findById(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("data", product);
					req.getRequestDispatcher(req.getContextPath() + "/view/editProduct.jsp").forward(req, resp);
					break;
				case "DELETE":
					productService.delete(Integer.parseInt(req.getParameter("id")));
					break;
				case "DETAIL":
					Product detail = productService.findById(Integer.parseInt(req.getParameter("id")));
					req.setAttribute("data", detail);
					req.getRequestDispatcher(req.getContextPath() + "/view/detailProduct.jsp").forward(req, resp);
					break;
				case "PREV":
					if (page != 1) {
						--page;
						count -= limit;
						myPage -= limit;
					}
					break;
				case "NEXT":
					if (page != pages) {
						++page;
						count += limit;
						myPage += limit;
					}
					break;
				default:
					break;
			}
			showListProduct(req, resp);
			resp.sendRedirect(req.getContextPath() + "/Home");
		}
	}
	
	public void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		pages = productService.getList().size() / limit + ((productService.getList().size() % limit == 0) ? 0 : 1);
		
		req.setAttribute("page", page);
		req.setAttribute("pages", pages);
		
		List<Product> panigationProducts = new ArrayList<>();
		for (int i = count; i < myPage; i++) {
			try {
				panigationProducts.add(productService.getList().get(i));
			} catch (IndexOutOfBoundsException ignored) {
			
			}
		}
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("listProduct", panigationProducts);
		req.getRequestDispatcher(req.getContextPath() + "/view/products.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		switch (action) {
			case "ADD":
				Product product = new Product(req.getParameter("name"), req.getParameter("desc"), Double.parseDouble(req.getParameter("price")));
				
				productService.save(product);
				break;
			case "UPDATE":
				System.out.println("action " + action);
				Product newProduct = new Product(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("desc"), Double.parseDouble(req.getParameter("price")));
				System.out.println("ID ->> " + newProduct.getId());
				productService.save(newProduct);
				break;
			case "SEARCH":
				String text = req.getParameter("search");
				List<Product> list = new ArrayList<>();
				for (Product p : productService.getList()) {
					if (p.getName().toLowerCase().contains(text.toLowerCase()) ||
							  p.getDescription().toLowerCase().contains(text.toLowerCase()) ||
							  String.valueOf(p.getPrice()).contains(text.toLowerCase())) {
						list.add(p);
					}
				}
				String sort = req.getParameter("option");
				switch (sort) {
					case "STT":
						productService.sort("STT");
						break;
					case "NAME":
						productService.sort("NAME");
						break;
					case "PRICE":
						productService.sort("PRICE");
						break;
					default:
						break;
				}
				if (text.trim().equals("")) {
					showListProduct(req, resp);
				}
				req.setAttribute("sort", sort);
				req.setCharacterEncoding("UTF-8");
				req.setAttribute("textSearch", text);
				req.setAttribute("listProduct", list);
				req.getRequestDispatcher(req.getContextPath() + "/view/products.jsp").forward(req, resp);
				
				
				break;
			default:
				break;
		}
		resp.sendRedirect(req.getContextPath() + "/Home");
	}
	
}
