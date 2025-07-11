package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @NotBlank(message="First name cannot be empty")
    private String name;
    
    @NotBlank(message="Contact number cannot be empty")
    @Pattern(regexp="^[0-9]+$", message="Only numbers are allowed")
    private String contactNumber;
    
    private String highestQualification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    @Override
    public String toString() {
        return "Mentor [id=" + id + ", name=" + name + ", contactNumber=" + contactNumber + ", highestQualification="
                + highestQualification + "]";
    }

    public Mentor(int id,
            @NotBlank(message = "First name cannot be empty") 
            @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters allowed") 
            String name,
            @NotBlank(message = "Contact number cannot be empty") 
            @Pattern(regexp = "^[0-9]+$", message = "Only numbers are allowed") 
            String contactNumber,
            String highestQualification) {
        super();
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
        this.highestQualification = highestQualification;
    }

    public Mentor() {
        super();
    }

}
