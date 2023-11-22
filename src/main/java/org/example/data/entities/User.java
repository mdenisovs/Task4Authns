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
    @Column(name="username")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private Boolean enabled;
}