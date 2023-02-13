package com.maigrot.springfoot.controller;

import com.maigrot.springfoot.model.Team;
import com.maigrot.springfoot.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") Long teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isPresent()) {
            return ResponseEntity.ok().body(team.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

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
