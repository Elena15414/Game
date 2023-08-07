package qajavaGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    Player Ivan = new Player(1, "Иван", 15);
    Player Elena = new Player(2, "Елена", 10);

    @Test
    public void Player() {
        Player Ivan = new Player(1, "Иван", 15);
        Player Elena = new Player(2, "Елена", 15);

        game.register(Ivan);
        game.register(Elena);
        int actual = game.round("Иван", "Елена");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayer() {
        game.register(Ivan);
        game.register(Elena);

        int actual = game.round("Иван", "Елена");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayer() {
        Player Ivan = new Player(1, "Иван", 11);
        Player Elena = new Player(2, "Елена", 10);

        game.register(Ivan);
        game.register(Elena);

        int actual = game.round("Елена", "Иван");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playerFirstIsNotRegistered() {
        game.register(Ivan);
        game.register(Elena);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Петя", "Елена"));

    }

    @Test
    public void playerSecondIsNotRegistered() {
        game.register(Ivan);
        game.register(Elena);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Иван", "Аня"));

    }

    @Test
    public void playersIsNotRegistered() {
        game.register(Ivan);
        game.register(Elena);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Анна", "Катя"));

    }

}