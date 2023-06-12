// package controller;

// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.util.ArrayList;

// import data.DataUsuario;
// import login.*;

// public class ControleUsuario {
//     private ArrayList<Login> login = new ArrayList<>();

//     public void cadastrarUsuario(String nome,String senha, String email) {
//         Login log = new Login(nome,senha,email);
//         log.cadastrarLogin(log);
//         login.add(new Login(nome,senha, email));
//     }

//     public ArrayList<Login> listarUsuario() throws FileNotFoundException, IOException, ClassNotFoundException {
//         DataUsuario logDados = new DataUsuario();
//         ArrayList<Login> lista = logDados.listarUsuario();
//         return lista;
//     }

//     public Login pesquisarLogin(String email) throws IOException, FileNotFoundException, ClassNotFoundException {
//         ArrayList<Login> listLogin = listarUsuario();
//         for (Login l: listLogin) {
//             if (email.equals(l.getEmail())) {
//                 return l;
//             }
//         }
//         return null;
//     }

//     public boolean loginUsuario(String email, String senha)
//             throws FileNotFoundException, IOException, ClassNotFoundException {
//         Login login = pesquisarLogin(email);
//         if (login.getSenha().equals(senha)) {
//             return true;
//         } else {
//             return false;
//         }
//     }
// }
