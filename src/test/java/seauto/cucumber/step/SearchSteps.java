/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.step;


import java.util.Map;

import javax.inject.Inject;

import org.junit.Assert;

import seauto.cucumber.config.framework.StoryContext;
import seauto.cucumber.page.home.HomePage;
import seauto.cucumber.page.search.SearchResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */

public class SearchSteps
{
  
  @Inject
  private StoryContext context;
  
  @Given("^I am on Bing's home page$")
  public void givenIAmOnBingssHomePage()
  {
    context.site().open();
  }
  
  @When("^I search for (.*)$")
  public void whenIsearchForPhrase(String searchPhrase)
  {
    context.getPage(HomePage.class)
      .setSearchPhrase(searchPhrase)
      .clickSearch();
  }
  
  @Then("^I will see Partnet's home page in the list of results$")
  public void thenIWillSeePartnetInResults()
  {
    Map<String, String> majorSearchResults = context.getPage(SearchResultsPage.class).getMajorSearchResults();
    
    String partnet = "Partnet";
    
    Assert.assertTrue(String.format("Major search result links in did not contain '%s'!", partnet), 
        majorSearchResults.containsKey(partnet));
  }
}
