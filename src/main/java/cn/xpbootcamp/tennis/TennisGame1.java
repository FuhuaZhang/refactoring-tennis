package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1==m_score2) {
            return getScoreWhenScoreTheSame();
        } else if (m_score1>=4 || m_score2>=4) {
            return getScoreWhenAtLeastOneScoreGreaterThanFour();
        } else {
            return getScoreDescription(m_score1) + "-" + getScoreDescription(m_score2);
        }
    }

    private String getScoreDescription(int m_score) {
        String scoreDescription = "";
        switch (m_score) {
            case 0:
                scoreDescription += "Love";
                break;
            case 1:
                scoreDescription += "Fifteen";
                break;
            case 2:
                scoreDescription += "Thirty";
                break;
            case 3:
                scoreDescription += "Forty";
                break;
        }
        return scoreDescription;
    }

    private String getScoreWhenAtLeastOneScoreGreaterThanFour() {
        String score = "";

        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage " + player1Name;
        else if (minusResult ==-1) score ="Advantage " + player2Name;
        else if (minusResult>=2) score = "Win for " + player1Name;
        else score ="Win for " + player2Name;
        return score;
    }

    private String getScoreWhenScoreTheSame() {
        String score = "";

        switch (m_score1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}