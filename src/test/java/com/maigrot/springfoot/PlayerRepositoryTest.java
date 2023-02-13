package com.maigrot.springfoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.maigrot.springfoot.model.Player;
import com.maigrot.springfoot.repository.PlayerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void whenAddAndRemovePlayer_thenSuccess() {
        Player player = new Player();
        player.setName("joueur test");
        player.setBirthDate("01/01/2000");
        playerRepository.save(player);
        playerRepository.delete(player);
        Player deletedPlayer = playerRepository.findById(player.getId()).orElse(null);
        assertNull(deletedPlayer);
    }
}