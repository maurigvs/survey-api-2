package br.com.maurigvs.service;

import br.com.maurigvs.model.dto.SurveyDto;
import br.com.maurigvs.model.entity.Survey;
import br.com.maurigvs.repository.SurveyRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class SurveyService {

    @Inject
    SurveyRepository surveyRepository;

    public void createSurvey(SurveyDto dto){
        Survey survey = new Survey(dto);
        surveyRepository.persist(survey);
    }

    public List<Survey> findAll(){
        return surveyRepository.findAll().stream().toList();
    }
}