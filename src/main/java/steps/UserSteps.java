package steps;

import static model.ToolbarItems.INBOX;
import static model.ToolbarItems.MORE_SETTINGS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import model.Message;
import model.UserCredentials;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.HomePage;
import pages.menu.SettingsMenu;
import pages.menu.ToolBarMenu;
import pages.messages.ComposePage;
import pages.messages.InboxPage;
import pages.messages.LetterPage;
import pages.settings.SettingsMessagePage;

public class UserSteps extends ScenarioSteps {

  HomePage homePage;
  ToolBarMenu toolBarMenu;
  SettingsMenu settingsMenu;
  SettingsMessagePage settingsMessagePage;
  InboxPage inboxPage;
  ComposePage composePage;
  LetterPage letterPage;

  @Step
  public void openHomePage() {
    homePage.open();
  }

  @Step
  public void loginWith(UserCredentials userCredentials) {
    homePage.setLogin(userCredentials.getLogin());
    homePage.setDomain(userCredentials.getDomain());
    homePage.setPassword(userCredentials.getPassword());
    homePage.clickLoginButton();
  }

  @Step
  public void navigateToSettingsMessages() {
    toolBarMenu.selectItem(MORE_SETTINGS.text());
    settingsMenu.clickMessagesLink();
  }

  @Step
  public void setGoToNextMessageAfterDeleteSetting() {
    settingsMessagePage.selectGoToNextMessageAfterDelete();
    settingsMessagePage.clickSubmitButton();
  }

  @Step
  public void setGoToMessageListAfterDeleteSetting() {
    settingsMessagePage.selectGoToMessageListAfterDelete();
    settingsMessagePage.clickSubmitButton();
  }

  @Step
  public void navigateFromSettingsToInbox() {
    settingsMenu.clickInboxLink();
  }

  @Step
  public void createInboxMessage(Message message) {
    inboxPage.clickComposeButton();
    composePage.setEmail(message.getEmail());
    composePage.setSubject(message.getSubject());
    composePage.setText(message.getText());
    composePage.clickSendMessageButton();

    toolBarMenu.selectToolBarItem(INBOX.text());
    inboxPage.waitForMessage(message.getSubject());
  }

  @Step
  public void createListInboxMessage(ArrayList<Message> message) {
    for (int i = 0; i < message.size(); i++) {
      createInboxMessage(message.get(i));
    }
  }

  @Step
  public void cleanInboxFolder() {
    toolBarMenu.selectToolBarItem(INBOX.text());
    inboxPage.clickSelectAllCheckbox();
    inboxPage.clickDeleteMessageButton();
  }

  @Step
  public void deleteMessageWithSubject(String subject) {
    openMessageWithSubject(subject);
    letterPage.clickDeleteMessageButton();
  }

  @Step
  public void openMessageWithSubject(String subject) {
    inboxPage.clickMessageWithSubject(subject);
    letterPage.waitForMessageSubject();
  }

  @Step
  public void shouldSeeMessageSubjectContaining(String subject) {
    assertThat(letterPage.getMessageSubject()).contains(subject);
  }

  @Step
  public void shouldSeeListOfMessages() {
    assertThat(inboxPage.isListOfMessagesPresent());
  }

  @Step
  public void shouldSeeEmptyFolder() {
    assertThat(letterPage.isEmptyFolderPresent());
  }
}
