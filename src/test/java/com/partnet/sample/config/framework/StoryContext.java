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

package com.partnet.sample.config.framework;

import javax.inject.Inject;

import com.partnet.sample.page.BingSite;
import com.partnet.sample.page.BingSiteProvider;

import com.partnet.automation.AbstractStoryContext;
import com.partnet.automation.page.Page;
import com.partnet.automation.page.PageProvider;

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
