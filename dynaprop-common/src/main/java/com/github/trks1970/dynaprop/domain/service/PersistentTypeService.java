package com.github.trks1970.dynaprop.domain.service;

import com.github.trks1970.dynaprop.domain.exception.NotFoundException;
import com.github.trks1970.dynaprop.domain.model.Persistent;
import com.github.trks1970.dynaprop.domain.repository.PersistentTypeRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import java.util.Set;

@Validated
@Transactional
public abstract class PersistentTypeService<T extends Persistent> {
   protected abstract PersistentTypeRepository<T> repository();

   public T save(@Valid T persistentType){
      return repository().save(persistentType);
   }

   public T findById(Long id) throws NotFoundException {
      return repository().findById(id);
   }

   public Set<T> findAllById(Set<Long> ids) throws NotFoundException {
      return repository().findAllById(ids);
   }

   public void deleteById(Long id) throws NotFoundException {
      repository().deleteById(id);
   }

}
