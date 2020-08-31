package com.c0520k1.controller;

import com.c0520k1.model.Product;
import com.c0520k1.service.ProductService;
import com.c0520k1.service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = "/products")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" :
                addProduct(request,response);
                break;
            case "edit":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;

        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error-404.jsp");
        } else {
            this.productService.remove(id);
        }
        response.sendRedirect("/products");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description =request.getParameter("description");
        String brand =request.getParameter("brand");

        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error-404.jsp");
        } else {
            product.setName(name);
            product.setPrice(price);
            product.setDescription(description);
            product.setBrand(brand);
            this.productService.update(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","Product information was updated");
            dispatcher = request.getRequestDispatcher("WEB-INF/views/product/edit.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = (int) (Math.random()*1000);
        String name =request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description =request.getParameter("description");
        String brand =request.getParameter("brand");

        Product product = new Product(id,name,price,description,brand);
        productService.save(product);
        request.setAttribute("message","Thêm thành công ");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/product/create.jsp");
        dispatcher.forward(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormEdit(request,response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }

    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error-404.jsp");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/views/product/delete.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void viewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error-404.jsp");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/views/product/view.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;

        if (product == null) {
            dispatcher = request.getRequestDispatcher("WEB-INF/views/error-404.jsp");
        } else {
            request.setAttribute("product",product);
            dispatcher = request.getRequestDispatcher("WEB-INF/views/product/edit.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.findALlProduct();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/product/list.jsp");
        dispatcher.forward(request,response);

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/product/create.jsp");
        dispatcher.forward(request,response);
    }
}

