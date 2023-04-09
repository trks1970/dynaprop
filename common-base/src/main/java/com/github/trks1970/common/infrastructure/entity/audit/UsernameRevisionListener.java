package com.github.trks1970.common.infrastructure.entity.audit;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsernameRevisionListener implements RevisionListener {
  private static final String SYSTEM_USER = "SYSTEM";

  @Override
  public void newRevision(Object entity) {
    if (entity instanceof UsernameRevisionEntity usernameRevisionEntity) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      usernameRevisionEntity.setUserName(
          authentication == null ? SYSTEM_USER : authentication.getName());
    }
  }
}
