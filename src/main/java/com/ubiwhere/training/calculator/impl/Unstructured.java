package com.ubiwhere.training.calculator.impl;

import com.ubiwhere.training.calculator.api.OperationResult;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/unstructured")
public class Unstructured {
    private static final Logger LOG = Logger.getLogger(Unstructured.class.getName());

    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        OperationResult sum = new OperationResult(a+b);
        LOG.info("Returning sum: " + sum.getResult() );
        return Response.ok(sum).build();
    }

}
