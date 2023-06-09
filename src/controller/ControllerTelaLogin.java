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
    private Button btnLogar;

    private DataUsuario dataUsuario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dataUsuario = new DataUsuario();
        dataUsuario.adicionarUsuariosPreEstabelecidos();
        try {
            dataUsuario.getAllUsuarios();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        btnLogar.setOnAction(event -> {
            String nome = caixaTexto01.getText();
            String senha = caixaTexto02.getText();

            try {
                Usuario user = loginUsuario(nome, senha);
                if (user != null) {
                    ControllerTelaTabAdocao.user=user;
                    
                    mudarTela("../tela/TelaTabAdocao.fxml", event);
                } else {
                    // Exibir mensagem de login inválido
                }
            } catch (Exception e) {
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

    private Usuario loginUsuario(String nome, String senha) throws Exception {
        for (Usuario usuario : dataUsuario.getListaUsuarios()) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}