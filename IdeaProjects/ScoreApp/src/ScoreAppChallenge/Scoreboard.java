package ScoreAppChallenge;

import java.util.List;
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
        printScoreboard();
    }

    public void addPointsToPlayer(Player player, int points){
        player.addPoints(points);
        newSortList();
        printScoreboard();
    }

    public Player getPlayerFromList(String name){
        Player searchedPlayer = null;
        boolean playerFound = false;
        for(int i = 0; i < _playerList.size(); i++){
            if(_playerList.get(i).getName().equals(name)){
                searchedPlayer = _playerList.get(i);
                System.out.println("Player " +name +" found.");
                playerFound = true;
                break;
            }
            else{
                System.out.println("player not found continue search");
            }
        }
        if(!playerFound){
            searchedPlayer = new Player(name);
            addPlayerToList(searchedPlayer);
        }
        return searchedPlayer;
    }

    private void printScoreboard(){
        System.out.println(_playerList.toString());
    }

    //sorting function using lambda
    private void newSortList(){
        _playerList.sort((o1, o2) -> {
            int comparison = 0;
            comparison = o2.getPoints() - o1.getPoints();
            if(comparison == 0){
                comparison = o1.getName().compareTo(o2.getName());
            }
            return comparison;
        });
    }
}