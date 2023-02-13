package com.maigrot.springfoot.controller;


import com.maigrot.springfoot.model.Player;
import com.maigrot.springfoot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller pour les joueurs
 */
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    // Référence au repository des joueurs
    @Autowired
    private PlayerRepository playerRepository;


    /**
     * Récupère la liste de tous les joueurs
     * @return la liste de tous les joueurs
     */
    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }


    /**
     * Récupère un joueur par son ID
     * @param playerId l'ID du joueur à récupérer
     * @return le joueur correspondant à l'ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok().body(player.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Ajoute un joueur dans la base de données
     * @param player le joueur à ajouter
     * @return le joueur ajouté
     */
    @PostMapping("")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }


    /**
     * Récupère la liste des joueurs d'une équipe donnée
     * @param teamId l'ID de l'équipe
     * @return la liste des joueurs de l'équipe
     */
    @GetMapping("/teams/{teamId}")
    public List<Player> getPlayersByTeamId(@PathVariable(value = "teamId") Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }


    /**
     * Supprime un joueur de la base de données
     * @param playerId l'ID du joueur à supprimer
     * @return une réponse vide avec un status HTTP 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable(value = "id") Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            playerRepository.delete(player.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}