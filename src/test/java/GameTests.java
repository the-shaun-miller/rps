import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class GameTests {
    RPSGame rps;

    @BeforeEach
    private void setup(){
        rps = new RPSGame();
    }


    @Test
    public void initialGameShouldHave0to0Score(){
        Assertions.assertEquals(0, rps.p1score);
        Assertions.assertEquals(0, rps.p1score);
    }

    @Test
    public void whenP1wins_UpdateP1scoreBy1(){
        Assertions.assertEquals(0, rps.p1score);
        rps.p1win();
        Assertions.assertEquals(1, rps.p1score);
    }

    @Test
    public void whenP2wins_UpdateP2scoreBy1(){
        Assertions.assertEquals(0, rps.p2score);
        rps.p2win();
        Assertions.assertEquals(1, rps.p2score);
    }
    @Test
    public void given3winsFromP1_whenWinCalled_returnTrue(){

        rps.p1win();
        rps.p1win();
        rps.p1win();

        boolean result = rps.win();

        Assertions.assertTrue(result);
    }

    @Test
    public void given0or1or2wins_whenWinCalled_returnFalse(){
        RPSGame rps0 = new RPSGame();
        RPSGame rps1 = new RPSGame();
        RPSGame rps2 = new RPSGame();

        boolean result0 = rps0.win();

        rps1.p1win();
        boolean result1 = rps1.win();

        rps2.p1win();
        rps2.p1win();
        boolean result2 = rps2.win();

        Assertions.assertFalse(result0);
        Assertions.assertFalse(result1);
        Assertions.assertFalse(result2);
    }

    @Test
    public void GivenInvalidArgument_WhenRoundCalled_ThrowIllegalArgumentException(){

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    String player1Submission = "scissor";
                    String player2Submission = "lightning";

                    rps.round(player1Submission, player2Submission);
                });

    }

    @Test
    public void GivenP1SandP2P_andWinCalled_increaseP1ScoreBy1(){
        String player1Submission = "scissors";
        String player2Submission = "paper";

        Assertions.assertEquals(0, rps.p1score);
        rps.round(player1Submission,player2Submission);
        Assertions.assertEquals(1, rps.p1score);
    }

    @Test
    public void GivenP2SandP1P_andRoundCalled_increaseP2ScoreBy1(){
        String player2Submission = "scissors";
        String player1Submission = "paper";

        Assertions.assertEquals(0, rps.p2score);
        rps.round(player1Submission,player2Submission);
        Assertions.assertEquals(1, rps.p2score);
    }

    @Test
    public void GivenP1andP2SubmitSame_andRoundCalled_noIncreaseInScore(){

        Assertions.assertEquals(0,rps.p1score);
        Assertions.assertEquals(0,rps.p2score);
        rps.round("paper", "paper");
        Assertions.assertEquals(0,rps.p1score);
        Assertions.assertEquals(0,rps.p2score);

    }

    @Test
    public void paperBeatsRock(){

        RPSGame rps0 = new RPSGame();
        RPSGame rps1 = new RPSGame();

        Assertions.assertEquals(0, rps0.p1score);
        rps0.round("paper", "rock");
        Assertions.assertEquals(1,rps0.p1score);

        Assertions.assertEquals(0, rps1.p2score);
        rps1.round("rock", "paper");
        Assertions.assertEquals(1,rps1.p2score);

    }



}
