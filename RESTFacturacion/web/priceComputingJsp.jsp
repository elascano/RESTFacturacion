<%-- 
    Document   : priceComputingJsp
    Created on : Dec 12, 2017, 12:39:14 PM
    Author     : elascano
--%>

<%@page import="pojos.Product"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="utils.RestClient"%>
<%@page import="sun.net.www.http.HttpClient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Total Price Computing </title>
    </head>
    <body>
        <h1>A JSP computing the total price!</h1>
        
        <form method ="get">
            Enter the id: <input type="text" name="id" value="0">
            <input type="submit" value="Compute">
        </form>


        <%
            String id = request.getParameter("id");

            try{
            String json = RestClient.doGet("http://localhost:8080/RESTMedicinas/productos/" + id);
            //out.println(json);
            
            Gson gson = new Gson();
            
            Product p = new Product();
            p = gson.fromJson(json, Product.class);
            float price = p.getPrice() * p.getQuantity();
            
            out.println("id --> " + id + "</br>");
            
            out.println("the price of (" + p.getQuantity() + ") " + p.getName() + "s, is --> " + String.format("%.02f", price) );
            
            } catch(Exception ex) {
                System.out.println("Error accessing the REST ");
                ex.printStackTrace();
            }

        %>


    </body>
</html>
