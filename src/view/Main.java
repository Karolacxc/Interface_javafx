<<<<<<< HEAD
import controller.MapController;
=======
<<<<<<< HEAD
import MapController;

=======
>>>>>>> Luis
package view;
import MapController;
>>>>>>> 3e7511841609e89480bf70db304821ceef25ff2e
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
        FXMLLoader principalLoader;

        String path = "telaAdocao01.fxml";    //Determina qual é a tela inical

        principalLoader = new FXMLLoader(getClass().getResource(path));             //encapsulamento
        principalLoader.setController(MapController.mapController.get(path));       

        Parent roat = principalLoader.load();
        Scene principalScene = new Scene(roat);
        primaryStage.setResizable(false);
        primaryStage.setScene(principalScene);       //carregando scena
        primaryStage.show();

    }
}
