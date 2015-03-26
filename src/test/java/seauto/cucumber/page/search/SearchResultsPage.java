/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.page.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.partnet.automation.DependencyContainer;
import com.partnet.automation.page.Page;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
public class SearchResultsPage
  extends Page
{
  
  private static final Logger LOG = LoggerFactory.getLogger(SearchResultsPage.class);
  
  @FindBy(id = "b_results")
  private WebElement searchResultsContainer;
  
  
  @FindBy(css = "#b_results h2 a")
  private List<WebElement> listOfSearchResults;
  
  public SearchResultsPage(DependencyContainer depContainer)
  {
    super(depContainer);
  }
  
  public Map<String, String> getMajorSearchResults()
  {
    
    Map<String, String> searchResults = new HashMap<>();
    
    LOG.debug("Elements on page: {}", listOfSearchResults.size());
    for(WebElement elm : listOfSearchResults)
    {
      String title = elm.getText();
      String href = elm.getAttribute("href");
      LOG.debug("Title: {}, href: {}", title, href);
      searchResults.put(title, href);
    }
    
    return searchResults;
    
  }

  @Override
  public void verify()
    throws IllegalStateException
  {
    super.verifyByWebElement(searchResultsContainer);
  }
  
  @Override
  protected void ready()
  {
  }

}
