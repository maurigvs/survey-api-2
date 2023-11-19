package br.com.maurigvs.model.dto;

import java.util.List;

public class SurveyDto {

    private String survey;
    private List<QuestionDto> questions;

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
