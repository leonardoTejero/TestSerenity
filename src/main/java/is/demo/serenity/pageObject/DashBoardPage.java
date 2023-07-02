package is.demo.serenity.pageObject;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class DashBoardPage extends PageObject {

    //variable tipo By, import de selenium
    By lblTitle = By.xpath("//h1[text()='Dashboard']");

    public By getLblTitle() {
        return lblTitle;
    }
}
