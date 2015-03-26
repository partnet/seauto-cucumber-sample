/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

package seauto.cucumber.config.cucumber;

import com.partnet.config.AbstractDriverLifecycleListener;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
public class DriverLifecycleListener
  extends AbstractDriverLifecycleListener
{
  @Override
  @Before("@firefox")
  public void beforeFirefox()
  {
    super.beforeFirefox();
  }

  @Override
  @Before("@chrome")
  public void beforeChrome()
  {
    super.beforeChrome();
  }

  @Override
  @Before("@phantomjs")
  public void beforePhantomJs()
  {
    super.beforePhantomJs();
  }

  @Override
  @Before("@htmlunit")
  public void beforeHmtlUnit()
  {
    super.beforeHmtlUnit();
  }
  
  @Override
  @Before("@ie")
  public void beforeIe()
  {
    super.beforeIe();
  }
  
  @Override
  @Before
  public void setup(Scenario scenario)
  {
    super.setup(scenario);
  }

  @Override
  @After
  public void after(Scenario scenario)
  {
    super.after(scenario);
  }
}
