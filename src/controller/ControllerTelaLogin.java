package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import data.DataUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Usuario;

public class ControllerTelaLogin extends Controller {

    @FXML
    private TextField caixaTexto01; // login
    @FXML
    private TextField caixaTexto02; // senha
    @FXML
    private Button btnCadastro;
    @FXML
    private Button btnLogarAdm;
    @FXML
    private Button btnLogar;

    private DataUsuario dataUsuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataUsuario = new DataUsuario();
        dataUsuario.adicionarUsuariosPreEstabelecidos();

        btnLogar.setOnMouseClicked(event -> {
            String nome = caixaTexto01.getText();
            String senha = caixaTexto02.getText();

            try {
                boolean entrou = loginUsuario(nome, senha);
                if (entrou) {
                    mudarTela("../tela/TelaTabAdocao.fxml", event);
                } else {
                    // Exibir mensagem de login inválido
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnLogarAdm.setOnMouseClicked(event -> {
            try {
                mudarTela("../tela/telaAdm.fxml", event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnCadastro.setOnMouseClicked(event -> {
            try {
                mudarTela("../tela/TelaCadastro.fxml", event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private boolean loginUsuario(String nome, String senha) throws Exception {
        for (Usuario usuario : dataUsuario.getListaUsuarios()) {
            if (usuario.getEmail().equals(nome) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}