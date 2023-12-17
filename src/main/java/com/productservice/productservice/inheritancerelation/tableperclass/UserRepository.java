package com.productservice.productservice.inheritancerelation.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    User save(User entity);
}
