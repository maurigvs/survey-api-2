package br.com.maurigvs.model.entity;

import br.com.maurigvs.model.dto.SurveyDto;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@Schema(name = "SurveyResponse")
public class Survey {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String title;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Question> questions = new ArrayList<>();

    public Survey() {
    }

    public Survey(SurveyDto dto) {
        this.title = dto.getSurvey();
        dto.getQuestions().forEach(q -> this.questions.add(new Question(q, this)));
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

    public List<Question> getQuestions() {
        return questions;
    }
}
