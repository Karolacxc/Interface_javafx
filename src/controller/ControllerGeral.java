package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerGeral extends Controller implements Initializable {
    
        @FXML
        private Button btnAdotar;
    
        @FXML
        private Button btnVoltar;
      
        @FXML
        private static ImageView imagemDog;

        @FXML
        private static Label lableDog;

        @FXML
        private static Text textDog;

        

        @Override
        public void initialize(URL location, ResourceBundle resources) {
    

            btnAdotar.setOnAction(event -> {
                try {
                    mudarTela("telaFormulario.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    
            btnVoltar.setOnAction(event -> {
                try {
                    mudarTela("telaEscolhaDoguinho.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
    
        }


        public static void configConteudo(String imagemDog, String lableDog, String textDog){
            Image imageCachorro = new Image(imagemDog);

           ControllerGeral.imagemDog.setImage(imageCachorro);
           ControllerGeral.lableDog.setText(lableDog);;
           ControllerGeral.textDog.setText(textDog);

        }

        /*TODO
         
        na cladde onde define a tabela pra clicar no cachorro, tem q colocar o setAction
        ControllerGeral.confiConteudo (String(caminhopraImagem) String(nomeDoDcachorro) String(descriçãoDele))
        
        enviar as informacoes da tabela
    
        */

    }





