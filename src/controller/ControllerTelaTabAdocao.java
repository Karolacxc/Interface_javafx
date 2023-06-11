package controller;

import data.DataCachorro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cachorro;

public class ControllerTelaTabAdocao extends Controller {

    @FXML
    private ImageView imageInserir;
    @FXML
    private ImageView imageEdit;
    @FXML
    private ImageView imageDelete;

    @FXML
    private TableView<Cachorro> tableCachorro;
    private DataCachorro dataCachorro = new DataCachorro();
    //  public ControllerTelaTabAdocao(){
    //      super();
    //      carregarTableCachorro();
    //     Cachorro dog1 = new Cachorro("Estudioso", "Amarelo", 4, "Caramelo");
    //     Cachorro dog2 = new Cachorro("Feijão", "Marrom Claro", 1, "Caramelo");
    //     Cachorro dog3 = new Cachorro("Tocão", "Amarelo", 8, "Caramelo");
    //     Cachorro dog4 = new Cachorro("Mel", "Marrom Escuro", 9, "Caramelo");
    //     Cachorro dog5 = new Cachorro("Bob", "Amarelo Alaranjado", 6, "Caramelo");
    //     Cachorro dog6 = new Cachorro("Romeu", "Amarelo Alaranjado", 8, "Caramelo");
    //     Cachorro dog7 = new Cachorro("Bento", "Preto com manchinhas marrom", 4, "Caramelo");
    //     Cachorro dog8 = new Cachorro("Bibi", "Preta com manchinhas marrom", 9, "Caramelo");

    //     dataCachorro.createCachorro(dog1);
    //     dataCachorro.createCachorro(dog2);
    //     dataCachorro.createCachorro(dog3);
    //     dataCachorro.createCachorro(dog4);
    //     dataCachorro.createCachorro(dog5);
    //     dataCachorro.createCachorro(dog6);
    //     dataCachorro.createCachorro(dog7);
    //     dataCachorro.createCachorro(dog8);
    // }
    // private Cachorro dog = new Cachorro();

    @FXML
    private TableColumn<Cachorro, String> tableColumnCachorroNome;
    @FXML
    private TableColumn<Cachorro, String> tableColumnCachorroCor;
    @FXML
    private TableColumn<Cachorro, Integer> tableColumnCachorroIdade;
    @FXML
    private TableColumn<Cachorro, String> tableColumnCachorroRaca;
    @FXML
    private TextField searchTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dataCachorro.getAllCachorros();
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        System.out.println("ControllerTelaTabAdocao.initialize()"+ dataCachorro.getListaCachorros());
        carregarTableCachorro();
    }

    private void carregarTableCachorro() {
        tableColumnCachorroNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnCachorroCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        tableColumnCachorroIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        tableColumnCachorroRaca.setCellValueFactory(new PropertyValueFactory<>("raca"));
        
        
        ObservableList<Cachorro> obsListaCachorro = FXCollections.observableArrayList();

        obsListaCachorro.addAll(dataCachorro.getListaCachorros());

        tableCachorro.setItems(obsListaCachorro);
    }


    @FXML
    private void handleAbrirFormularioCadastrarCachorro(MouseEvent event) throws IOException, Exception {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../tela/TelaAdm.fxml"));
        AnchorPane page = loader.load();

        // Cria o palco dialogStage.
        Stage dialogStage = new Stage();
        dialogStage.setTitle("DogDot - Doguinhos");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        ControllerTelaCadastrarDog controller = loader.getController();
        controller.setDialogStage(dialogStage);

        dialogStage.showAndWait();
        Cachorro cachorro = controller.getCachorro();
        if (cachorro != null) {
            dataCachorro.createCachorro(cachorro);
        }

        carregarTableCachorro();
    }

    @FXML
    private void handleAbrirFormularioAtualizarCachorro(MouseEvent event) throws IOException, Exception {
        Cachorro cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        if (cachorro != null) {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../tela/TelaAtualizarDogAdocao.fxml"));
            AnchorPane page = loader.load();

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("DogDot - Doguinhos");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define o Cachorro no controller.
            ControllerTelaAtualizarDog controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCachorro(cachorro);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();
            dataCachorro.updateCachorro(controller.getCachorro());
            carregarTableCachorro();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum Cachorro foi selecionado");
            alert.setContentText("Por favor, selecione um Cachorro na tabela.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handlePesquisarCachorro(KeyEvent event) throws Exception {
        ObservableList<Cachorro> obsListCachorro = FXCollections.observableArrayList();
        ArrayList<Cachorro> listCachorros = (ArrayList<Cachorro>) dataCachorro.getListaCachorros(); /// TAVA ANTES:
                                                                                                  /// ArrayList<Cachorro>
                                                                                                  /// listCachorros =
                                                                                                  /// dataCachorro.getAllCachorros();

        String nome = searchTextField.getText().toUpperCase();
        if (!nome.isEmpty()) {
            for (Cachorro cachorro : listCachorros) {
                if (cachorro.getNome().toUpperCase().startsWith(nome)) {
                    obsListCachorro.add(cachorro);
                }
            }
            tableCachorro.setItems(obsListCachorro);
        } else {
            carregarTableCachorro();
        }
    }

    @FXML
    private void handleRemoverCachorro(MouseEvent event) throws Exception {
        Cachorro cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        if (cachorro != null) {
            dataCachorro.deleteCachorro(cachorro);
            carregarTableCachorro();
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Nenhuma seleção");
            alert.setHeaderText("Nenhum Cachorro foi selecionado");
            alert.setContentText("Por favor, selecione um Cachorro na tabela.");
            alert.showAndWait();
        }
    }
}
