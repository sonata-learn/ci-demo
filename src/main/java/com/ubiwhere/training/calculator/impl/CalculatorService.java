package com.ubiwhere.training.calculator.impl;

import com.ubiwhere.training.calculator.api.ResultRepresentation;
import com.ubiwhere.training.calculator.logic.CalculatorLogic;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/structured")
public class CalculatorService {
    
    private static final Logger LOG = Logger.getLogger(CalculatorService.class.getName());
    
    @Inject
    CalculatorLogic calculator;
    
    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSum(@QueryParam("a") Integer a, @QueryParam("b") Integer b) {
        ResultRepresentation sum = new ResultRepresentation(calculator.add(a, b));
        LOG.info("Returning sum: " + sum.getResult());
        return Response.ok(sum).build();
    }
    
}
