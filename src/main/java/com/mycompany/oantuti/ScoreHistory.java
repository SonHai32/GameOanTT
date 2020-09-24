package com.mycompany.oantuti;
import com.mycompany.oantuti.Users;

public class ScoreHistory {
    private Users newUsers;
    private int userScore;
    private int computerScore;
    private String winner;

    public ScoreHistory(Users user, int userScore, int computerScore){
        this.newUsers = user ;
        this.userScore = userScore;
        this.computerScore = computerScore;

        this.winner = computerScore > userScore ? "Máy Thắng" : "Bạn Thắng" ;
    }

    @Override
    public String toString(){
        return this.newUsers.getName() + "\t" + Integer.toString(this.userScore) + "\t" + Integer.toString(this.computerScore) + "\t" + this.winner + "\n";
    }
}