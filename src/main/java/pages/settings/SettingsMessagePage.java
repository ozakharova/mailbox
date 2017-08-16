package pages.settings;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SettingsMessagePage extends PageObject {

  @FindBy(css = "#afterDelete0")
  WebElementFacade nextMessageRadioButton;

  @FindBy(css = "#afterDelete1")
  WebElementFacade messageListRadioButton;


  @FindBy(css = ".form__actions button[type=submit]")
  WebElementFacade submitButton;

  public void selectGoToNextMessageAfterDelete() {
    nextMessageRadioButton.click();
  }

  public void selectGoToMessageListAfterDelete() {
    messageListRadioButton.click();
  }

  public void clickSubmitButton() {
    submitButton.click();
  }
}
