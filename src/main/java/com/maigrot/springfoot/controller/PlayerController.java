package com.maigrot.springfoot.controller;


import com.maigrot.springfoot.model.Player;
import com.maigrot.springfoot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("")
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable(value = "id") Long playerId) {
        Optional<Player> player = playerRepository.findById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok().body(player.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/teams/{teamId}")
    public List<Player> getPlayersByTeamId(@PathVariable(value = "teamId") Long teamId) {
        return playerRepository.findByTeamId(teamId);
    }

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