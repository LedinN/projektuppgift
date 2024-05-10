package se.reky.hakan.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {

    GameUtil gameUtil = new GameUtil();

    @Test
    @DisplayName("Expect GameException when input is null")
    void should_ThrowGameException_When_InputIsNull() throws Exception {
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }
}