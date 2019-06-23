package com.lambdaschool.wanderlust.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tourist")
public class Tourist
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long touristid;

//    @Column(nullable = false,
//            unique = true)
    private String firstname;

//    @Column(nullable = false,
//            unique = true)
    private String lastname;

//    @Column(nullable = false,
//            unique = true)
    private String phonenumber;

//    @Column(nullable = false,
//            unique = true)
    private String email;

    @ManyToMany
    @JoinTable(name = "touristtours",
            joinColumns = {@JoinColumn(name = "touristid")},
            inverseJoinColumns = {@JoinColumn(name = "tourid")})
    @JsonIgnoreProperties("tourists")
    private List<Tour> tours = new ArrayList<>();

    public Tourist()
    {
    }

    public Tourist(String firstname)
    {
        this.firstname = firstname;
    }


    public long getTouristid()
    {
        return touristid;
    }

    public void setTouristid(long touristid)
    {
        this.touristid = touristid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<Tour> getTours()
    {
        return tours;
    }

    public void setTours(List<Tour> tours)
    {
        this.tours = tours;
    }
}
