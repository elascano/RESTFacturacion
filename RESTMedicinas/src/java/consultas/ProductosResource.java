/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import pojos.Product;

/**
 * REST Web Service
 *
 * @author elascano
 */
@Path("productos")
public class ProductosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductosResource
     */
    public ProductosResource() {
    }

    /**
     * Retrieves representation of an instance of consultas.ProductosResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String products = "["
                + "{"
                + "\"id\": \"01\","
                + "\"name\": \"aspirin\","
                + "\"quantity\": \"20\","
                + "\"price\": \"25.34\","
                + "\"tags\": [\"headache\",\"white\"]"
                + "},"
                + "{"
                + "\"id\": \"02\","
                + "\"name\": \"finalin\","
                + "\"quantity\": \"100\","
                + "\"price\": \"14.34\","
                + "\"tags\": [\"headache\",\"ache\"]"
                + "}"
                + "]";

        return products;
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductJson(@PathParam("id") String id) {

        Gson gson = new Gson();
        String product = "";
        if (id.equals("1")) {
            product = "{"
                    + "\"id\": \"01\","
                    + "\"name\": \"aspirin\","
                    + "\"quantity\": \"20\","
                    + "\"price\": \"25.34\","
                    + "\"tags\": [\"headache\",\"white\"]"
                    + "}";

            //Product productTmp = new Product();
            Product productTemp = gson.fromJson(product, Product.class);

            System.out.println("the id is " + productTemp.getId());
            System.out.println("name " + productTemp.getName());
            System.out.println("quantity " + productTemp.getQuantity());
            System.out.println("price " + productTemp.getPrice());
            System.out.println("tags " + productTemp.getTags()[0] + " " + productTemp.getTags()[1]);

        } else if (id.equals("2")) {
            product = "{"
                    + "\"id\": \"02\","
                    + "\"name\": \"finalin\","
                    + "\"quantity\": \"100\","
                    + "\"price\": \"14.34\","
                    + "\"tags\": [\"headache\",\"ache\"]"
                    + "}";
        } else if (id.equals("3")) {

            String[] tmpTag = new String[2];
            tmpTag[0] = "head";
            tmpTag[1] = "ache";

            Product productPojo = new Product(3, "advil", 10, 12.12F, tmpTag);

            String jsonInString = gson.toJson(productPojo);
            product = jsonInString;
        }

        return product;
    }

    /**
     * PUT method for updating or creating an instance of ProductosResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
