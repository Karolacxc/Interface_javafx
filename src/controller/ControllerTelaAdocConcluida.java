package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ControllerTelaAdocConcluida extends Controller {

    //////////// Tela Adoção concluida //////////////

    @FXML
    private ImageView  btnFinalizar;

  @Override
  public void initialize(URL location, ResourceBundle resources) {

      //////////// Tela Adoção concluida //////////////

    btnFinalizar.setOnMouseClicked(event -> {
    try {
			mudarTela("telaEscolhaDoguinho.fxml", event);
		} catch (IOException e) {
			e.printStackTrace();
		}
    });
  }
}
