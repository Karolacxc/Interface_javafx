package data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

@SuppressWarnings("unchecked")
public class DataUsuario {
    private final String nomeArquivo = "user.ser";
    private ArrayList<Usuario> usuarios;

    public DataUsuario() {
        usuarios = new ArrayList<>();
    }

    public List<Usuario> getListaUsuarios() {
        return usuarios;
    }

    public List<Usuario> getAllUsuarios() throws IOException, Exception {
        File arq = new File(nomeArquivo);
        if (!arq.exists()) {
            arq.createNewFile();
            return usuarios;
        }

        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try {
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            usuarios = (ArrayList<Usuario>) lerObj.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Erro ao listar usuários");
            throw new Exception("Erro ao listar usuários");
        } finally {
            if (lerObj != null) {
                try {
                    lerObj.close();
                } catch (IOException ex) {
                    System.out.println("Erro ao fechar o ObjectInputStream");
                    throw new Exception("Erro ao fechar o ObjectInputStream");
                }
            }
        }
        return usuarios;
    }

    public void createUsuario(Usuario usuario) {
        if (usuarios.add(usuario)) {
            
            try {
                atualizarArquivo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }

    private void atualizarArquivo() {
        try {
            FileOutputStream fluxo = new FileOutputStream(new File(nomeArquivo), false);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(usuarios);
            escreverObj.close();
        } catch (IOException ex) {
            System.out.println("Erro ao atualizar o arquivo de usuários");
            ex.printStackTrace();
        }
    }

    public Usuario readUsuario(String nome) {
        for (Usuario user : usuarios) {
            if (user.getNome().equals(nome))
                return user;
        }
        return null;
    }

    public void adicionarUsuariosPreEstabelecidos() {
        Usuario usuario1 = new Usuario("João", "123456789", "joao@example.com", "senha123", "Rua A");
        Usuario usuario2 = new Usuario("Maria", "987654321", "maria@example.com", "senha456", "Rua B");

        createUsuario(usuario1);
        createUsuario(usuario2);

        atualizarArquivo();
    }
}