package com.metacube.Shopping.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.metacube.Shopping.dto.ProductDto;
import com.metacube.Shopping.facade.ProductFacade;
import com.metacube.Shopping.spring.Factory;



@Path("/product")
public class ProductController
{
    ProductFacade productFacade;

    public ProductController() {
        
        productFacade =Factory.getApplicationContext().getBean("productFacade",ProductFacade.class);
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(productFacade.deleteProduct(id)).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(ProductDto product) {
        return Response.status(Response.Status.OK).entity(productFacade.saveProduct(product)).build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editProduct(ProductDto product,@PathParam("id") int id) {
        return Response.status(Response.Status.OK).entity(productFacade.editProduct(product,id)).build();
    }
    
}