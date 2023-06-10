package tela;

import controller.Controller;
import controller.MapController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public MapController mapController = new MapController();

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String path = "TelaLogin.fxml"; // Determina qual é a tela inicial

        FXMLLoader principalLoader = new FXMLLoader(getClass().getResource(path));
        Controller controller = MapController.mapController.get(path);
        principalLoader.setController(controller); // Define o controlador corretamente

        Parent root = principalLoader.load();
        Scene principalScene = new Scene(root);
        primaryStage.setResizable(false);
        primaryStage.setScene(principalScene);
        primaryStage.show();
    }

    
}
