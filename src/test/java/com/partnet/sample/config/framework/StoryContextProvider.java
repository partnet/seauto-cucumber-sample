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

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.partnet.automation.annotation.StoryScoped;

/**
 * Manages the lifecycle of the {@link StoryContext} by setting and removing the context from the current thread.
 * 
 * @author <a href="mailto:rbascom@part.net">rbascom</a>
 */
public final class StoryContextProvider
{

  private static final Logger LOG = LoggerFactory.getLogger(StoryContextProvider.class);

  private static final ThreadLocal<StoryContext> THREAD_LOCAL_CONTEXT = new ThreadLocal<StoryContext>();

  private final StoryContext context;

  @Inject
  public StoryContextProvider(final StoryContext context)
  {
    this.context = context;
  }

  public void initialize()
  {
    StoryContextProvider.LOG.debug("Initializing scenario context on thread {}", Thread.currentThread());
    StoryContextProvider.THREAD_LOCAL_CONTEXT.set(this.context);
  }

  public void end()
  {
    StoryContextProvider.LOG.debug("Ending scenerio context on thread {}", Thread.currentThread());
    StoryContextProvider.THREAD_LOCAL_CONTEXT.remove();
  }

  @Produces
  @StoryScoped
  public StoryContext getContext()
  {
    return StoryContextProvider.THREAD_LOCAL_CONTEXT.get();
  }
}
