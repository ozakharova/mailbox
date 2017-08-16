package pages.messages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LetterPage extends PageObject {

  @FindBy(css = ".b-letter__head__subj__text")
  WebElementFacade messageSubject;

  @FindBy(xpath = ".//*[@id='b-toolbar__right']//div[contains(@class, 'rdm-mid b-toolbar')]//span[text()='Удалить']")
  WebElementFacade deleteButton;

  @FindBy(css = ".b-datalist__empty__text")
  WebElementFacade emptyInboxFolder;

  public String getMessageSubject() {
    return messageSubject.getText();
  }

  public void clickDeleteMessageButton() {
    deleteButton.click();
  }

  public void waitForMessageSubject() {
    waitFor(ExpectedConditions.visibilityOf(messageSubject));
  }

  public boolean isEmptyFolderPresent() {
    return emptyInboxFolder.isPresent();
  }
}
