/*
 * Copyright 2015 Partnet, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.partnet.sample.step;


import java.util.Map;

import javax.inject.Inject;

import org.junit.Assert;

import com.partnet.sample.config.framework.StoryContext;
import com.partnet.sample.page.home.HomePage;
import com.partnet.sample.page.search.SearchResultsPage;
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
