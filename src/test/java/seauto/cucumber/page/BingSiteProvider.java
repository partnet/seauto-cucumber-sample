/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.page;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.partnet.automation.RuntimeConfiguration;
import com.partnet.automation.page.SiteProvider;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
@Singleton
public class BingSiteProvider 
  extends SiteProvider<BingSite>
{
  
  @Inject
  private RuntimeConfiguration runConfig;
  
  @Override
  protected BingSite newSiteInstance()
  {
    return new BingSite(driverProvider, runConfig);
  }

}
