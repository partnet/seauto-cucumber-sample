/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.page;


import org.openqa.selenium.By;

import com.partnet.automation.RuntimeConfiguration;
import com.partnet.automation.page.Site;
import com.partnet.automation.selenium.DriverProvider;

/**
 * This object represents the global site of Google.
 * It has functionality that the majority of google represents.
 */
public class BingSite
  extends Site
{
  
  private RuntimeConfiguration runConfig;
  
  public BingSite(DriverProvider driverProvider, RuntimeConfiguration runConfig)
  {
    super(driverProvider.get());
    this.runConfig = runConfig;
  }

  @Override
  protected String getDefaultUrl()
  {
    return runConfig.getUrl();
  }

  @Override
  protected By getPrimaryWindowSelector()
  {
    /*
     *  In the case of a link on the original window that spawns another window, 
     *  This is a global selector used to identify the original primary window
     *  For our case of searching Bing, it is not necessary. 
     */
    return null;
  }

}
