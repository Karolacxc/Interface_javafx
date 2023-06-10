package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.Cachorro;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerTelaTabAdocao extends Controller{
    @FXML
    private AnchorPane rootPane;

    @FXML
    private ButtonBar searchButtonBar;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<Cachorro> tableView;

    @FXML
    private TableColumn<Cachorro, String> nomeColumn;

    @FXML
    private TableColumn<Cachorro, String> idadeColumn;

    @FXML
    private TableColumn<Cachorro, String> corColumn;

    @FXML
    private TableColumn<Cachorro, String> racaColumn;

   
       
    private void filterTable(String searchTerm, ObservableList<Cachorro> cachorrosList) {
        // Filtrar pelo nome, idade e cor
        ObservableList<Cachorro> filteredList = FXCollections.observableArrayList();

        for (Cachorro cachorro : cachorrosList) {
            if (cachorro.getNome().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    cachorro.getCor().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    cachorro.getIdade().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    cachorro.getRaca().toLowerCase().contains(searchTerm.toLowerCase())) {
                filteredList.add(cachorro);
            }
        }

        tableView.setItems(filteredList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        corColumn.setCellValueFactory(cellData -> cellData.getValue().corProperty());
        idadeColumn.setCellValueFactory(cellData -> cellData.getValue().idadeProperty());
        racaColumn.setCellValueFactory(cellData -> cellData.getValue().racaProperty());

        // Adicionar cachorros à tabela
        ObservableList<Cachorro> cachorrosList = FXCollections.observableArrayList(
                new Cachorro("Estudioso", "Amarelo", "4 anos", "Caramelo"),
                new Cachorro("Dorinha", "Marrom", "6 anos", "Caramelo"),
                new Cachorro("Mel", "Preto", "9 anos", "Caramelo"),
                new Cachorro("Bob", "Amarelo", "5 anos", "Caramelo"),
                new Cachorro("Bento", "Preto e Amarelo", "4 anos", "Caramelo"),
                new Cachorro("Chocolate", "Amarelo", "6 anos", "Caramelo"),
                new Cachorro("Romeu", "Caramelo", "8 anos", "Caramelo"),
                new Cachorro("Jocao", "Amarelo claro", "8 anos", "Caramelo")
        );

        tableView.setItems(cachorrosList);

        // Configurar comportamento de busca
        searchButtonBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String searchTerm = searchTextField.getText();
                filterTable(searchTerm, cachorrosList);
            }
        });
    }

    }

