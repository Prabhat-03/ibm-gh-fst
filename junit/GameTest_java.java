import fst.Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    // Test fixture - this must be type 'game', not 'GameTest'
    public Game g;

    @BeforeEach
    void setUp() {
        g = new Game();
    }

    // ---------- Draw scenarios ----------

    @Test
    @DisplayName("Same choice should result in a draw")
    public void testDraw_RockRock() {
        String result = g.determineWinner("rock", "rock");
        assertEquals("Draw", result, "Identical choices should be a draw");
    }

    @Test
    @DisplayName("Same choice (paper vs paper) should result in a draw")
    public void testDraw_PaperPaper() {
        String result = g.determineWinner("paper", "paper");
        assertEquals("Draw", result, "Identical choices should be a draw");
	}

	@Test
    @DisplayName("Same choice (scissors vs scissors) should result in a draw")
    public void testDraw_ScissorsScissors() {
        String result = g.determineWinner("scissors", "scissors");
        assertEquals("Draw", result, "Identical choices should be a draw");

    // ---------- Player wins scenarios ----------

    @Test
    @DisplayName("Rock beats scissors - player wins")
    public void testPlayerWins_RockBeatsScissors() {
        String result = g.determineWinner("rock", "scissors");
        assertEquals("player Wins", result, "Rock should beat scissors");
    }

    @Test
    @DisplayName("Paper beats rock - player wins")
    public void testPlayerWins_PaperBeatsRock() {
        String result = g.determineWinner("paper", "rock");
        assertEquals("player Wins", result, "Paper should beat rock");
    }

    @Test
    @DisplayName("Scissors beats paper - player wins")
    public void testPlayerWins_ScissorsBeatsPaper() {
        String result = g.determineWinner("scissors", "paper");
        assertEquals("player Wins", result, "Scissors should beat paper");
    }

    // ---------- Computer wins scenarios ----------

    @Test
    @DisplayName("Scissors loses to rock - computer wins")
    public void testComputerWins_RockBeatsScissors() {
        String result = g.determineWinner("scissors", "rock");
        assertEquals("computer Wins", result, "Rock should beat scissors (computer side)");
    }

    @Test
    @DisplayName("Rock loses to paper - computer wins")
    public void testComputerWins_PaperBeatsRock() {
        String result = g.determineWinner("rock", "paper");
        assertEquals("computer Wins", result, "Paper should beat rock (computer side)");
    }

    @Test
    @DisplayName("Paper loses to scissors - computer wins")
    public void testComputerWins_ScissorsBeatsPaper() {
        String result = g.determineWinner("paper", "scissors");
        assertEquals("computer Wins", result, "Scissors should beat paper (computer side)");
    }
}
