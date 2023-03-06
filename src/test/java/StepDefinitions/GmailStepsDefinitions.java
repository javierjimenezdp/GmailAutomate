package StepDefinitions;

import Steps.GmailSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.IOException;

public class GmailStepsDefinitions {
    GmailSteps gmailSteps;
    public GmailStepsDefinitions() {
        this.gmailSteps = new GmailSteps();
    }
    @Given("^para crear una nueva cuenta en mercadolibre, necesite crear una cuenta de gmail$")
    public void loginGmailPage() throws IOException {
        gmailSteps.abrirNavegador();
        gmailSteps.googlePage();
    }
    @And("^me dirijo a la página principal de google y me dirijo al botón 'acceder'$")
    public void bottonLogin(){
        gmailSteps.bottonLogginGmail();
    }
    @And("^selecciono la opcion 'crear cuenta'$")
    public void bottonMakeAccount(){
        gmailSteps.bottonAccountNew();
    }
    @And("^selecciono una cuenta de uso personal$")
    public void selectOption(){
        gmailSteps.optionAccount();
    }
    @And("^registro mi (.*), (.*)$")
    public void inputName(String nombre, String apellido){
        gmailSteps.setName(nombre);
        gmailSteps.setLastName(apellido);
    }
    @And("^registro el nombre de mi (.*), (.*)$")
    public void inputUser(String usuario, String contraseña){
        gmailSteps.setUser(usuario);
        gmailSteps.setPassword(contraseña);
    }
    @And("^registro mi confirmacion de (.*)$")
    public void inputComfirmation(String confirmacion){
        gmailSteps.setConfirmation(confirmacion);
    }
    @And("^doy clic sobre el boton 'siguiente' y registro mi (.*)$")
    public void selectNext(String numero){
        gmailSteps.bottonNext1();
        gmailSteps.inputNumber(numero);
    }
    @And("^registro fecha de nacimiento (.*), (.*), (.*)$")
    public void inputDate(String dia, String mes, String año){
        gmailSteps.setDate(dia, mes, año);
    }
    @And("^selecciono mi (.*)$")
    public void inputGen(String genero){
        gmailSteps.setGen(genero);
    }
    @And("^doy clic sobre el boton 'siguiente1'$")
    public void selectNext2(){
        gmailSteps.bottonNext2();
    }
    @When("^de clic al boton 'aceptar' terminos y condiciones$")
    public void selectAccept(){
        gmailSteps.bottonAccept();
    }
    @Then("^carga el home de google$")
    public void homeGoogle(){
        gmailSteps.homeGoogleSearch();
    }
}
