package com.maigrot.springfoot;


import jakarta.transaction.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import com.maigrot.springfoot.model.Team;
import com.maigrot.springfoot.repository.TeamRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Test
    @Transactional
    public void whenAddAndRemoveTeam_thenSuccess() {
        // given
        Team testTeam = new Team();
        testTeam.setName("Test Team");
        testTeam.setCoach("Test Coach");
        testTeam.setStadium("Test Stadium");

        // when
        teamRepository.save(testTeam);

        // then
        Team addedTeam = teamRepository.findById(testTeam.getId()).orElse(null);
        assertNotNull(addedTeam);
        assertEquals(testTeam.getName(), addedTeam.getName());
        assertEquals(testTeam.getCoach(), addedTeam.getCoach());
        assertEquals(testTeam.getStadium(), addedTeam.getStadium());

        // when
        teamRepository.delete(testTeam);

        // then
        Team removedTeam = teamRepository.findById(testTeam.getId()).orElse(null);
        assertNull(removedTeam);
    }
}
