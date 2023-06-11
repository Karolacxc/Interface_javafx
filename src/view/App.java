package view;
import model.Cachorro;
import model.Usuario;

import java.util.Scanner;

import data.DataCachorro;
import data.DataUsuario;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        DataUsuario dataUsuario = new DataUsuario();
        DataCachorro dataCaes = new DataCachorro();
        
        
        ArrayList <Cachorro> cachorrinhos = new ArrayList<>();

        // Adicionando as instâncias dos cachorrinhos
        Cachorro cao = new Cachorro("Estudioso", "Amarelo", 4, "Caramelo");
        dataCaes.createCachorro(cao);  
        Cachorro cao2 = new Cachorro("Feijão", "Marrom Claro", 1, "Caramelo");
        dataCaes.createCachorro(cao2);  
        Cachorro cao3 = new Cachorro("Tocão", "Amarelo", 8, "Caramelo");
        dataCaes.createCachorro(cao3);  
        Cachorro cao4 = new Cachorro("Mel", "Marrom Escuro", 9, "Caramelo");
        dataCaes.createCachorro(cao4);  
        Cachorro cao5 = new Cachorro("Bob", "Amarelo Alaranjado", 6, "Caramelo");
        dataCaes.createCachorro(cao5);  
        Cachorro cao6 = new Cachorro("Romeu", "Amarelo Alaranjado", 8, "Caramelo");
        dataCaes.createCachorro(cao6);  
        Cachorro cao7 = new Cachorro("Bento", "Preto com manchinhas marrom", 4, "Caramelo");
        dataCaes.createCachorro(cao7);  
        Cachorro cao8 = new Cachorro("Bibi", "Preta com manchinhas marrom", 9, "Caramelo");
        dataCaes.createCachorro(cao8);  
        

        System.out.println(menu());

        int op = input.nextInt();

        while (op != 0) {
            switch (op) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = input.next();
                    System.out.println("Digite a senha:");
                    String senha = input.next();
                    System.out.println("Digite o email:");
                    String email = input.next();
                    Usuario novoUsuario = new Usuario(nome, senha, email);
                    dataUsuario.createUsuario(novoUsuario);
                    System.out.println("Usuário criado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome de usuário:");
                    String username = input.next();
                    System.out.println("Digite a senha:");
                    String password = input.next();
    
                    Usuario usuario = dataUsuario.readUsuario(username,password);
                    if (usuario != null) {
                        System.out.println("Login bem-sucedido!");
                    } else {
                        System.out.println("Usuário ou senha inválidos!");
                    }
                    break;
                case 3:
                    System.out.println("Cachorrinhos disponíveis para adoção:");
                    System.out.println(dataCaes.getAllCachorros());
                    System.out.println("Digite o nome do cachorrinho que deseja adotar:");
                    String nomeCachorrinho = input.next();

                    // Implemente a lógica para adotar o cachorrinho com o nome especificado
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println(menu());
            op = input.nextInt();
        }

        input.close();
    }

    public static String menu() {
        return "SISTEMA DE ADOÇÃO DE CACHORRINHOS: \n" +
                "1- CRIAR CONTA\n" +
                "2- FAZER LOGIN\n" +
                "3- ADOTAR CACHORRINHO\n" +
                "0- SAIR\n" +
                "Digite uma opção:";
    }
}
