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
import model.Cachorro;
import login.Login;

public class DataUsuario {

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
        ObjectInputStream lerObj = new ObjectInputStream(fluxo);
        listaUsuario = (ArrayList<Login>) lerObj.readObject();
        return listaUsuario;
    }   
}