package application;



import java.io.File;
import java.io.IOException;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Button openButton;

    @FXML
    private Button playButton;

    @FXML
    private Button pauseButton;

    @FXML
    private Button stopButton;
    
    @FXML
    private MediaView mediaView;
    
    // Variable
    private MediaPlayer mediaPlayer;
    private Media media;
    private File file;
    private String filePath;
   
    public void initialize() {
    	// Hier können noch Anfagswerte gesetzt werden, da die initialize ähnlich der init() Methode ist
    }

    @FXML
    void openButtonTapped(ActionEvent event) {
//    	System.out.println("Open file");
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("mp4", "*.mp4"),
    			new FileChooser.ExtensionFilter("mp3", "*.mp3")
    			);
    	
    	file = fileChooser.showOpenDialog(null);
    	
    	if (file != null) {
			filePath = file.toURI().toString();
		}
    	
    	if (filePath != null) {
			media = new Media(filePath);
			mediaPlayer = new MediaPlayer(media);

			mediaView.setMediaPlayer(mediaPlayer);
			
			// Binding
			DoubleProperty width = mediaView.fitWidthProperty();
			DoubleProperty height = mediaView.fitHeightProperty();
			width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
			height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
			
			mediaPlayer.play();
		}
    }

    @FXML
    void pauseButtonTapped(ActionEvent event) {
    	if (mediaPlayer != null) {
			mediaPlayer.pause();
		}

    }

    @FXML
    void playButtonTapped(ActionEvent event) {
    	if (mediaPlayer != null) {
			mediaPlayer.play();;
		}
    }

    @FXML
    void stopButtonTapped(ActionEvent event) {
    	if (mediaPlayer != null) {
			mediaPlayer.pause();
		}
    	
    	FXMLLoader fxmlLoader = new FXMLLoader();
    	fxmlLoader.setLocation(getClass().getResource("ExitFXML.fxml"));
    	
    	try {
			fxmlLoader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ExitController exitController = fxmlLoader.getController();
    	exitController.setMediaPlayer(mediaPlayer);
    	
    	Parent root = fxmlLoader.getRoot();
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	
    	stage.setScene(scene);
    	stage.setTitle("Exit");
    	stage.show();
    	
    	
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
