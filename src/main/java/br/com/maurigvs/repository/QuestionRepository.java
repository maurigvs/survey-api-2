package br.com.maurigvs.repository;

import br.com.maurigvs.model.entity.Question;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class QuestionRepository implements PanacheRepository<Question> {
}
