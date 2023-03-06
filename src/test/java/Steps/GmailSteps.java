package Steps;

import PageObject.GmailPageObject;
import Reports.Reports;
import StepDefinitions.Hooks;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GmailSteps {
    GmailPageObject gmailPageObject;
    public GmailSteps() {
        this.gmailPageObject = new GmailPageObject();
        gmailPageObject.setDriver(Hooks.getDriver());
    }
public void abrirNavegador() throws IOException {
    Properties configuration = new Properties();
    configuration.load(new FileInputStream("Configuration.properties"));
    Hooks.getDriver().get(configuration.getProperty("url"));
}
    public void googlePage() {
        gmailPageObject.isVisibleGooglePage();
    }

    public void bottonLogginGmail() {
        gmailPageObject.bottonAcces();
    }

    public void bottonAccountNew() {
        gmailPageObject.bottonMakeNewAccount();
    }

    public void optionAccount() {
        gmailPageObject.optionTypeAccount();
        gmailPageObject.bottomMakeAccount();
        gmailPageObject.isVisibleCreateAccount();
    }

    public void setName(String nombre) {
        gmailPageObject.sendKeysimputName(nombre);
        Reports.reports("INFO","Se ingresó el nombre",Reports.takeSnapShot(Hooks.getDriver()));
    }

    public void setLastName(String apellido) {
        gmailPageObject.sendKeysInputLastName(apellido);
        Reports.reports("INFO","Se ingresó el apellido",Reports.takeSnapShot(Hooks.getDriver()));
    }

    public void setUser(String usuario) {
        gmailPageObject.sendKeysInputUser(usuario);
        Reports.reports("INFO","Se ingresó el usuario",Reports.takeSnapShot(Hooks.getDriver()));
    }
    public void setPassword(String contraseña) {
        gmailPageObject.sendKeysPassword(contraseña);
        Reports.reports("INFO","Se ingresó la contraseña",Reports.takeSnapShot(Hooks.getDriver()));

    }

    public void setConfirmation(String confirmacion) {
        gmailPageObject.sendKeysPaswordConfirmation(confirmacion);
        Reports.reports("INFO","Se ingresó la confirmación de contraseña",Reports.takeSnapShot(Hooks.getDriver()));
    }
    public void bottonNext1() {
        gmailPageObject.clicBottonNext1();
        validateDataUser();
    }
    public void inputNumber(String numero) {
        gmailPageObject.sendKeysCheckNumber(numero);
    }
    public void setDate(String dia, String mes, String año) {
        gmailPageObject.sendKeysDate(dia, mes, año);
        Reports.reports("INFO","Se ingresó el fecha de nacimiento",Reports.takeSnapShot(Hooks.getDriver()));
    }

    public void setGen(String genero) {
        gmailPageObject.sendKeysGen(genero);
        Reports.reports("INFO","Se ingresó el genero",Reports.takeSnapShot(Hooks.getDriver()));
    }

    public void bottonNext2() {
        gmailPageObject.clicBottonNext2();
    }

    public void bottonAccept() {
        gmailPageObject.clicBottonAccept();
    }

    public void homeGoogleSearch() {
        if (!gmailPageObject.isVisibleHomeGoogle()){
            Reports.reports("FAIL","Registro no Exitoso",Reports.takeSnapShot(Hooks.getDriver()));
            Assert.fail("Registro no Exitoso");
        }
        Reports.reports("PASS","Registro de usuario exitoso",Reports.takeSnapShot(Hooks.getDriver()));
    }

    public void validateDataUser(){
        if (gmailPageObject.isVisibleDataIncorrect()) {
            Reports.reports("FAIL","Registro no Exitoso; debes de : " + gmailPageObject.returnText(), Reports.takeSnapShot(Hooks.getDriver()));
            Assert.fail("Registro no Exitoso");
        }
    }

}

