import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFXGUI extends Application{
    public void GUI(Stage primaryStage) {
        try {
            URL url = Currency_Exchange1.class.getResource("G:\\My Drive\\Java\\CurrencyExchange\\src\\JavaFX_GUI.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent root = (Parent)fxmlLoader.load(); 
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("Test");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
