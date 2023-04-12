package com.github.trks1970.common.domain.service.impl;

import com.github.trks1970.common.domain.model.TestIPersistentLong;
import com.github.trks1970.common.domain.repository.PersistentTypeRepository;
import com.github.trks1970.common.domain.repository.TestPersistentLongRepository;
import com.github.trks1970.common.domain.service.PersistentLongService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersistentLongServiceImpl implements PersistentLongService {
  private final TestPersistentLongRepository repository;

  @Override
  public PersistentTypeRepository<Long, TestIPersistentLong> repository() {
    return repository;
  }
}
