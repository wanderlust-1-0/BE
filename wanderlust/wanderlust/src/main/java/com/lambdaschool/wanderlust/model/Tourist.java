package com.lambdaschool.wanderlust.model;


import javax.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long touristid;

    @Column(nullable = false,
            unique = true)
    private String firstname;

    @Column(nullable = false,
            unique = true)
    private String lastname;

    @Column(nullable = false,
            unique = true)
    private String phonenumber;

    @Column(nullable = false,
            unique = true)
    private String email;


}
