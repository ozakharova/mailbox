package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.mail.ru")
public class HomePage extends PageObject {

  @FindBy(id = "mailbox__login")
  WebElementFacade loginInput;

  @FindBy(id = "mailbox__password")
  WebElementFacade passwordInput;

  @FindBy(id = "mailbox__auth__button")
  WebElementFacade loginButton;

  public void setLogin(String login) {
    loginInput.clear();
    loginInput.type(login);
  }

  public void setDomain(String domain) {
    $("#mailbox__login__domain").selectByVisibleText(domain);
  }

  public void setPassword(String password) {
    passwordInput.clear();
    passwordInput.type(password);
  }

  public void clickLoginButton() {
    loginButton.click();
  }
}
