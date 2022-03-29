package com.example.vmware.services;

import com.example.vmware.exceptions.AppException;
import com.example.vmware.rest.Request;
import com.example.vmware.rest.Response;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
public interface PlannerService {

    Response planTour(Request request) throws AppException;
}
