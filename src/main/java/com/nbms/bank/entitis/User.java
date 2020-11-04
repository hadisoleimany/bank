package com.nbms.bank.entitis;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
@Data
@AllArgsConstructor()
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String fname;
    @Length(min = 2,message = "Your name Should be More then Two Charecters")
    private String lname;
    @NonNull
    @Column(unique = true)
    private String userName;
    @NonNull
    @Length(min = 4,message = "Your password Should be More then Four Charecters")
    private String password;
    @Email(message = "Email Is Invalid")
    @Column(unique = true)
    private String email;


}
