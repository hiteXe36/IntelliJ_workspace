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

    public void onClickEvent(MouseEvent mouseEvent) {
        System.out.println("Button clicked");
    }

    public void onStartButtonClicked(MouseEvent mouseEvent) {
        System.out.println("Start Button pressed \n creating empty score list.");
        Scoreboard scoreboard = new Scoreboard();
        Player testPlayer = new Player("Paul Mathia");
        System.out.println("player :" +testPlayer.toString() +" added.");
        scoreboard.addPlayerToList(testPlayer);
        displayScore.setText(scoreboard.listPlayers());
        startButton.setDisable(true);
    }
}
