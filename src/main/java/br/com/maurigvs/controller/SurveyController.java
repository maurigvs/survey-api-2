package br.com.maurigvs.controller;

import br.com.maurigvs.model.dto.SurveyDto;
import br.com.maurigvs.model.entity.Survey;
import br.com.maurigvs.service.SurveyService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("api/survey")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class SurveyController {

    @Inject
    SurveyService surveyService;


    @Tag(name = "survey")
    @Operation(summary = "Creates a new survey")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Survey created"),
            @APIResponse(responseCode = "400", description = "Bad Request. Required information is missing.")
    })
    @POST
    @Transactional
    public Response postSurvey(SurveyDto dto){
        surveyService.createSurvey(dto);
        return Response.status(Response.Status.CREATED).build();
    }

    @Tag(name = "survey")
    @Operation(summary = "List all the surveys available")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Surveys listed", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Survey.class))
            })
    })
    @GET
    public Response getSurveys(){
        return Response.ok(surveyService.findAll()).build();
    }
}