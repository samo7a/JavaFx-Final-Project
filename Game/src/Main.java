import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage; 
public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	Scene loginScene;
	Scene mainScene;
	
	@Override
	public void start(Stage window) throws Exception {
		Label timer = new Label();
		Label nameLabel = new Label("Enter Your Name");
		TextField nameField = new TextField();
		nameField.setPromptText("Player Name");
		
		Button startGame = new Button("Start Game");
		startGame.setOnAction(e-> {
			window.setScene(mainScene);
			
			for (int i = 0; i < 6; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				timer.setText(Integer.toString(i));
			}
	    
		});
		VBox loginLayout = new VBox(10);
		loginLayout.getChildren().addAll(nameLabel,nameField,startGame);
		loginLayout.setAlignment(Pos.CENTER);
		
		BorderPane mainLayout = new BorderPane();
		
		//Label timer = new Label();
		HBox timerLayout = new HBox(10);
		timerLayout.getChildren().addAll(timer);
		mainLayout.setTop(timerLayout);
		
		mainScene = new Scene(mainLayout,1048,1048);
		loginScene = new Scene(loginLayout,240,140);
		window.setScene(loginScene);
		window.show();
	}

}
