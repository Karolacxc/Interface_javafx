package controller;

import data.DataCachorro;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Cachorro;


public class ControllerTelaCadastrarDog extends Controller  {

    @FXML
    private TextField txtNomeC;
    @FXML
    private TextField txtCorC;
    @FXML
    private TextField txtIdadeC;
    @FXML
    private TextField txtRacaC;
    @FXML
    private Label labelStatusCadastroDog;
    @FXML
    private Button btnAtuC;
    @FXML
    private Button btnCancelC;

    @FXML
    private ImageView imageView;
    @FXML
    private Button btnSelecione;

    private Cachorro Cachorro;      ////

    private Stage dialogStage;     //// 

    public Cachorro getCachorro(){
        return Cachorro;
    }
     public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.dialogStage.setResizable(false); // Impede o redimensionamento da tela

    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limparCampos();

        btnSelecione.setOnAction(e -> {
                // Cria o FileChooser
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Selecionar Imagem");

                // Define os filtros para exibir apenas arquivos de imagem
                FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                        "Arquivos de Imagem", ".png", ".jpg", "*.jpeg");
                fileChooser.getExtensionFilters().add(imageFilter);

                // Mostra o diálogo de seleção de arquivo

                File file = fileChooser.showOpenDialog(null);

                if (file != null) {
                    // Carrega a imagem selecionada no ImageView
                    Image image = new Image(file.toURI().toString());
                    imageView.setImage(image);
                }
            });


    }

    @FXML
    private void cadastrarCachorro(ActionEvent event) throws Exception {
        //Testa se os campos não estão vazios
        if (!txtNomeC.getText().isEmpty() && !txtCorC.getText().isEmpty() && !txtIdadeC.getText().isEmpty() && !txtRacaC.getText().isEmpty()){
            String nome = txtNomeC.getText().toUpperCase();
            String cor = txtCorC.getText().toUpperCase();
            int idade = Integer.parseInt(txtIdadeC.getText());
            String raca = txtRacaC.getText().toUpperCase();

            this.Cachorro=new Cachorro(nome,  cor,  idade, raca, imageView.getImage().impl_getUrl());

            this.dialogStage.close();
        }
        else{
            labelStatusCadastroDog.setText ("Dados Inválidos");
            txtNomeC.requestFocus();
        }
    }

        private void limparCampos(){
            txtNomeC.clear();
            txtCorC.clear();
            txtIdadeC.requestFocus();
            txtRacaC.clear();
        }

    @FXML
    private void handleCancelarCadastro(ActionEvent event) {
        this.dialogStage.close();
    }

    private void initialize() {
        Stage stage = (Stage) btnCancelC.getScene().getWindow();
        stage.setResizable(false);
    }
}