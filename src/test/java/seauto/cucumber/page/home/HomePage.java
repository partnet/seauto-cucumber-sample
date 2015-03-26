/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.page.home;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.partnet.automation.DependencyContainer;
import com.partnet.automation.page.Page;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
public class HomePage
  extends Page
{

  @FindBy(css = "[name='q']")
  private WebElement searchBarInput;

  @FindBy(id = "sb_form_go")
  private WebElement searchButton;
  
  public HomePage(DependencyContainer depContainer)
  {
    super(depContainer);
  }

  
  public HomePage setSearchPhrase(String searchPhrase)
  {
    super.setValue(searchBarInput, searchPhrase);
    return this;
  }

  /**
   * Clicks the search button on Bing's home page
   * @param searchPhrase
   */
  public void clickSearch()
  {
    super.clickAndWait(searchButton);
  }
  
  @Override
  public void verify()
    throws IllegalStateException
  {
    super.verifyByTitle("Bing");
  }

}
