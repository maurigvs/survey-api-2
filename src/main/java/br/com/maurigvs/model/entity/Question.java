package br.com.maurigvs.model.entity;

import br.com.maurigvs.model.dto.QuestionDto;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
public class Question {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String title;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Choice> choices = new ArrayList<>();

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    public Question() {
    }

    public Question(QuestionDto dto, Survey survey) {
        this.title = dto.getQuestion();
        this.survey = survey;
        dto.getChoices().forEach(c -> this.choices.add(new Choice(c, this)));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}