package api;

import com.google.inject.Inject;
import dao.FactoryDao;
import dao.ProductDao;
import model.Factory;
import model.Product;

import javax.ws.rs.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Path("/product")
public final class ProductApi {
    @Inject
    private ProductDao productDao;

    @Inject
    private FactoryDao factoryDao;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(){
        return Response
                .ok(productDao.readAll())
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }

    @POST
    public Response deleteProductByName(@QueryParam("name") String name){
        Integer modifiedRows = productDao.deleteProduct(name);
        return modifiedRows > 0 ? Response.ok().build() : Response.status(404).build();
    }

    @GET
    @Path("/byCompany")
    public Response getProductsByFactoryName(@QueryParam("name") String name){
        List<Product> productsByFactoryName = productDao.findProductsByFactoryName(name);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writeValue(out, productsByFactoryName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] data = out.toByteArray();

        return Response.ok(new String(data))
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .build();
    }

    @POST
    @Path("/create")
    public Response createProduct(@QueryParam("name") String name, @QueryParam("factoryName") String factoryName, @QueryParam("count") Integer count){
        Factory factory = factoryDao.read(factoryName);
        if (factory == null){
            String rand = String.valueOf((Math.random() * (100 - 1)) + 1);
            String address = "address" + rand;
            factoryDao.create(new Factory(factoryName, address));
        }

        productDao.create(new Product(0, name, factoryName, count));
        return Response.ok().build();
    }
}
