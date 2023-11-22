package org.example.data.repository;

import org.example.data.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE u.name=:name")
    User findByName(@Param("name") String name);
}