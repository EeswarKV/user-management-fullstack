package com.example.usermanagement.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Data
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    @NotBlank
    @NotNull
    @Email
    private String email;
    @NotBlank
    private String status;
    private long  phoneNumber;
    private LocalDate birthDate;
    String address;
    public User(){
        
    }
    public User(Long id,String fristName,String lastName,String email,String status,int phoneNumber,LocalDate birthDate,String address){
        this.id =id;
        this.firstName =fristName;
        this.lastName=lastName;
        this.email=email;
        this.status = status;
        this.phoneNumber=phoneNumber;
        this.birthDate=birthDate;
        this.address=address;

    }
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    
}
