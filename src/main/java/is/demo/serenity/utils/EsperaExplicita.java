package is.demo.serenity.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EsperaExplicita {

    // Espera que cargue para ejecutar la opcion, si carga antes, se ejecuta

    public void esperaExplicitaClick(WebDriver driver, By elemento){
        WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
        myWaitVar.until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public void esperaExplicitaTexto(WebDriver driver, By elemento){
        WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public void esperaCargarPagina(WebDriver driver){
        WebDriverWait myWaitVar = new WebDriverWait(driver, 30);
       driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }
}