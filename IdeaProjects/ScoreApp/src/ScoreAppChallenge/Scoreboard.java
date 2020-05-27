package ScoreAppChallenge;

import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Scoreboard {

    private List<Player> _playerList;

    //Constructor
    public Scoreboard(){
        _playerList = new LinkedList<Player>();
    }

    public String listPlayers(){
        String resultString = "";
        for(Player player: _playerList){
            resultString += player.toString() + "\n";
        }
        return resultString;
    }

    public void addPlayerToList(Player player){
        _playerList.add(player);
        sortList();
        printScoreboard();
    }

    public void addPointsToPlayer(Player player, int points){
        player.addPoints(points);
        sortList();
        printScoreboard();
    }

    private void printScoreboard(){
        System.out.println(_playerList.toString());
    }

    private void sortList(){
        Collections.sort(_playerList);
    }

}