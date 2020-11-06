package com.nbms.bank.entitis;

import com.nbms.bank.enums.RoleType;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

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
    @Length(min = 2,message = "Your First name Should be More then Two Characters")
    private String fname;
    @Length(min = 2,message = "Your Last name Should be More then Two Characters")
    private String lname;
    @NonNull
    @Column(unique = true)
    private String userName;
    @NonNull
    @Length(min = 4,message = "Your password Should be More then Four Characters")
    private String password;
    @Email(message = "Email Is Invalid")
    @Column(unique = true)
    private String email;

    private boolean isActive;

    @OneToMany(mappedBy = "user")
    private Set<Role> roleTypes;


}
