/* 

package data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

//aaaaa
public class DataUsuario {
    private final String nomeArquivo = "usuario.ser";
     
    public List<Usuario> getAllUsuarios() throws Exception {
        ArrayList <Usuario> user = new ArrayList();
        File arq = new File (nomeArquivo);
        if (!arq.exists()){
            arq.createNewFile();
            return user;
        }
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);
            user = (ArrayList<Usuario>)lerObj.readObject();
            lerObj.close();
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao listar usuarios");
            throw new Exception ("Erro ao listar usuarios");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println ("Erro ao listar usuarios");
            throw new Exception ("Erro ao listar usuarios");
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
       Usuario user=null;
         for (int i=0; i<users.size(); i++){
             if (nome.equals(users.get(i).getNome())){
                 user = users.get(i);
                 break;
             }
         }
         return user;
    }
    

    public void updateUsuario(Usuario usuario) throws Exception {
        ArrayList <Usuario> user = (ArrayList<Usuario>) getAllUsuarios();
        boolean achou=false;
        for (int i=0; i<user.size(); i++){
             if (usuario.getNome() == user.get(i).getNome()){
                 user.remove(i);
                 user.add(usuario);
                 achou=true;
                 break;
             }
        }
        if (achou){
            atualizarArquivo(user);
        }
    }

    public void deleteUsuario(Usuario usuario) throws Exception {
        ArrayList <Usuario> user = (ArrayList<Usuario>) getAllUsuarios();
        boolean achou=false;
        for (int i=0; i<user.size(); i++){
            if (usuario.getNome() == user.get(i).getNome()){
                 user.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(user);
        } 
    }
    
    private void atualizarArquivo (ArrayList <Usuario> user ) throws Exception{
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(user);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar usuario");
            throw new Exception ("Erro ao cadastrar usuario");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar usuario");
            throw new Exception ("Erro ao cadastrar usuario");
        }
    }
   
}

*/