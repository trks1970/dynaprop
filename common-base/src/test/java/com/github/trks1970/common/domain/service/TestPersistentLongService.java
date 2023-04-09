package com.github.trks1970.common.domain.service;

import com.github.trks1970.common.domain.model.TestPersistentLong;
import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.domain.repository.TestPersistentLongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TestPersistentLongService extends PersistentTypeService<Long, TestPersistentLong> {
  private final TestPersistentLongRepository repository;

  @Override
  protected PersistentTypeRepository<Long, TestPersistentLong> repository() {
    return repository;
  }
}
