package com.lambdaschool.wanderlust.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tourist")
public class Tourist implements Serializable
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

    private Boolean istourguide=false;


    @ManyToMany
    @JoinTable(name = "bookedtours",
            joinColumns = {@JoinColumn(name = "touristid")},
            inverseJoinColumns = {@JoinColumn(name = "tourid")})
    @JsonIgnoreProperties("tourists")
    private List<Tour> bookedtours = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "favoritedtours",
            joinColumns = {@JoinColumn(name = "touristid")},
            inverseJoinColumns = {@JoinColumn(name = "tourid")})
    @JsonIgnoreProperties("tourists")
    private List<Tour> favoritedtours = new ArrayList<>();



    public Tourist()
    {
    }


    public List<Tour> getFavoritedtours()
    {
        return favoritedtours;
    }

    public void setFavoritedtours(List<Tour> favoritedtours)
    {
        this.favoritedtours = favoritedtours;
    }

    public List<Tour> getBookedtours()
    {
        return bookedtours;
    }

    public void setBookedtours(List<Tour> bookedtours)
    {
        this.bookedtours = bookedtours;
    }

    public Boolean getIstourguide()
    {
        return istourguide;
    }

    public void setIstourguide(Boolean istourguide)
    {
        this.istourguide = istourguide;
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

//    public List<Tour> getTours()
//    {
//        return tours;
//    }
//
//    public void setTours(List<Tour> tours)
//    {
//        this.tours = tours;
//    }



}
