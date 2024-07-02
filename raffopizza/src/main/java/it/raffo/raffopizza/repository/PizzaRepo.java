package it.raffo.raffopizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.raffo.raffopizza.model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {

}
