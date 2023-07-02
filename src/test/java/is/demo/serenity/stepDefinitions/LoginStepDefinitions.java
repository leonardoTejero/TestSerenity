package is.demo.serenity.stepDefinitions;

import cucumber.api.DataTable;
import is.demo.serenity.steps.DashBoardSteps;
import is.demo.serenity.steps.LoginSteps;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.es.*;

import java.io.IOException;


// Crear la definicion del escenario. Snippets
public class LoginStepDefinitions {

    // Crear instancia o usar la notacion @Steps
    @Steps
    LoginSteps loginSteps;
    @Steps
    DashBoardSteps  dashBoardSteps;

    //Definicion de los pasos del escenario
    // El nombre de los metodos no tiene que ser igual al del escenario @cuando, etc
    @Dado("^que el usuario abre la pagina demo serenity \"([^\"]*)\"$")
    public void queElUsuarioAbreLaPaginaDemoSerenity(String url) {

        //Usar los metodos creados en los Steps
        loginSteps.abrirNavegador(url);
    }

    @Cuando("^el usuario modifique las credenciales de ingreso y da clic en ingresar$")
    public void elUsuarioModifiqueLasCredencialesDeIngresoYDaClicEnIngresar(DataTable credenciales) throws IOException {

        //Obtener los datos del data Table del escenario
//        String usuario = credenciales.cells(1).get(0).get(0);
        String clave = credenciales.cells(1).get(0).get(1);

        loginSteps.enviarUsuario();
        loginSteps.enviarClave(clave);
        loginSteps.clicInicioSesion();
    }

//    @Entonces("el usuario visualiza el mensaje Dashboard")
//    public void elUsuarioVisualizaElMensaje()

    @Entonces("^el usuario visualiza el mensaje \"([^\"]*)\"$")
    public void elUsuarioVisualizaElMensaje(String mensaje) {

        dashBoardSteps.validarTitulo(mensaje);
    }


    // Segundo Escenario **** Login Fallido  ****
    @Cuando("^el usuario ingrese las credenciales incorrectas y da clic en ingresar$")
    public void elUsuarioIngreseLasCredencialesIncorrectasYDaClicEnIngresar(DataTable credenciales) throws IOException {

        loginSteps.enviarUsuario(credenciales.cells(1).get(0).get(0));
        loginSteps.enviarClave(credenciales.cells(1).get(0).get(1));
        loginSteps.clicInicioSesion();
    }


    @Entonces("^el usuario visualiza una alerta en pantalla$")
    public void elUsuarioVisualizaUnaAlertaEnPantalla() {

        loginSteps.validarAlerta();
    }

}
