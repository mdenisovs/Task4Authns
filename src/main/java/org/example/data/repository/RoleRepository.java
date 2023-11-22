package org.example.data.repository;

import org.example.data.entities.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Authority, Long> {

    @Query(value = "SELECT a FROM Authority a WHERE a.authority=:authority")
    Set<Authority> findByAuthority(@Param("authority") String authority);

    @Query(value = "SELECT a FROM Authority a WHERE a.username=:username")
    Set<Authority> findByUsername(@Param("username") String username);
}