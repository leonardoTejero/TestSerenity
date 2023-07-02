package is.demo.serenity.steps;

import is.demo.serenity.pageObject.DashBoardPage;
import is.demo.serenity.utils.EsperaExplicita;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;

public class DashBoardSteps {

    DashBoardPage dashBoardPage = new DashBoardPage();
    EsperaExplicita espera = new EsperaExplicita();

    // Igual que crear una instancia. para versiones de librerias superiores
//    @Page
//    DashBoardPage das;

    @Step("Validar titulo")
    public void validarTitulo(String mensaje){

        espera.esperaCargarPagina(dashBoardPage.getDriver());

//        Assert.assertThat(
//                "La respuesta es ",
//        saber si se muestra el elemento
//                dashBoardPage.getDriver().findElement(dashBoardPage.getLblTitle()).isDisplayed(),
//                Matchers.is(true)
//        );

        Assert.assertThat(
                "La respuesta es ",
//                obtener el texto del elemento
                dashBoardPage.getDriver().findElement(dashBoardPage.getLblTitle()).getText(),
//                comparar el mensaje del stepDefinition con el obtenido por el elemento de arriba
                equalTo(mensaje)
        );
    }


}
