package com.maigrot.springfoot.controller;// Import des classes nécessaires pour les contrôleurs Spring
import com.maigrot.springfoot.model.Player;
import com.maigrot.springfoot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Définition de la classe PlayerController
@RestController
@RequestMapping("/players")
public class PlayerController {

    // Injection de dépendance pour l'instance de PlayerRepository
    @Autowired
    private PlayerRepository playerRepository;

    // Définition de la méthode pour récupérer tous les joueurs
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAllPlayers();
    }

    // Définition de la méthode pour récupérer un joueur par son nom
    @GetMapping("/{nom}")
    public Player getPlayerByName(@PathVariable String nom) {
        return playerRepository.findByName(nom);
    }

    // Définition de la méthode pour récupérer les joueurs d'une équipe par son id
    @GetMapping("/team/{id}")
    public List<Player> getPlayersByTeamId(@PathVariable Long id) {
        return playerRepository.findByTeamId(id);
    }

    // Définition de la méthode pour ajouter un nouveau joueur
    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    // Définition de la méthode pour supprimer un joueur existant
    @DeleteMapping("/{nom}")
    public void deletePlayer(@PathVariable String nom) {
        playerRepository.delete(playerRepository.findByName(nom));
    }

}
