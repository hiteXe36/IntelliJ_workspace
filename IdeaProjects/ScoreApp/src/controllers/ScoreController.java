package controllers;
import ScoreAppChallenge.Player;
import ScoreAppChallenge.Scoreboard;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ScoreController {

    @FXML
    Button startButton;
    @FXML
    Button restartButton;
    @FXML
    TextField addPlayerField;
    @FXML
    Button addPlayerButton;
    @FXML
    TextField playerNameField;
    @FXML
    TextField pointsToAdd;
    @FXML
    Button addPointsToPlayer;
    @FXML
    TextArea displayScore;

    Scoreboard scoreboard;

    public void onClickEvent(MouseEvent mouseEvent) {
        System.out.println("Button clicked");
    }

    public void onStartButtonClicked(MouseEvent mouseEvent) {
        System.out.println("Start Button pressed \n creating empty score list.");
        initScoreboard();
        Player testPlayer = new Player("Paul Mathia");
        System.out.println("player :" +testPlayer.toString() +" added.");
        scoreboard.addPlayerToList(testPlayer);
        displayScore.setText(scoreboard.listPlayers());
        startButton.setDisable(true);
        restartButton.setDisable(false);
    }

    public void addPlayerButtonClicked(MouseEvent mouseEvent) {
        if(addPlayerField.getText().length() > 0){
            System.out.println(addPlayerField.getText());
            Player newPlayer = new Player(addPlayerField.getText());
            scoreboard.addPlayerToList(newPlayer);
            displayScore.setText(scoreboard.listPlayers());
        }
        else{
            System.out.println("Playername cant be empty.");
        }
    }

    private void initScoreboard(){
        scoreboard = new Scoreboard();
    }
}
