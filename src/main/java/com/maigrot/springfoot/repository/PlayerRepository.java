package com.maigrot.springfoot.repository;

// Import de la classe JpaRepository pour hériter des méthodes de base pour les opérations CRUD
import com.maigrot.springfoot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

// Import de l'annotation @Repository pour indiquer que cette interface est un repository
import org.springframework.stereotype.Repository;

// Import de l'annotation @Query pour définir une requête SQL native
import org.springframework.data.jpa.repository.Query;

// Import de l'annotation @Param pour définir un paramètre dans une requête SQL
import org.springframework.data.repository.query.Param;

import java.util.List;

// Définition de l'interface PlayerRepository
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    // Définition de la méthode findAllPlayers avec une requête SQL native pour récupérer tous les joueurs
    @Query(value = "SELECT * FROM joueur", nativeQuery = true)
    List<Player> findAllPlayers();

    // Définition de la méthode findByName avec une requête SQL native pour récupérer un joueur par son nom
    @Query(value = "SELECT * FROM joueur WHERE nom = :nom", nativeQuery = true)
    Player findByName(@Param("nom") String name);

    // Définition de la méthode findByTeamId avec une requête SQL native pour récupérer les joueurs d'une équipe par son id
    @Query(value = "SELECT * FROM joueur WHERE id_equipe = :id_equipe", nativeQuery = true)
    List<Player> findByTeamId(@Param("id_equipe") Long teamId);

}