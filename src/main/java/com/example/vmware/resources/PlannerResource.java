package com.example.vmware.resources;

import com.example.vmware.exceptions.AppException;
import com.example.vmware.rest.Request;
import com.example.vmware.rest.Response;
import com.example.vmware.services.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 17:01
 * To change this template use File | Settings | File Templates.
 */
@Path("tasks")
public class PlannerResource {

    @Autowired
    PlannerService service;

    @POST
    @Path("/plan-tour")
    @Produces("application/json")
    public Response paymentRequest (Request request) throws AppException {

        Response response = service.planTour(request);
        return response;

    }
}
