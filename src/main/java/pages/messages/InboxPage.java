package pages.messages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxPage extends PageObject {

  @FindBy(css = "[data-name=compose]")
  WebElementFacade composeMessageButton;

  @FindBy(css = "[data-name=remove]")
  WebElementFacade deleteMessageButton;

  @FindBy(css = "div[data-name=toggle]")
  WebElementFacade selectAllCheckbox;

  @FindBy(css = "#b-letters")
  WebElementFacade messagesList;

  public void clickComposeButton() {
    composeMessageButton.click();
  }

  public void clickSelectAllCheckbox() {
    selectAllCheckbox.click();
  }

  public void clickDeleteMessageButton() {
    deleteMessageButton.click();
  }

  public void clickMessageWithSubject(String subject) {
    find(By.xpath(".//*[@id='b-letters']//div[text()='" + subject + "']")).click();
  }

  public void waitForMessage(String subject) {
    waitFor(ExpectedConditions
        .elementToBeClickable(By.xpath("//*[@id='b-letters']//div[text()='" + subject + "']")));
  }

  public boolean isListOfMessagesPresent() {
    return messagesList.isPresent();
  }

}
