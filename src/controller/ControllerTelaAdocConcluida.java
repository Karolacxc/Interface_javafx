package controller;

  import java.io.IOException;
import java.net.URL;
  import java.util.ResourceBundle;
  import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

  public class ControllerTelaAdocConcluida extends Controller {

      //////////// Tela Adoção concluida //////////////

      @FXML
      private Button  btnFinalizar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnFinalizar.setOnMouseClicked(event -> {
          try {

            
            mudarTela("../tela/TelaLogin.fxml", event);
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
    }
  }
