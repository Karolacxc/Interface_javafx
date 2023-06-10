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
    private final String nomeArquivo = "cachorro.ser";
    private final String cachorrosAdotados = "adotados.dat";
     
   public List<Cachorro> getAllCachorros() throws IOException, Exception {
    ArrayList<Cachorro> cao = new ArrayList<>();
    File arq = new File(nomeArquivo);
    if (!arq.exists()) {
        arq.createNewFile();
        return cao;
    }
    FileInputStream fluxo;
    ObjectInputStream lerObj = null;
    try {
        fluxo = new FileInputStream(arq);
        lerObj = new ObjectInputStream(fluxo);
        cao = (ArrayList<Cachorro>) lerObj.readObject();
    } catch (FileNotFoundException ex) {
        System.out.println("Erro ao listar cachorros");
        throw new Exception("Erro ao listar cachorros");
    } catch (ClassNotFoundException | IOException ex) {
        System.out.println("Erro ao listar cachorros");
        throw new Exception("Erro ao listar cachorros");
    } finally {
        if (lerObj != null) {
            lerObj.close();
        }
    }
    return cao;
}

    
    public void createCachorro(Cachorro cao) throws Exception {
          ArrayList <Cachorro> caes = (ArrayList<Cachorro>) getAllCachorros();
          caes.add(cao);
          try{
             FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
             ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
             escreverObj.writeObject(caes);
             escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar cachorro");
            throw new Exception ("Erro ao cadastrar cachorro");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar cachorro");
            throw new Exception ("Erro ao cadastrar cachorro");
        }
    }
    
    public Cachorro readCachorro(String nome) throws Exception {
       ArrayList <Cachorro> caes = (ArrayList<Cachorro>) getAllCachorros();
       Cachorro cao = null;
         for (int i = 0; i < caes.size(); i++){
             if (nome.equals(caes.get(i).getNome())){
                 cao = caes.get(i);
                 break;
             }
         }
         return cao;
    }
    

    public void updateCachorro(Cachorro cachorro) throws Exception {
        ArrayList <Cachorro> cao = (ArrayList<Cachorro>) getAllCachorros();
        boolean achou=false;
        for (int i=0; i<cao.size(); i++){
             if (cachorro.getNome() == cao.get(i).getNome()){
                 cao.remove(i);
                 cao.add(cachorro);
                 achou=true;
                 break;
             }
        }
        if (achou){
            atualizarArquivo(cao);
        }
    }

    public void deleteCachorro(Cachorro cachorro) throws Exception {
        ArrayList <Cachorro> cao = (ArrayList<Cachorro>) getAllCachorros();
        boolean achou=false;
        for (int i=0; i<cao.size(); i++){
            if (cachorro.getNome() == cao.get(i).getNome()){
                 cao.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(cao);
        } 
    }
    
    private void atualizarArquivo (ArrayList <Cachorro> cao ) throws Exception{
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(cao);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar cachorro");
            throw new Exception ("Erro ao cadastrar cachorro");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar cachorro");
            throw new Exception ("Erro ao cadastrar cachorro");
        }
    }
   
}
