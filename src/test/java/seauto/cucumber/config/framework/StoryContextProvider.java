/* Copyright (c) 2014 Partnet, Inc. Confidential and Proprietary. */
package seauto.cucumber.config.framework;

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
