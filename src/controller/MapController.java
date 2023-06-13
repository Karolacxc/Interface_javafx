package controller;
import java.util.HashMap;
import java.util.Map;

public class MapController {

    public static Map<String, Controller> mapController = new HashMap<>();         //constoi uma tabela assim q main é 
                                                                                    // inicializa, assim toda vez q uma Tela

                                                                                    //precisar ser aberta, uma linha dessa 
                                                                                    //tabela sera "puxada" para controller.

    public MapController() {
        mapController.put("../tela/TelaLogin.fxml", new ControllerTelaLogin());
        mapController.put("../tela/TelaCadastro.fxml", new ControllerTelaCadastro());

        mapController.put("../tela/TelaTabAdocao.fxml", new ControllerTelaTabAdocao());
       
        mapController.put("../tela/TelaAtualizarDogAdocao.fxml", new ControllerTelaAtualizarDog());
        mapController.put("../tela/TelaCadastraDogAdocao.fxml", new ControllerTelaCadastrarDog());

        mapController.put("../tela/TelaDogGeral.fxml", new ControllerDogGeral());
        mapController.put("../tela/TelaFormulario.fxml", new ControllerTelaFormulario());
        mapController.put("../tela/TelaAdocConcluida.fxml", new ControllerTelaAdocConcluida());


    }

}