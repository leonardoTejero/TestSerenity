package is.demo.serenity.steps;

import is.demo.serenity.pageObject.LoginPage;
import is.demo.serenity.utils.ConexionExcel;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    // Notacion @Step para definir que es un paso. dentro de () comentario opcional
    @Step("Usuario abre el navegador")
    public void abrirNavegador(String url){

        //con el objeto loginPage usar metodos predefinidos de PageObject o metodos propios como los getters
//        loginPage.openUrl("https://demo.serenity.is/");

        loginPage.openUrl(url);
    }

    @Step("Ingresa el usuario")
    public void enviarUsuario() throws IOException {

        //con el objeto loginPage usar metodos predefinidos de PageObject o metodos propios como los getters
        // utilizar getDriver cuando se localizó el elemento con Id

        //limpiar el campo
        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).clear();

        //enviar usuario
//        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).sendKeys("admin");

//        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).sendKeys(usuario);


//      obtener datos de archivo excel
        ArrayList<Map<String, String>> data = ConexionExcel.leerDatosDeHojaDeExcel("src/test/resources/data/DataExcel.xlsx", "Credenciales");
        String usuario = data.get(0).get("Usuario");

        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).sendKeys(usuario);
    }

    // Sobrecarga de metodo que acepta el envio de usuario
    @Step("Ingresa el usuario")
    public void enviarUsuario(String usuario){
        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).clear();
        loginPage.getDriver().findElement(loginPage.getTxtUsuario()).sendKeys(usuario);
    }

    @Step("Usuario ingresa la clave")
    public void enviarClave(String clave){

        //limpiar el campo
        loginPage.getDriver().findElement(loginPage.getTxtClave()).clear();

        //enviar clave
//        loginPage.getDriver().findElement(loginPage.getTxtClave()).sendKeys("serenity");

        loginPage.getDriver().findElement(loginPage.getTxtClave()).sendKeys(clave);
    }

    @Step("Clic en boton Iniciar sesion")
    public void clicInicioSesion(){

        loginPage.getDriver().findElement(loginPage.getBtnLogin()).click();
    }

    @Step
    public void validarAlerta(){

        // Regresa true si es correcto
        Assert.assertTrue(
                loginPage.getDriver().findElement(loginPage.getAlertLogin()).isDisplayed()
        );
    }

}
