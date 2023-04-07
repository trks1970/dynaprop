package com.github.trks1970.dynaprop.infrastructure.entity.audit;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class RevisionListener implements org.hibernate.envers.RevisionListener {
  private static final String SYSTEM_USER = "SYSTEM";

  @Override
  public void newRevision(Object entity) {
    if (entity instanceof RevisionEntity revisionEntity) {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      revisionEntity.setUserName(
        authentication == null
          ? SYSTEM_USER
          : authentication.getName()
      );
    }
  }

}
