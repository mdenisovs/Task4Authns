package org.example.data.repository;

import org.example.data.entities.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Authority, Long> {

    @Query(value = "SELECT a FROM Authority a WHERE a.authority=:authority")
    Authority findByAuthority(@Param("authority") String authority);
}