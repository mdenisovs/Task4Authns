package org.example.data.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="customers")
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phoneNumber;
}