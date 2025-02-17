package com.codesoom.assignment.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    User save(User user);

    Optional<User> findById(Long id);

    Iterable<User> findAllById(Iterable<Long> ids);

    void deleteById(Long id);

    void deleteAll();
}
