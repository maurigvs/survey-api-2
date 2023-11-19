package br.com.maurigvs.model.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
@Cacheable
@Schema(name = "ChoiceResponse")
public class Choice {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String title;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Choice() {
    }

    public Choice(String title, Question question) {
        this.title = title;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Question getQuestion() {
        return question;
    }
}