package com.ordertracker.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Table(name = "vendors")
@Getter @Setter
public class Vendor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    public Vendor() {}
}
