public class Player {

    int playerID; // generate up to four players max
    int gameID;
    String playerName;

    void setPlayerName(String newPlayerName){
        playerName = newPlayerName;
    }

    String getPlayerName(){
        return playerName;
    }

    void setGameID(int newGameID){
        gameID = newGameID;
    }

    int getGameID(){
        return gameID;
    }

}
