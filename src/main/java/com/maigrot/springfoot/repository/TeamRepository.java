package com.maigrot.springfoot.repository;// Import de la classe JpaRepository pour hériter des méthodes de base pour les opérations CRUD
import com.maigrot.springfoot.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

// Import de l'annotation @Repository pour indiquer que cette interface est un repository
import org.springframework.stereotype.Repository;

// Import de l'annotation @Query pour définir une requête SQL native
import org.springframework.data.jpa.repository.Query;

// Import de l'annotation @Param pour définir un paramètre dans une requête SQL
import org.springframework.data.repository.query.Param;

import java.util.List;

// Définition de l'interface TeamRepository
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // Définition de la méthode findAllTeams avec une requête SQL native pour récupérer toutes les équipes
    @Query(value = "SELECT * FROM equipe", nativeQuery = true)
    List<Team> findAllTeams();

    // Définition de la méthode findByName avec une requête SQL native pour récupérer une équipe par son nom
    @Query(value = "SELECT * FROM equipe WHERE nom = :nom", nativeQuery = true)
    Team findByName(@Param("nom") String name);

}
