import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    Player player1 = new Player(12, "nickname12", 250);
    Player player2 = new Player(32, "nickname32", 350);
    Player player3 = new Player(33, "nickname33", 350);
    @Test
    public void firstPlayerNotFoundTest(){
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                ()->game.round("nickname50", "nickname32"));
    }

    @Test
    public void secondPlayerNotFoundTest(){
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class,
                ()->game.round("nickname12", "nickname2"));
    }

    @Test
    public void firstPlayerWinTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("nickname32", "nickname12");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWinTest() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("nickname12", "nickname32");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawnGameTest() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        int expected = 0;
        int actual = game.round("nickname32", "nickname33");

        Assertions.assertEquals(expected, actual);
    }


}
