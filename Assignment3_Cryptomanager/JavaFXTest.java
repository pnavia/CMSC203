import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Simple JavaFX test application to verify JavaFX is working correctly
 */
public class JavaFXTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a simple button
        Button btn = new Button("JavaFX is working!");
        
        // Add an event handler
        btn.setOnAction(e -> {
            System.out.println("Button clicked - JavaFX is working correctly!");
        });
        
        // Create a layout and add the button
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        // Create a scene with the layout
        Scene scene = new Scene(root, 300, 200);
        
        // Set the scene on the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Test");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}