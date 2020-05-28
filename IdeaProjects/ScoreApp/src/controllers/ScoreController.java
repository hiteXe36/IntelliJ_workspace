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

    public void onStartButtonClicked(MouseEvent mouseEvent) {
        System.out.println("Start Button pressed \n calling initScoreboard method.");
        initScoreboard();
        startButton.setDisable(true);
        restartButton.setDisable(false);
    }

    public void onRestartButtonClicked(MouseEvent mouseEvent) {
        System.out.println("Restart button clicked. \n resetting list and scores");
        initScoreboard();
        startButton.setDisable(false);
        restartButton.setDisable(true);
    }

    public void addPlayerButtonClicked(MouseEvent mouseEvent) {
        if(addPlayerField.getText().length() > 0){
            System.out.println(addPlayerField.getText());
            Player newPlayer = new Player(addPlayerField.getText());
            scoreboard.addPlayerToList(newPlayer);
            displayScore.setText(scoreboard.listPlayers());
        }
        else{
            System.out.println("Playername or list cant be empty\n " +
                    "press start or add playername.");
        }
    }

    public void addPointsToPlayerClicked(MouseEvent mouseEvent) {
        Player player = scoreboard.getPlayerFromList(playerNameField.getText());
        scoreboard.addPointsToPlayer(player, Integer.parseInt(pointsToAdd.getText()));
        displayScore.setText(scoreboard.listPlayers());
    }

    private void initScoreboard(){
        scoreboard = new Scoreboard();
        displayScore.setText("Player list created.\n");
    }
}
