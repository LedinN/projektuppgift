package se.reky.hakan.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActorTest {

    private Actor player;
    private Actor goblin;

    @BeforeEach
    void setUp() {
        player = new Player("Kalle player",30,1);
        goblin = new Goblin("Kalle goblin",1,29);
    }

    @Test
    @DisplayName("Verify Goblin attacks reduce Player's HP correctly")
    void should_ReducePlayerHP_When_GoblinAttacks() {
        goblin.attack(player);
        assertEquals(1,player.getHp());
    }

}