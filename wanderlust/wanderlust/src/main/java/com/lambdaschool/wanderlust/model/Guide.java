package com.lambdaschool.wanderlust.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guide")
public class Guide
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long guideid;

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

//    @Column(nullable = false,
//            unique = true)
    private Boolean istourguide=true;


    @OneToMany(mappedBy = "guide",
                    cascade = CascadeType.ALL,
                    orphanRemoval = true)
    @JsonIgnoreProperties("guides")
    private List<Tour> tours= new ArrayList<>();

    public Guide()
    {
    }

    public Guide(String firstname, String lastname, String phonenumber, String email)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Guide(String firstname)
    {
        this.firstname = firstname;
    }

    public long getGuideid()
    {
        return guideid;
    }

    public void setGuideid(long guideid)
    {
        this.guideid = guideid;
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

    public Boolean getIstourguide()
    {
        return istourguide;
    }

    public void setIstourguide(Boolean istourguide)
    {
        this.istourguide = istourguide;
    }
}
