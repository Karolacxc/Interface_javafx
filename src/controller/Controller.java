package controller;

import java.io.IOException;
import javafx.scene.Node;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public abstract class Controller implements Initializable { // Ela não vai ser inicializada, pq ela é a classe
                                                            // mae então só os filhos serão inicializados


    public void mudarTela(String path, Event event)throws IOException {

        try {
            
            FXMLLoader principalLoader = new FXMLLoader(getClass().getResource(path));
            Parent root = principalLoader.load();

            Controller controller = principalLoader.getController();

            controller = MapController.mapController.get(path); // A a variavel controller esta sendo
                                                                           // sendo declarada com o tipo "Controler"
                                                                           // mesmo ela sendo abstrata, pois se
                                                                           // utiliza do Polimorfismo

            principalLoader.setController(controller);


            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); // Aqui o stage esta
                                                                                     // re-renderizando
                                                                                     // toda tela nova
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace(); // imprime erros
        }
    }
}
