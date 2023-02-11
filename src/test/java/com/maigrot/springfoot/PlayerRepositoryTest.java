package com.maigrot.springfoot;

// Import des classes nécessaires pour les tests unitaires Spring
import com.maigrot.springfoot.model.Player;
import com.maigrot.springfoot.repository.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

// Import de la classe Player


// Définition de la classe de test pour PlayerRepository
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTest {

    // Injection de dépendance pour l'instance de PlayerRepository
    @Autowired
    private PlayerRepository playerRepository;

    // Test pour vérifier que la méthode findAllPlayers retourne une liste de tous les joueurs
    @Test
    public void testFindAllPlayers() {
        List<Player> players = playerRepository.findAllPlayers();
        assertThat(players.size()).isEqualTo(3);
    }

    // Test pour vérifier que la méthode findByName retourne un joueur en fonction de son nom
    @Test
    public void testFindByName() {
        Player player = playerRepository.findByName("Sergio Ramos");
        assertThat(player.getNom()).isEqualTo("Sergio Ramos");
    }

    // Test pour vérifier que la méthode findByTeamId retourne une liste de joueurs pour une équipe donnée
    @Test
    public void testFindByTeamId() {
        List<Player> players = playerRepository.findByTeamId(1L);
        assertThat(players.size()).isEqualTo(2);
    }

}