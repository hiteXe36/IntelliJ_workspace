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

    public List<Player> get_playerList() {
        return _playerList;
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

    public Player getPlayerFromList(String name){
        Player searchedPlayer = null;
        for(int i = 0; i < _playerList.size(); i++){
            if(_playerList.get(i).getName().equals(name)){
                searchedPlayer = _playerList.get(i);
                System.out.println("Player " +name +" found.");
                break;
            }
            else{
                System.out.println("Player not in List\n creating new player with search name");
                searchedPlayer = new Player(name);
            }
        }
        return searchedPlayer;
    }

    private void printScoreboard(){
        System.out.println(_playerList.toString());
    }

    private void sortList(){
        Collections.sort(_playerList);
    }

}