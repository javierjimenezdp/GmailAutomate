package PageObject;

import StepDefinitions.Hooks;
import net.serenitybdd.core.pages.PageObject;
import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class GmailWebBasePage extends PageObject {
    public void esperaElemnento(WebElement element, int time){
        new WebDriverWait(Hooks.getDriver(), time).until(ExpectedConditions.visibilityOf(element));
        threadTest(2);
    }
    public boolean validarElemnentoPresente(WebElement element, int time){
        try {
            new WebDriverWait(Hooks.getDriver(), time).until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void threadTest(int time) {
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public WebElement returnElement(String xPath, String option){
        return element(By.xpath(xPath.replace("Replaceable",option)));
    }
    public List<WebElement> returnListElement(String xPath, String option) {
        return Hooks.getDriver().findElements(By.xpath(xPath.replace("Replaceable", option)));
    }
    public void scrollElement(WebElement element){
        ((JavascriptExecutor) Hooks.getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    public boolean isVisibleElement(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitUntilElementIsVisibleNonThrow(WebElement element, int WAIT_TIMEOUT) {
        try {
            await().atMost(WAIT_TIMEOUT, SECONDS).until(() -> isVisible(element));
            return true;
        } catch (ConditionTimeoutException e) {
            return false;
        }
    }
}

