package com.maigrot.springfoot;
// Import des classes nécessaires pour les tests unitaires Spring
import com.maigrot.springfoot.model.Team;
import com.maigrot.springfoot.repository.TeamRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

// Définition de la classe de test pour TeamRepository
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamRepositoryTest {

    // Injection de dépendance pour l'instance de TeamRepository
    @Autowired
    private TeamRepository teamRepository;

    // Test pour vérifier que la méthode findAllTeams retourne une liste de toutes les équipes
    @Test
    public void testFindAllTeams() {
        List<Team> teams = teamRepository.findAllTeams();
        assertThat(teams.size()).isEqualTo(3);
    }

    // Test pour vérifier que la méthode findByName retourne une équipe en fonction de son nom
    @Test
    public void testFindByName() {
        Team team = teamRepository.findByName("Equipe 1");
        assertThat(team.getNom()).isEqualTo("Equipe 1");
    }

}