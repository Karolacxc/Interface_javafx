package view;
import login.*;
import model.Adocao;
import model.Cachorro;
import model.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.ControleAdocao;
import controller.ControleCaes;
import controller.ControleUsuario;

public class ApiiProjeto {
    
    public static String menu(){
        return "SISTEMA DE ADOÇÃO DE CACHORRINHOS: \n" +
                "1- CRIAR CONTA\n" +
                "2- FAZER LOGIN\n" +
                "3- ADOTAR CACHORRINHO\n";
    }

    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        
        Scanner input = new Scanner(System.in);
        ControleAdocao controleAdocao = new ControleAdocao();
        ControleUsuario controleUsuario = new ControleUsuario();
        ControleCaes controleCaes = new ControleCaes();
        
        
        ArrayList <Cachorro> cachorrinhos = new ArrayList<>();

        // Adicionando as instâncias dos cachorrinhos
        controleCaes.cadastro("Estudioso", "Amarelo", 4, "Caramelo");
        controleCaes.cadastro("Feijão", "Marrom Claro", 1, "Caramelo");
        controleCaes.cadastro("Tocão", "Amarelo", 8, "Caramelo");
        controleCaes.cadastro("Mel", "Marrom Escuro", 9, "Caramelo");
        controleCaes.cadastro("Bob", "Amarelo Alaranjado", 6, "Caramelo");
        controleCaes.cadastro("Romeu", "Amarelo Alaranjado", 8, "Caramelo");
        controleCaes.cadastro("Bento", "Preto com manchinhas marrom", 4, "Caramelo");
        controleCaes.cadastro("Bibi", "Preta com manchinhas marrom", 9, "Caramelo");
        
        System.out.print(menu());
        int op = input.nextInt();
        
           while (op != 0) {
	    	 switch (op) {
		    	 case (1): { // CRIAR CONTA
                                System.out.println("Nome de usuário: ");
                                String nomeUsuario = input.next();
                                System.out.println("Senha: ");
                                String senhaUsuario = input.next();
                                System.out.println("E-mail: ");
                                String emailUsuario = input.next();
                                controleUsuario.cadastrarUsuario(nomeUsuario, senhaUsuario, emailUsuario);
                                System.out.println("\nConta criada com sucesso!\n\n");
                                break;
                          }

                           case (2): { // FAZER LOGIN
                                System.out.println("E-mail: ");
                                String emailLogin = input.next();
                                System.out.println("Senha: ");
                                String senhaLogin = input.next();
                                boolean loginSucesso = controleUsuario.loginUsuario(emailLogin, senhaLogin);
                                if (loginSucesso) {
                                    System.out.println("\nLogin realizado com sucesso!\n\n");
                                } else {
                                    System.out.println("\nE-mail ou senha incorretos. Tente novamente.\n\n");
                                } 
                        
                                break;
                            }
                           case (3): { // ADOTAR CACHORRINHO
           
                                 System.out.println("Nome de usuário: ");
                                 String nomeUsuario = input.next();
                                 System.out.println("Telefone: ");
                                 String telefoneUsuario = input.next();
                                 System.out.println("E-mail ");
                                 String emailUsuario = input.next();
                                 System.out.println("Senha: ");
                                 String senhaUsuario = input.next();
                                 System.out.println("Endereço: ");
                                 String endereUsuario = input.next();
                                 System.out.println("Código: ");
                                 int codUsuario = input.nextInt();
                                 
                                 Usuario user = new Usuario(nomeUsuario, telefoneUsuario, emailUsuario, senhaUsuario, endereUsuario, codUsuario);
                                 
                                 System.out.println("\nConfira a lista de cachorrinhos esperando por adoção: \n");
                                 System.out.println(controleCaes.listaDogs());
                                 
                                 System.out.println("Escolha o cachorrinho desejado: ");
                                 int cachorrEscolh = input.nextInt();
                                 
                                 switch (cachorrEscolh){
                                     case (1): {
                                         Cachorro cachorrinho = new Cachorro("Estudioso", "Amarelo", 4, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              //cachorrinho.RemoverCachorro("Estudioso");
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                        
                       
                                         break;
                                     }
                                     
                                     case (2): {
                                         Cachorro cachorrinho = new Cachorro("Feijão", "Marrom Claro", 1, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                          Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (3): {
                                         Cachorro cachorrinho = new Cachorro("Tocão", "Amarelo", 8, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (4): {
                                         Cachorro cachorrinho = new Cachorro("Mel", "Marrom Escuro", 9, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (5): {
                                         Cachorro cachorrinho = new Cachorro("Bob", "Amarelo Alaranjado", 6, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (6): {
                                         Cachorro cachorrinho = new Cachorro("Romeu", "Amarelo Alaranjado", 8, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (7): {
                                         Cachorro cachorrinho = new Cachorro("Bento", "Preto com manchinhas marrom", 4, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                     
                                     case (8): {
                                         Cachorro cachorrinho = new Cachorro("Bibi", "Preta com manchinhas marrom", 9, "Caramelo");
                                         Adocao adocao = new Adocao(cachorrinho, user);
                                         Login usuarioExiste = controleUsuario.pesquisarLogin(emailUsuario);
                                         if (usuarioExiste != null) {
                                              controleAdocao.cadastrarAdocao(adocao);
                                              System.out.println("\nAdoção realizada com sucesso!\n\n");
                                          } else {
                                            System.out.println("\nAdoção não permitida. Usuário não cadastrado.\n\n");
                                         } 
                                         break;
                                     }
                                 }
                                 
                                 break;
                            }

                        
               }
                 System.out.println(menu());
                 op = input.nextInt();
            }
           
        input.close();   
    }
}