package se.reky.hakan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.devtools.v85.io.IO;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SimplePlayerInteractionTest {

    private Player player;
    private PlayerInteraction playerInteraction;

    private PlayerInteraction playerTestSetup(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        player = new Player();
        IOHandler ioHandler = new IOHandler(scanner);

        return new SimplePlayerInteraction(ioHandler);
    }

    @Test
    @DisplayName("Set and verify player name during setup")
    void should_CorrectlySetPlayerName_When_SetupPlayer() {
        playerInteraction = playerTestSetup("kalle kråka");
        playerInteraction.setupPlayer(player);
        assertEquals("kalle kråka", player.getName());
    }

    @Test
    @DisplayName("Update and confirm player HP")
    void should_CorrectlyUpdatePlayerHP_When_UpdatingHealth() {
        playerInteraction = playerTestSetup("kalle boll");
        playerInteraction.updatePlayerHealth(player,5);
        assertEquals(5,player.getHp());
    }

}