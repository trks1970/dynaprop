package com.github.trks1970.dynaprop.domain.service;

import com.github.trks1970.dynaprop.domain.model.Named;
import com.github.trks1970.dynaprop.domain.repository.NamedTypeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.util.Optional;
@Validated
@Transactional
public abstract class NamedTypeService<T extends Named> extends PersistentTypeService<T> {
   protected abstract NamedTypeRepository<T> repository();

   public Optional<T> findByName(@Valid String name) {
      return repository().findByName(name);
   }
}
