package com.project.lgnscrt.repo;

import com.project.lgnscrt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByNameAndPassword(String name, String password);
    Optional<User> findByName(String name);

}
