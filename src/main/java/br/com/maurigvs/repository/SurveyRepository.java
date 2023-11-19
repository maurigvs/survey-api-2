package br.com.maurigvs.repository;

import br.com.maurigvs.model.entity.Survey;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SurveyRepository implements PanacheRepository<Survey> {
}
