package seauto.cucumber.config.selenium;
/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */



import javax.enterprise.inject.Alternative;

import org.openqa.selenium.WebDriver;

import com.partnet.automation.Browser;
import com.partnet.automation.selenium.AbstractConfigurableDriverProvider;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
@Alternative
public class ConfigurableWebDriverProvider
  extends AbstractConfigurableDriverProvider
{

  
  @Override
  protected WebDriver getWebDriver(Browser browser)
  {
    return super.getDefaultWebDriver(browser);
  }

}
