import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class provides the GUI for the cow clock, and handles updating the GUI
 * @author Kit Kindred
 */
public class CowClockFX extends Application {
		private MainPanel mainPanel = new MainPanel();
		
		public static void main(String[] args) {
			//Part of starting a JavaFX program
			launch(args);
		}
		@Override
		public void start(Stage stage) {
			//This is what actually starts your GUI 'n stuff
			Scene scene = new Scene(mainPanel);
			   stage.setScene(scene);
			   stage.setTitle("Cow Clock");
			   stage.show();
		}
		
		private class MainPanel extends BorderPane{
			MainPanel() {
				CowClockData cow = new CowClockData();
				String cowTime = cow.generateCowTime();
				Text time = new Text(cowTime);
				time.setFont(new Font(30));
				time.setFill(Color.LIME);
				
				//Formats the spacing and colour of the window.
				this.setPadding(new Insets(12, 15, 12, 1));
				this.setStyle("-fx-background-color: black;");
				
				//This thing runs at a fixed interval, and calls the updateCow method
				PauseTransition wait = new PauseTransition(Duration.seconds(.1));
			    //Lambda expression. W00T!
				wait.setOnFinished((e) -> {
			        updateCow();
			        wait.playFromStart();
			    });
			    wait.play();
			
			    //Since MainPanel extends BorderPane, the setTop() method is available
			    //to allow us to set the position of our Text object (the cow)
			    //Totally under-utilizing the BorderPane tbh
				this.setTop(time);
	            
			}
			
			/**
			 * This method generates a new cow with the current time when it's called.
			 * It's probably horribly inefficient as far as memory management is concerned 
			 * (creates a new object every time it's called),
			 * but I think garbage collection will manage it.
			 */
			public void updateCow() {
				CowClockData newCow = new CowClockData();
				String cowTime = newCow.generateCowTime();

				Text time = new Text(cowTime);
				time.setFont(new Font(30));
				//This sets the colour of the cow
				time.setFill(Color.LIME);
				
				//This sets the cow as the top of the MainPanel "mainPanel".
				mainPanel.setTop(time);				
			}
		}
}

