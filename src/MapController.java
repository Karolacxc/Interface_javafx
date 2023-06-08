import java.util.HashMap;
import java.util.Map;

public class MapController {

    public static Map<String, Controller> mapController = new HashMap<>();         //constoi uma tabela assim q main é 
                                                                                    // inicializa, assim toda vez q uma Tela
                                                                        
                                                                                    //precisar ser aberta, uma linha dessa 
                                                                                    //tabela sera "puxada" para controller.
                                                                                
    public MapController() {
        mapController.put("TelaEscolhaDoguinho.fxml", new ControllerEscolhaDoguinho());
        mapController.put("telaDog01.fxml", new ControllerTelaDog01());
        mapController.put("telaDog02.fxml", new ControllerTelaDog02());
        mapController.put("telaelaDog03.fxml", new ControllerTelaDog03());
        mapController.put("TelaDog04.fxml", new ControllerTelaDog04());
        mapController.put("TelaDog05.fxml", new ControllerTelaDog05());
        mapController.put("TelaDog06.fxml", new ControllerTelaDog06());
        mapController.put("TelaDog07.fxml", new ControllerTelaDog07());
        mapController.put("TelaDog08.fxml", new ControllerTelaDog08());
        mapController.put("telaFormulario.fxml", new ControllerTelaFormulario());
        mapController.put("telaAdocConcluida.fxml", new ControllerTelaAdocConcluida());
        mapController.put("TelaLogin.fxml", new ControllerTelaLogin());

    }

}


