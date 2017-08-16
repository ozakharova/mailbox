package pages.messages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComposePage extends PageObject {

  @FindBy(css = "[data-name=send]")
  WebElementFacade sendMessageButton;

  @FindBy(css = "[data-original-name=To]")
  WebElementFacade toTextArea;

  @FindBy(css = "input[name=Subject]")
  WebElementFacade subjectInput;

  @FindBy(css = "#tinymce")
  WebElementFacade textInput;

  @FindBy(xpath = "//iframe[contains(@name,'composeEditor_ifr_name')]")
  WebElement textIframe;

  public void setEmail(String email) {
    toTextArea.type(email);
  }

  public void setSubject(String subject) {
    subjectInput.type(subject);
  }

  public void setText(String text) {
    getDriver().switchTo().frame(textIframe);
    textInput.type(text);
    getDriver().switchTo().parentFrame();
  }

  public void clickSendMessageButton() {
    sendMessageButton.click();
  }


}
