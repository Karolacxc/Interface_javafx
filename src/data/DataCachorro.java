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
import model.Cachorro;

@SuppressWarnings("unchecked")
public class DataCachorro {
    private static final String nomeArquivo = "cachorro.ser";
    private final String cachorrosAdotados = "adotados.dat";

    public static ArrayList<Cachorro> listaCachorros = new  ArrayList<Cachorro>( 
        
        );
    
    public List<Cachorro> getListaCachorros() {
        return listaCachorros;
    }
    
    public List<Cachorro> getAllCachorros() throws IOException, Exception {
        File arq = new File(nomeArquivo);
        if (!arq.exists()) {
            arq.createNewFile();
            return listaCachorros;
        }

        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        
        listaCachorros.clear();//limpa a tela e começa de novo.

        try {
            fluxo = new FileInputStream(arq);
            lerObj = new ObjectInputStream(fluxo);

            listaCachorros= (ArrayList<Cachorro>)lerObj.readObject();
                        
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao listar cachorros");
          
        } catch (ClassNotFoundException  ex) {
            System.out.println("Erro ao listar dogs");
         
        }catch ( IOException ex){
           
            ex.printStackTrace();
        
        } finally {
            if (lerObj != null) {
                lerObj.close();
            }
            
        }

        return listaCachorros;
    }

    public void createCachorro(Cachorro cao) {
        if (!listaCachorros.contains(cao))
        if(listaCachorros.add(cao))
            try {
                atualizarArquivo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }

    public Cachorro readCachorro(String nome) {
        List<Cachorro> caes = getListaCachorros();
        Cachorro cao = null;
        for (int i = 0; i < caes.size(); i++) {
            
            if (nome.equals(caes.get(i).getNome())) {
                cao = caes.get(i);
                break;
            }
        }
        return cao;
    }

    public void updateCachorro(Cachorro cachorro) {
        List<Cachorro> cao = getListaCachorros();
        boolean achou = false;
        for (int i = 0; i < cao.size(); i++) {
            if (cao.get(i).equals(cachorro)) {
                cao.remove(i);
                cao.add(cachorro);
                achou = true;
                break;
            }
        }
        if (achou) {
            atualizarArquivo();
        }
    }

    public static void deleteCachorro(Cachorro cachorro) {
        
        if (listaCachorros.remove(cachorro)) {
            atualizarArquivo();
        }
    }

    public static void atualizarArquivo() {
        try {
            File file = new File (nomeArquivo);

            FileOutputStream fluxo = new FileOutputStream(file, false);//aqui cria um novo arquivo em cima do que já tem.
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
           
                escreverObj.writeObject(listaCachorros);
   
           
            escreverObj.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao cadastrar cachorro1.");
            
        } catch (IOException ex) {
            System.out.println("Erro ao cadastrar cachorro");
        }
    }
    public static void inicializarArquivo() {
        try {
            File file = new File (nomeArquivo);
            if (!file.exists() || file.length()<=0 ) {

            FileOutputStream fluxo = new FileOutputStream(file, false);//aqui cria um novo arquivo em cima do que já tem.
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
           
               
            escreverObj.writeObject(listaCachorros);
               escreverObj.close();

           }

        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao cadastrar cachorro1.");
            
        } catch (IOException ex) {
            System.out.println("Erro ao cadastrar cachorro");
        }
    }
       

}
