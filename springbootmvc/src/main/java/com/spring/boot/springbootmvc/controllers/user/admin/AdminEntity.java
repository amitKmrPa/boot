package com.spring.boot.springbootmvc.controllers.user.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin_table")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "user_Id")
    private String userId;

    @Column(name = "user_Pass")
    private String userPass;
    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return " "+id+" "+userId+" "+userPass+" ";
    }
}
