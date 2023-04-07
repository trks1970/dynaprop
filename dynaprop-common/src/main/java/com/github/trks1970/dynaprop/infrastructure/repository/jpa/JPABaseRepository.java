package com.github.trks1970.dynaprop.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

@NoRepositoryBean
public interface JPABaseRepository<T, ID, R extends Number & Comparable<R>> extends
                                                                            JpaRepository<T, ID>,
                                                                            JpaSpecificationExecutor<T>,
                                                                            RevisionRepository<T, ID, R> {
}
