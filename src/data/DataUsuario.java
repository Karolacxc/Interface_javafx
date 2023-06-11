package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import login.Login;

@SuppressWarnings("unchecked")
public class DataUsuario {
    private final String nomeArquivo = "usuario.ser";
     
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
          ArrayList <Usuario> users = (ArrayList<Usuario>) getAllUsuarios();
          users.add(user);
          try{
             FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
             ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
             escreverObj.writeObject(users);
             escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar usuario");
            throw new Exception ("Erro ao cadastrar usuario");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar usuario");
            throw new Exception ("Erro ao cadastrar usuario");
        }
    }
    
    public Usuario readUsuario(String nome) throws Exception {
       ArrayList <Usuario> users = (ArrayList<Usuario>) getAllUsuarios();
       Usuario user = null;
         for (int i = 0; i < users.size(); i++){
             if (nome.equals(users.get(i).getNome())){
                 user = users.get(i);
                 break;
             }
         }
         return user;
    }
    

    public void cadastrarLogin(Login Usuario) {

        ArrayList<Login> listaUsuario = new ArrayList<>();
        try {
            listaUsuario = listarUsuario();
        } catch (FileNotFoundException e) {
            File arquivo = new File("dados/user.ser");
            try {
                arquivo.createNewFile();
            } catch (IOException x) {
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try {
            listaUsuario.add(Usuario);

            File endereco = new File("dados/user.ser");
            FileOutputStream fluxo = new FileOutputStream(endereco);
            ObjectOutputStream oos = new ObjectOutputStream(fluxo);
            System.out.println("parte 2");
            oos.writeObject(listaUsuario);
            oos.flush();
            fluxo.flush();
            oos.close();
            fluxo.close();
            System.out.println("parte 3");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Login> listarUsuario() throws FileNotFoundException, IOException, ClassNotFoundException {
        ArrayList<Login> listaUsuario;
        File endereco = new File("dados/user.ser");
        FileInputStream fluxo = new FileInputStream(endereco);
        try (ObjectInputStream lerObj = new ObjectInputStream(fluxo)) {
            listaUsuario = (ArrayList<Login>) lerObj.readObject();
        }
        return listaUsuario;
    }   
}