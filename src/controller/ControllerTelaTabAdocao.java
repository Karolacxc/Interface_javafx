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
import model.Adocao;

public class ControllerTelaTabAdocao implements Initializable {

    @FXML
    private TableView<Cachorro> tableSalgado;
    private DataCachorro dataCachorro = new DataCachorro();
    @FXML
    private TableColumn<?, ?> tableColumnCahorroNome;
    @FXML
    private TableColumn<?, ?> tableColumnCachorroIdade;
  
    @FXML
    private TextField textFieldPesquisaCachorro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregarTableCachorro();
    }    
    
    private void carregarTableCachorro() {
        tableColumnCahorroNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tableColumnCachorroIdade.setCellValueFactory(new PropertyValueFactory("idade"));
        
        try {
            ArrayList<Cachorro> listCachorros = (ArrayList<Cachorro>)dataCachorro.getAllCachorros();
            ObservableList obsListCachorro = FXCollections.observableArrayList(listCachorro);
            tableCachorro.setItems(obsListCachorro);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void handleAbrirFormularioCadastrarCachorro(MouseEvent event) throws IOException, Exception {
        // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControllerTelaTabAdocao.class.getResource("/fxml/telaCadastrarSalgado.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            
            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Doguinho Uesb - Doguinho");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
            ControllerTelaTabAdocao controller = loader.getController();
            controller.setDialogStage(dialogStage);
           
            dialogStage.showAndWait();
            Cachorro cachorro=controller.getCachorro();
            if (cachorro!=null){
                this.dataCachorro.createCachorro(cachorro);
            }
            
            carregarTableSalgado();
    }
 */
/* 
    @FXML
    private void handleAbrirFormularioAtualizarCachorro(MouseEvent event) throws IOException, Exception {
        Cachorro cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        if (cachorro != null){
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TelaAtualizarSalgadoController.class.getResource("/fxml/telaAtualizarSalgado.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
*/

            // Cria o palco dialogStage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Adoção Doguinhos - Cachorro");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Define o salgado no controller.
            TelaAtualizarSalgadoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCachorro(cachorro);

            // Mostra a janela e espera até o usuário fechar.
            dialogStage.showAndWait();
            this.dataSalgado.updateCachorro(controller.getCachorro());
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
        ArrayList<Cachorro> listCachorros = (ArrayList<Cachorro>)dataCachorro.getAllCachorro();
        
        String descricao = textFieldPesquisaCachorro.getText().toUpperCase();
        if (!descricao.isEmpty()){
            for (Cachorro s : listCachorro){
                if (s.getDescricao().startsWith(descricao))
                    obsListaCachorro.add(s);
            }
            tableCachorro.setItems(obsListSalgado);
        }
        else{
            carregarTableSalgado();
        }
    }
    
    @FXML
    private void handleRemoverSalgado(MouseEvent event) throws Exception {
        Cachorro cachorro = tableCachorro.getSelectionModel().getSelectedItem();
        dataSalgado.deleteCachorro(cachorro);
        carregarTableCachorro();
    }
}