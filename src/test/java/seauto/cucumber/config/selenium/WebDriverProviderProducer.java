// Copyright (C) 2014 Partnet, Inc. Confidential and Proprietary
package seauto.cucumber.config.selenium;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.partnet.automation.selenium.DriverProvider;



/**
 * Responsible for providing a {@link WebDriverProvider}. 
 *
 * @author <a href="mailto:rbascom@part.net">Ryan Bascom</a>
 */
public final class WebDriverProviderProducer
{
  private final static Logger LOG = LoggerFactory.getLogger(WebDriverProviderProducer.class);

  @Produces
  @Singleton
  public DriverProvider getWebDriverProvider()
  {
    LOG.info("WebDriverProviderProducer getWebDriverProvider");
    return new ConfigurableWebDriverProvider();
  }
  
}
