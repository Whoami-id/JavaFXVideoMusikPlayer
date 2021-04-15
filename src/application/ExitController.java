package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ExitController {

	@FXML
    private Button exitButton;

    @FXML
    private Button closeButton;
    
    // Variable
    private MediaPlayer mediaPlayer;
	
    @FXML
    void buttonTapped(ActionEvent event) {
//    	System.out.println("Test");
    	
    	Button button = (Button) event.getSource();
    	
    	if (button.getId().equals("exitButton")) {
    		Platform.exit();
		} else if (button.getId().equals("closeButton")) {
			Stage stage = (Stage) button.getScene().getWindow();
			stage.close();
			
			if (mediaPlayer != null) {
				mediaPlayer.play();
			}
		}
    	
    }

	public MediaPlayer getMediaPlayer() {
		return mediaPlayer;
	}

	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}

}
