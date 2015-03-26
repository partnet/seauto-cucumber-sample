package seauto.cucumber.config.framework;
import javax.inject.Inject;

import seauto.cucumber.page.BingSite;
import seauto.cucumber.page.BingSiteProvider;

import com.partnet.automation.AbstractStoryContext;
import com.partnet.automation.page.Page;
import com.partnet.automation.page.PageProvider;

/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */

/**
 * @author <a href="mailto:bbarker@part.net">bbarker</a>
 */
public class StoryContext
  extends AbstractStoryContext
{
  PageProvider pageProvider;
  BingSiteProvider siteProvider;
  
  @Inject
  StoryContext(final PageProvider pageProvider, final BingSiteProvider siteProvider)
  {
    this.pageProvider = pageProvider;
    this.siteProvider = siteProvider;
  }
  
  public BingSite site()
  {
    return siteProvider.createSite();
  }
  
  
  /**
   * Get a reference to a specified {@link Page} instance.
   * Shortcut/alternative to using the {@link #pages()} method just to invoke {@link PageProvider#get(Class)}.
   * 
   * @param clazz  type of {@link Page} 
   * @return  a {@link Page} instance of the requested type
   */
  public <T extends Page> T getPage(Class<T> clazz)
  {
    return this.pageProvider.get(clazz);
  }
}
