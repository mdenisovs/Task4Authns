package org.example.data.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private Boolean enabled;
    private int failedLoginAttempts;
}