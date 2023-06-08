/*
package controller;
import model.Usuario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CadastroUsuario {

    ArrayList <Usuario> user = new ArrayList<>();

    public void cadastrarUsuario (Usuario usuario) throws IOException{
        FileOutputStream arquivo = new FileOutputStream("usuario.ser");
        ObjectOutputStream gravarusuario = new ObjectOutputStream(arquivo);
        gravarusuario.writeObject(usuario);
        gravarusuario.close();
    }
   
    public ArrayList<Usuario> listarUsuario () throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ArrayList <Usuario> listarusuarios = new ArrayList<>();
        
        FileInputStream arquivo = new FileInputStream("usuario.ser");
        ObjectInputStream lerUsuario;
        while (arquivo.available()>0){
        lerUsuario = new ObjectInputStream(arquivo);
        Usuario a = (Usuario) lerUsuario.readObject();
        listarusuarios.add(a);
        arquivo.close();
        }
        return listarusuarios;
    }
  
    public Usuario pesquisarUsuario(int codigo) throws FileNotFoundException, ClassNotFoundException, IOException{
        for (int i = 0; i < listarUsuario().size(); i++) {
        Usuario usuario = listarUsuario().get(i);
        if (usuario.getCodigo() == codigo) {
            return usuario;
        }
    }
    return null;
    }
}   

*/



    