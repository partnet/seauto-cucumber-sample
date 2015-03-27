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

package com.partnet.sample.page.search;

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
