package controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class ControllerDogGeral extends Controller {

        @FXML
        private Button btnAdotar;

        @FXML
        private Button btnVoltar;

        @FXML
        private  ImageView imagemDog;

        @FXML
        private  Label lableDog;

        @FXML
        private  Text textDog;

        public static Image imagem;
        public static String lableCachorro;
        public static String descricaoCachorro;




        @Override
        public void initialize(URL location, ResourceBundle resources) {


        imagemDog.setImage(imagem);



        this.lableDog.setText(lableCachorro);

            btnAdotar.setOnAction(event -> {
                try {
                    mudarTela("../tela/TelaFormulario.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            btnVoltar.setOnAction(event -> {
                try {
                    mudarTela("../tela/TelaTabAdocao.fxml", event);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }


        public static void configConteudo(String imagemDog, String lableDog, String textDog){

            imagem = new Image(imagemDog );
            descricaoCachorro= textDog;
            lableCachorro =lableDog;

        }

        /*TODO

        na cladde onde define a tabela pra clicar no cachorro, tem q colocar o setAction
        ControllerGeral.confiConteudo (String(caminhopraImagem) String(nomeDoDcachorro) String(descriçãoDele))

        enviar as informacoes da tabela

        */

    }