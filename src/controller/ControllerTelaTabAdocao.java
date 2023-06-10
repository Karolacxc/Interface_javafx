package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import model.Cachorro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControllerTelaTabAdocao {
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

    public void initialize() {
        // Configurar colunas da tabela
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
        idadeColumn.setCellValueFactory(cellData -> cellData.getValue().idadeProperty());
        corColumn.setCellValueFactory(cellData -> cellData.getValue().corProperty());
        racaColumn.setCellValueFactory(cellData -> cellData.getValue().racaProperty());

        // Adicionar cachorros à tabela
        tableView.getItems().addAll(
                new Cachorro("Estudioso", "4 anos", "Amarelo", "Caramelo"),
                new Cachorro("Dorinha", "6 anos", "Marrom", "Caramelo"),
                new Cachorro("Mel", "9 anos", "Preto", "Caramelo"),
                new Cachorro("Bob", "5 anos", "Amarelo", "Caramelo"),
                new Cachorro("Bento", "4 anos", "Preto e Amarelo", "Caramelo"),
                new Cachorro("Chocolate", "6 anos", "Amarelo", "Caramelo"),
                new Cachorro("Romeu", "8 anos", "Caramelo", "Caramelo"),
                new Cachorro("Jocao", "8 anos", "Amarelo claro", "Caramelo")
        );

        // Configurar comportamento de busca
        searchButtonBar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String searchTerm = searchTextField.getText();
                filterTable(searchTerm);
            }
        });
    }

    private void filterTable(String searchTerm) {
        // Filtrar pelo nome, idade e cor
        ObservableList<Cachorro> filteredList = FXCollections.observableArrayList();

        Cachorro[] cachorrosList;
        for (Cachorro cachorro : cachorrosList) {
            if (cachorro.getNome().toLowerCase().contains(searchTerm.toLowerCase())
                     cachorro.getIdade().toLowerCase().contains(searchTerm.toLowerCase())
                     cachorro.getCor().toLowerCase().contains(searchTerm.toLowerCase())) 
                    cachorro.getRaca().toLowerCase().contains(searchTerm.toLowerCase())){
                filteredList.add(cachorro);
            }
        }

        tableView.setItems(filteredList);
    }

}