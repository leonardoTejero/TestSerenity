package is.demo.serenity.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

//crear la herencia de pageObject
public class LoginPage extends PageObject {

    // Crear los localizadores
    By txtUsuario = By.id("LoginPanel0_Username");

    // By txtUsuario = By.xpath("//*ejemplo[@atributo=''");
    By txtClave = By.id("LoginPanel0_Password");
    By btnLogin = By.id("LoginPanel0_LoginButton");
    By alertLogin = By.xpath("//div[@class='toast-message']");

    // Crear getters y setters necesarios
    public By getTxtUsuario() {
        return txtUsuario;
    }

    public By getTxtClave() {
        return txtClave;
    }

    public By getBtnLogin() {
        return btnLogin;
    }

    public By getAlertLogin() {
        return alertLogin;
    }
}

