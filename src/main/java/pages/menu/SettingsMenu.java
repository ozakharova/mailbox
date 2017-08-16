package pages.menu;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SettingsMenu extends PageObject {

  @FindBy(css = "[data-name=messages]")
  WebElementFacade messagesLink;

  @FindBy(css = "[data-name=inbox]")
  WebElementFacade inboxLink;

  public void clickMessagesLink() {
    messagesLink.click();
  }

  public void clickInboxLink() {
    inboxLink.click();
  }
}
