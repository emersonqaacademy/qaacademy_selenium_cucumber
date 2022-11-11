package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CadastroPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    LoginPage loginPage;
    CadastroPage cadastroPage;

    @Before
    public void before(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        cadastroPage = new CadastroPage(driver);
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Dado("que eu esteja na pagina inicial:{string}")
    public void queEstejaNaPaginaInicial(String url){
        driver.get(url);
    }

    @E("possua um cadastro")
    public void possuoCadastro(){
        cadastroPage.clicarBotaoRegistrar();
        cadastroPage.preencherEmail("teste@teste.com");
        cadastroPage.preencherNome("Emerson");
        cadastroPage.preencherSenha("123456");
        cadastroPage.preencherConfirmacaoSenha("123456");
        cadastroPage.selecionaSaldo();
        cadastroPage.clicaBotaoCadastrar();
        cadastroPage.clicaBotaoFecharContaCriada();
    }

    @Quando("eu preencher email:{string} e senha:{string}")
    public void preencherEmailESenha(String email, String senha){
        loginPage.preencheLoginEmail(email);
        loginPage.preencheSenha(senha);
    }

    @E("clicar em fazer login")
    public void clicarLogin(){
        loginPage.clicarBotaoAcessar();
    }

    @Entao("valido que a pagina de boas vindas foi carregada")
    public void validarPaginaBoasVindas(){
        String url = "http://0.0.0.0:3000/home";
        new WebDriverWait(driver, 5000).until(ExpectedConditions.urlToBe(url));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }



}
