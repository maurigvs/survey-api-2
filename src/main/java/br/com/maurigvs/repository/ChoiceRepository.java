package br.com.maurigvs.repository;

import br.com.maurigvs.model.entity.Choice;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChoiceRepository implements PanacheRepository<Choice> {
}
