package com.nbms.bank.entitis;

import com.nbms.bank.enums.RoleType;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private RoleType roleTypes;
    @ManyToOne
    private User user;
}
