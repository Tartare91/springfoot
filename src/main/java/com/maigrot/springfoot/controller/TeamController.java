package com.maigrot.springfoot.controller;

// Import des classes nécessaires pour les contrôleurs Spring

import com.maigrot.springfoot.model.Team;
import com.maigrot.springfoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Définition de la classe TeamController
@RestController
@RequestMapping("/teams")
public class TeamController {

    // Injection de dépendance pour l'instance de TeamRepository
    @Autowired
    private TeamRepository teamRepository;

    // Définition de la méthode pour récupérer toutes les équipes
    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAllTeams();
    }

    // Définition de la méthode pour récupérer une équipe par son nom
    @GetMapping("/{nom}")
    public Team getTeamByName(@PathVariable String nom) {
        return teamRepository.findByName(nom);
    }

    // Définition de la méthode pour ajouter une nouvelle équipe
    @PostMapping
    public Team addTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    // Définition de la méthode pour supprimer une équipe existante
    @DeleteMapping("/{nom}")
    public void deleteTeam(@PathVariable String nom) {
        teamRepository.delete(teamRepository.findByName(nom));
    }

}
