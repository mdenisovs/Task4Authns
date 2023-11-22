package org.example.data.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="authorities")
@Getter
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="authority_id")
    private long id;
    @Column(name="username")
    private String username;
    @Column(name="authority")
    private String authority;
}