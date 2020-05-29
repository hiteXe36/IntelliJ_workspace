package controllers;
import ScoreAppChallenge.Player;
import ScoreAppChallenge.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class ScoreController {

    @FXML
    private Button startButton;
    @FXML
    private Button restartButton;
    @FXML
    private TextField addPlayerField;
    @FXML
    private Button addPlayerButton;
    @FXML
    private TextField playerNameField;
    @FXML
    private TextField pointsToAdd;
    @FXML
    private Button addPointsToPlayer;
    @FXML
    private TextArea displayScore;

    private Scoreboard scoreboard;

    //start function - inits the scoreboard and enables buttons
    public void onStartButtonClicked(MouseEvent mouseEvent) {
        if(mouseButtonOneClicked(mouseEvent)){
            System.out.println("Start Button pressed \ncalling initScoreboard method.");
            initScoreboard();
            startButton.setDisable(true);
            restartButton.setDisable(false);
            addPlayerButton.setDisable(false);
            addPointsToPlayer.setDisable(false);
        }
        else{
            System.out.println("wrong click - i want mousebutton one ;)");
        }
    }

    //restarts the game with a fresh empty list
    public void onRestartButtonClicked(MouseEvent mouseEvent) {
        if(mouseButtonOneClicked(mouseEvent)){
            System.out.println("Restart button clicked. \nresetting list");
            initScoreboard();
            startButton.setDisable(false);
            restartButton.setDisable(true);
        }
        else System.out.println("wrong mouse button");
    }

    //adds new player to list - string cant be empty or blank
    public void addPlayerButtonClicked(MouseEvent mouseEvent) {
        if(mouseButtonOneClicked(mouseEvent)){
            System.out.println("mouse 1 clicked");
            if(!addPlayerField.getText().isBlank()){
                addPlayer();
            }
            else{
                System.out.println("Playername cant be empty");
            }
        }
        else{
            System.out.println("wrong click");
        }
    }

    public void addPlayerButtonPressed(KeyEvent keyEvent) {
        if(enterButtonPressed(keyEvent)){
            System.out.println("enter pressed");
            if(!addPlayerField.getText().isBlank()){
                addPlayer();
            }
            else{
                System.out.println("Playername cant be empty");
            }
        }
    }

    /**
     * Add points to a player if player does not exist it creates a new player with the given points
     * @param mouseEvent
     */
    public void addPointsToPlayerClicked(MouseEvent mouseEvent) {
        if(mouseButtonOneClicked(mouseEvent)){
            if(!playerNameField.getText().isBlank()){
                addPointsToPlayer();
            }
        }
        else System.out.println("wrong click bro");
    }

    public void addPointsToPlayerPressed(KeyEvent keyEvent) {
        if(enterButtonPressed(keyEvent)){
            if(!playerNameField.getText().isBlank()){
                addPointsToPlayer();
            }
        }
    }

    //initScoreboard method that creates a new empty list
    private void initScoreboard(){
        scoreboard = new Scoreboard();
        displayScore.setText("Player list created...");
    }

    //cleans the addplayerfield after the user input
    private void cleanAddPlayerField(){ addPlayerField.setText("");}

    //cleans the playername- and pointstoaddfield after user input
    private void cleanAddPointsToPlayerFields(){
        playerNameField.setText("");
        pointsToAdd.setText("");
    }

    //returns 1 if mousebutton one was clicked.
    private boolean mouseButtonOneClicked(MouseEvent event){
        return event.getButton().equals(MouseButton.PRIMARY);
    }

    //check if enter was pressed
    private boolean enterButtonPressed(KeyEvent keyEvent) {
        return keyEvent.getCode() == KeyCode.ENTER;
    }

    private void addPlayer(){
        Player newPlayer = new Player(addPlayerField.getText());
        scoreboard.addPlayerToList(newPlayer);
        displayScore.setText(scoreboard.listPlayers());
        cleanAddPlayerField();
    }

    private void addPointsToPlayer(){
        Player player = scoreboard.getPlayerFromList(playerNameField.getText());
        try{
            scoreboard.addPointsToPlayer(player, Integer.parseInt(pointsToAdd.getText()));
        } catch (NumberFormatException e) {
            System.out.println("wrong point value");
        } catch (Exception exception){
            System.out.println("unexpected exception");
        }
        displayScore.setText(scoreboard.listPlayers());
        cleanAddPointsToPlayerFields();
    }
}
