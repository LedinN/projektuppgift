package se.reky.hakan.util;

import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.*;

class GameUtilTest {

    GameUtil gameUtil = new GameUtil();

    @Test
    void toLowerCaseButFirstLetterCapitalized() throws Exception {
        assertThrows(GameException.class, () -> gameUtil.toLowerCaseButFirstLetterCapitalized(null));
    }
}