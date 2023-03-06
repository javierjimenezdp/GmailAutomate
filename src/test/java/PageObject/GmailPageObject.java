package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPageObject extends GmailWebBasePage{
    String selectMonth="//div[@class=\"CuHakb\"]//select[@id=\"month\"]//option[contains(text(),'Replaceable')]";
    String selectGender="//div[@class=\"CuHakb\"]//select[@id=\"gender\"]//option[contains(text(),'Replaceable')]";
@FindBy(xpath = "//div//div[@class=\"k1zIA rSk4se\"]")
private WebElement isVisibleHomeGoogle;
@FindBy(xpath = "//div//a[@class=\"gb_ia gb_ja gb_fe gb_fd\"]")
private WebElement isVisibleBottonAcces;
@FindBy(xpath = "(//div[@class=\"VfPpkd-RLmnJb\"])[3]")
private WebElement isVisibleBottomMakeAccount;
@FindBy(xpath = "//span[contains(text(),\"Crear cuenta\")]")
private WebElement cliclBottonType;
@FindBy(xpath = "//li//span[contains(text(),\"Para uso personal\")]")
private WebElement clicBottomOptionTypeAccount;
@FindBy(xpath = "//h1//span[contains(text(),\"Crear tu cuenta de Google\")]")
private WebElement isViisileAccountMake;
@FindBy(xpath = "//div//input[@name=\"firstName\"]")
private WebElement inputName;
@FindBy(xpath = "//div//input[@name=\"lastName\"]")
private WebElement inputLastName;
@FindBy(xpath = "//div//input[@name=\"Username\"]")
private WebElement inputUserName;
@FindBy(xpath = "//div//input[@name=\"Passwd\"]")
private WebElement inputPassword;
@FindBy(xpath = "//div//input[@name=\"ConfirmPasswd\"]")
private WebElement inputPasswordConfirm;
@FindBy(xpath = "//div//*[@id=\"selectioni1\"]")
private WebElement clicSeePassword;
@FindBy(xpath = "//div//span[contains(text(),\"Siguiente\")]")
private WebElement clicBottonNext1;
@FindBy(xpath = "//span//input[@id=\"phoneNumberId\"]")
private WebElement inputNumberCheck;
@FindBy(xpath = "//button//span[contains(text(),\"Verificar\")]")
private WebElement clicButtonVerify;
@FindBy(xpath = "//div//input[@name=\"day\"]")
private WebElement inputDay;
@FindBy(xpath = "//*[@id=\"month\"]")
private WebElement inputMonth;
@FindBy(xpath = "//div//input[@name=\"year\"]")
private WebElement inputYear;
@FindBy(xpath = "//*[@id=\"gender\"]")
private WebElement inputGender;
@FindBy(xpath = "//div//span[contains(text(),\"Sí, acepto\")]")
private WebElement clicBottonAccept;
@FindBy(xpath = "//div//span[contains(text(),\"Acepto\")]")
private WebElement clicBottonConditions;
@FindBy(xpath = "//div[@class=\"gb_Ff gb_4a gb_rg gb_r\"]")
private WebElement isVisibleIconAccount;
@FindBy(xpath = "//div//span[contains(text(),\"Ingresa\") or contains (text(),\"Elige\")]")
private WebElement returnWrong;

    public boolean isVisibleGooglePage() {
        esperaElemnento(isVisibleHomeGoogle, 10);
        return isVisibleHomeGoogle.isDisplayed();
    }

    public boolean bottonAcces() {
        esperaElemnento(isVisibleBottonAcces, 10);
        return isVisibleBottonAcces.isDisplayed();
    }

    public void bottonMakeNewAccount() {
        isVisibleBottonAcces.click();
    }

    public boolean optionTypeAccount() {
        esperaElemnento(isVisibleBottomMakeAccount, 10);
        return isVisibleBottomMakeAccount.isDisplayed();
    }
    public void bottomMakeAccount() {
        cliclBottonType.click();
        clicBottomOptionTypeAccount.click();
    }
    public boolean isVisibleCreateAccount() {
        esperaElemnento(isViisileAccountMake, 10);
        return isViisileAccountMake.isDisplayed();
    }
    public void sendKeysimputName(String nombre) {
        inputName.click();
        inputName.sendKeys(nombre);
    }

    public void sendKeysInputLastName(String apellido) {
        inputLastName.click();
        inputLastName.sendKeys(apellido);
    }

    public void sendKeysInputUser(String usuario) {
        inputUserName.click();
        inputUserName.sendKeys(usuario);
    }
    public void sendKeysPassword(String contraseña) {
        inputPassword.click();
        inputPassword.sendKeys(contraseña);
    }

    public void sendKeysPaswordConfirmation(String confirmacion) {
        inputPasswordConfirm.click();
        inputPasswordConfirm.sendKeys(confirmacion);
    }

    public void clicBottonNext1() {
        clicSeePassword.click();
        threadTest(3);
        clicBottonNext1.click();
    }
    public void sendKeysCheckNumber(String numero) {
        esperaElemnento(inputNumberCheck, 10);
        inputNumberCheck.click();
        inputNumberCheck.sendKeys(numero);
        clicBottonNext1.click();
        threadTest(15);
        clicButtonVerify.click();
    }
    public void sendKeysDate(String dia, String mes, String año) {
        esperaElemnento(inputDay, 10);
        inputDay.click();
        inputDay.sendKeys(dia);
        esperaElemnento(inputMonth, 10);
        inputMonth.click();
        WebElement element = returnElement(selectMonth, mes);
        element.click();
        esperaElemnento(inputYear, 10);
        inputYear.click();
        inputYear.sendKeys(año);
    }

    public void sendKeysGen(String genero) {
        esperaElemnento(inputGender, 10);
        inputGender.click();
        WebElement element = returnElement(selectGender, genero);
        element.click();
        clicBottonNext1.click();
    }

    public void clicBottonNext2() {
        esperaElemnento(clicBottonAccept, 10);
        clicBottonAccept.click();
    }

    public void clicBottonAccept() {
        scrollElement(clicBottonConditions);
        esperaElemnento(clicBottonConditions, 10);
        clicBottonConditions.click();
    }

    public boolean isVisibleHomeGoogle() {
        esperaElemnento(isVisibleIconAccount, 10);
        return isVisibleIconAccount.isDisplayed();
    }
    public boolean isVisibleDataIncorrect(){
        return waitUntilElementIsVisibleNonThrow(returnWrong, 1);
    }
    public String returnText(){
        return returnWrong.getText();
    }
}
