package pages.menu;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ToolBarMenu extends PageObject {

  @FindBy(css = ".pm-toolbar__button_more")
  WebElementFacade more;

  @FindBy(css = ".pm-toolbar")
  WebElementFacade toolbar;

  public void selectItem(String toolbarItem) {
    more.click();
    more.findBy(By.linkText(toolbarItem)).click();
  }

  public void selectToolBarItem(String toolbarItem) {
    toolbar.findBy(By.linkText(toolbarItem)).click();
  }

}
