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
        //sortList();
        printScoreboard();
    }

    public void addPointsToPlayer(Player player, int points){
        player.addPoints(points);
        sortList();
        printScoreboard();
    }

    public Player getPlayerFromList(String name){
        Player searchedPlayer = null;
        boolean playerFound = false;
        for(int i = 0; i < _playerList.size(); i++){
            System.out.println("loop counter: "+i);
            if(_playerList.get(i).getName().equals(name)){
                searchedPlayer = _playerList.get(i);
                System.out.println("Player " +name +" found.");
                playerFound = true;
                System.out.println(playerFound);
                break;
            }
            else{
                System.out.println(playerFound);
                System.out.println("else part counter: "+ i);
                System.out.println("player not found continue search");
                //searchedPlayer = new Player(name);
            }
            //System.out.println("Player not in List\n creating new player with search name");
        }
        if(!playerFound){
            searchedPlayer = new Player(name);
            System.out.println("New Player: " + searchedPlayer.toString());
            addPlayerToList(searchedPlayer);
        }
        System.out.println("returned Player:" +searchedPlayer.toString());
        return searchedPlayer;
    }

    private void printScoreboard(){
        System.out.println(_playerList.toString());
    }

    private void sortList(){
        Collections.sort(_playerList);
    }

}