package controller;
import java.util.HashMap;
import java.util.Map;

public class MapController {

    public static Map<String, Controller> mapController = new HashMap<>();         //constoi uma tabela assim q main é 
                                                                                    // inicializa, assim toda vez q uma Tela
                                                                        
                                                                                    //precisar ser aberta, uma linha dessa 
                                                                                    //tabela sera "puxada" para controller.
                                                                                
    public MapController() {
//      mapController.put("TelaEscolhaDoguinho.fxml", new ControllerEscolhaDoguinho());
       
        mapController.put("telaFormulario.fxml", new ControllerTelaFormulario());
        mapController.put("telaAdocConcluida.fxml", new ControllerTelaAdocConcluida());
        mapController.put("TelaLogin.fxml", new ControllerTelaLogin());

    }

}


