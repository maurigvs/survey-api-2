package br.com.maurigvs.controller;

import br.com.maurigvs.model.dto.SurveyDto;
import br.com.maurigvs.service.SurveyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("api/survey")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class SurveyController {

    @Inject
    SurveyService surveyService;

    @POST
    @Transactional
    public Response postSurvey(SurveyDto dto){
        surveyService.createSurvey(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getSurveys(){
        return Response.ok(surveyService.findAll()).build();
    }
}