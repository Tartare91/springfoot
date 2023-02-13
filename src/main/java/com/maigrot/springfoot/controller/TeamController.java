package com.maigrot.springfoot.controller;

import com.maigrot.springfoot.model.Team;
import com.maigrot.springfoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlleur REST pour les équipes
 */
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    /**
     * Dépendance vers la source de données des équipes
     */
    @Autowired
    private TeamRepository teamRepository;


    /**
     * Récupère toutes les équipes
     * @return Liste des équipes
     */
    @GetMapping("")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }


    /**
     * Récupère une équipe par son identifiant
     * @param teamId Identifiant de l'équipe
     * @return Équipe correspondante ou 404 si introuvable
     */
    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crée une nouvelle équipe
     * @param team Équipe à créer
     * @return Équipe créée
     */
    @PostMapping("")
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }


    /**
     * Supprime une équipe
     * @param teamId Identifiant de l'équipe à supprimer
     * @return 204 si suppression réussie, 404 sinon
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable(value = "id") Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            teamRepository.delete(team.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
