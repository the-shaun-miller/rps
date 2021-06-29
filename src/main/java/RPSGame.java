import java.util.Arrays;

public class RPSGame {
    int p1score;
    int p2score;

    public RPSGame() {
        this.p1score = 0;
        this.p2score = 0;
    }


    public void p1win() {
        this.p1score += 1;
    }

    public void p2win() {
        this.p2score += 1;
    }

    public boolean win() {
        return (this.p1score ==3 || this.p2score ==3);
    }

    public void round(String player1Submission, String player2Submission) {
        String[] validEntries = {"scissors", "rock", "paper"};

        if(!Arrays.stream(validEntries).anyMatch(player1Submission::equals))
            throw new IllegalArgumentException();

        if(!Arrays.stream(validEntries).anyMatch(player2Submission::equals))
            throw new IllegalArgumentException();

        if(player1Submission.equals(player2Submission)); //Do Nothing

        if(player1Submission.equals("scissors") && player2Submission.equals("paper"))
            this.p1score += 1;

        if(player2Submission.equals("scissors") && player1Submission.equals("paper"))
            this.p2score += 1;

        if(player1Submission.equals("paper")&&player2Submission.equals("rock"))
            this.p1score += 1;

        if(player2Submission.equals("paper")&&player1Submission.equals("rock"))
            this.p2score += 1;

    }
}
