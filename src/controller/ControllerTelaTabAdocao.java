package controller;

import data.DataCachorro;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Cachorro;

public class ControllerTelaTabAdocao implements Initializable {

    @FXML
    private ImageView imageInserir;
    @FXML
    private ImageView imageEdit;
    @FXML
    private ImageView imageDelete;

    @FXML
    private TableView<Cachorro> tableCachorro;
    private DataCachorro dataCachorro = new DataCachorro();
    
    @FXML
    private TableColumn<?, ?> tableColumnCachorroNome;
    @FXML
    private TableColumn<?, ?> tableColumnCachorroCor;
    @FXML
    private TableColumn<?, ?> tableColumnCachorroIdade;
    @FXML
    private TableColumn<?, ?> tableColumnCachorroRaca;
    @FXML
    private TextField searchTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableCachorro();
    }    
    
    private void carregarTableCachorro() {
        tableColumnCachorroNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tableColumnCachorroCor.setCellValueFactory(new PropertyValueFactory("cor"));
        tableColumnCachorroIdade.setCellValueFactory(new PropertyValueFactory("idade"));
        tableColumnCachorroRaca.setCellValueFactory(new PropertyValueFactory("raca"));

        try {
            ArrayList<Cachorro> listCachorros = (ArrayList<Cachorro>)dataCachorro.getAllCachorros();
            ObservableList obsListCachorro = FXCollections.observableArrayList(listCachorros);
            tableCachorro.setItems(obsListCachorro);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void handleAbrirFormularioCadastrarCachorro(MouseEvent event) throws IOException, Exception {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControllerTelaCadastrarDog.class.getResource("/fxml/telaCadastrarCachorro.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Lanchonete Delicias - Cachorro");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            ControllerTelaCadastrarDog controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            Cachorro Cachorro=controller.getCachorro();
            if (Cachorro!=null){
                this.dataCachorro.createCachorro(Cachorro);
            }
            
            carregarTableCachorro();
    }
    
    @FXML
    private void handleAbrirFormularioAtualizarCachorro(MouseEvent event) throws IOException, Exception {
        Cachorro Cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        if (Cachorro != null){
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaAtualizarController.class.getResource("/fxml/telaAtualizarCachorro.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Lanchonete Delicias - Cachorro");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define o Cachorro no controller.
            TelaAtualizarCachorroController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCachorro(Cachorro);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();
            this.dataCachorro.updateCachorro(controller.getCachorro());
            carregarTableCachorro();
        }
        else{
             Alert alert = new Alert(AlertType.WARNING);
             alert.setTitle("Nenhuma seleção");
             alert.setHeaderText("Nenhum Cachorro foi selecionado");
             alert.setContentText("Por favor, selecione um Cachorro na tabela.");
             alert.showAndWait();
        }
    }

    @FXML
    private void handlePesquisarCachorro(KeyEvent event) throws Exception {
        ObservableList obsListCachorro = FXCollections.observableArrayList();
        ArrayList<Cachorro> listCachorros = (ArrayList<Cachorro>)dataCachorro.getAllCachorros();
        
        String descricao = textFieldPesquisaCachorro.getText().toUpperCase();
        if (!descricao.isEmpty()){
            for (Cachorro s : listCachorros){
                if (s.getDescricao().startsWith(descricao))
                    obsListCachorro.add(s);
            }
            tableCachorro.setItems(obsListCachorro);
        }
        else{
            carregarTableCachorro();
        }
    }
    
    @FXML
    private void handleRemoverCachorro(MouseEvent event) throws Exception {
        Cachorro Cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        dataCachorro.deleteCachorro(Cachorro);
        carregarTableCachorro();
    }
}

