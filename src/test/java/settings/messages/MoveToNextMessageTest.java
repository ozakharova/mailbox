package settings.messages;

import static utils.UserAccountPropertiesUtils.getUserDomain;
import static utils.UserAccountPropertiesUtils.getUserLogin;
import static utils.UserAccountPropertiesUtils.getUserPassword;

import java.util.ArrayList;
import model.Message;
import model.UserCredentials;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;

@RunWith(SerenityRunner.class)
public class MoveToNextMessageTest {

  UserCredentials userCredentials = new UserCredentials(getUserLogin(), getUserDomain(),
      getUserPassword());
  private static final String FIRST_MESSAGE_SUBJECT = "first_subject";
  private static final String SECOND_MESSAGE_SUBJECT = "second_subject";
  private static final String MESSAGE_TEXT = "text";
  ArrayList<Message> listMessages;

  @Managed
  WebDriver driver;

  @Steps
  UserSteps user;

  @Before
  public void beforeClass() {
    user.openHomePage();
    user.loginWith(userCredentials);

    user.navigateToSettingsMessages();
    user.setGoToNextMessageAfterDeleteSetting();
    user.navigateFromSettingsToInbox();
    user.cleanInboxFolder();
  }

  @Test
  public void verifyDeletingOfTheTopMessage() {
    listMessages = new ArrayList<>();
    listMessages
        .add(new Message(FIRST_MESSAGE_SUBJECT, getUserLogin() + getUserDomain(), MESSAGE_TEXT));
    listMessages
        .add(new Message(SECOND_MESSAGE_SUBJECT, getUserLogin() + getUserDomain(), MESSAGE_TEXT));
    user.createListInboxMessage(listMessages);

    user.deleteMessageWithSubject(SECOND_MESSAGE_SUBJECT);

    user.shouldSeeMessageSubjectContaining(FIRST_MESSAGE_SUBJECT);
  }

  @Test
  public void verifyDeletingOfTheBottomMessage() {
    listMessages = new ArrayList<>();
    listMessages
        .add(new Message(FIRST_MESSAGE_SUBJECT, getUserLogin() + getUserDomain(), MESSAGE_TEXT));
    listMessages
        .add(new Message(SECOND_MESSAGE_SUBJECT, getUserLogin() + getUserDomain(), MESSAGE_TEXT));
    user.createListInboxMessage(listMessages);

    user.deleteMessageWithSubject(FIRST_MESSAGE_SUBJECT);

    user.shouldSeeListOfMessages();
  }

  @Test
  public void verifyDeletingSingleMessage() {
    user.createInboxMessage(
        new Message(FIRST_MESSAGE_SUBJECT, getUserLogin() + getUserDomain(), MESSAGE_TEXT));

    user.deleteMessageWithSubject(FIRST_MESSAGE_SUBJECT);

    user.shouldSeeEmptyFolder();
  }
}
