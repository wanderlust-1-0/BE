package com.lambdaschool.wanderlust.model;


import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tourid;

    @Column(nullable = false,
            unique = true)
    private String tourname;

    @Column(nullable = false,
            unique = true)
    private String tourdescription;

    @Column(nullable = false,
            unique = true)
    private long recommendedage;

    @Column(nullable = false,
            unique = true)
    private String whattobring;

    @Column(nullable = false,
            unique = true)
    private String category;

    @Column(nullable = false,
            unique = true)
    private String area;

    @Column(nullable = false,
            unique = true)
    private long price;

    @Column(nullable = false,
            unique = true)
    private long durationhrs;

    @Column(nullable = false,
            unique = true)
    private String meetingaddress;

    @Column(nullable = false,
            unique = true)
    private long likes;



}
