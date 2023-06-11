package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

@SuppressWarnings("unchecked")
public class DataUsuario {
    private final String nomeArquivo = "login.ser";

    public List<Usuario> getAllUsuarios() throws IOException, Exception {
        ArrayList<Usuario> user = new ArrayList<>();
        File arq = new File(nomeArquivo);
        if (!arq.exists()) {
            arq.createNewFile();
            return user;
        }
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try {
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            user = (ArrayList<Usuario>) lerObj.readObject();
            lerObj.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao listar usuários");
            throw new Exception("Erro ao listar usuários");
        } catch (ClassNotFoundException | IOException ex) {
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
        return user;
    }

    public void createUsuario(Usuario user) throws Exception {
        ArrayList<Usuario> users = (ArrayList<Usuario>) getAllUsuarios();
        users.add(user);
        try {
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(users);
            escreverObj.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao cadastrar usuario");
            throw new Exception("Erro ao cadastrar usuario");
        } catch (IOException ex) {
            System.out.println("Erro ao cadastrar usuario");
            throw new Exception("Erro ao cadastrar usuario");
        }
    }

    public Usuario readUsuario(String nome, String senha) throws Exception {
        ArrayList<Usuario> users = (ArrayList<Usuario>) getAllUsuarios();
        Usuario user = null;
        for (int i = 0; i < users.size(); i++) {
            if ((nome.equals(users.get(i).getNome())) && (senha.equals(users.get(i).getSenha()))) {
                user = users.get(i);
                break;
            }
        }
        return user;
    }
    
}