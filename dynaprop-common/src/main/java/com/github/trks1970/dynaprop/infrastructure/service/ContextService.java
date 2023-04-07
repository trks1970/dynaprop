package com.github.trks1970.dynaprop.infrastructure.service;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

//@Component
public class ContextService implements ApplicationContextAware {
  @Nullable
  private ApplicationContext context;

  public <T> T getBean(Class<T> beanClass) {
    if (context == null) {
      throw new IllegalStateException("No ApplicationContext");
    }
    return context.getBean(beanClass);
  }

  @Override
  public void setApplicationContext(@NonNull ApplicationContext context) throws BeansException {
    this.context = context;
  }
}