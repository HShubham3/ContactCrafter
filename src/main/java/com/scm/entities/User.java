package com.scm.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", unique = true)
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Column(length = 5000)
    private String about;
    @Column(length = 5000)
    private String profilePic;
    private String phoneNumber;

    // information
    private Boolean enable = false;
    private Boolean emailVerified = false;
    private Boolean phoneVerified = false;

    // SELF, GOOGLE, FACEBOOK, LINKEDIN
    private Provider providers = Provider.SELF;
    private String providerUserId;

    // add more fields

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contacts> contacts = new ArrayList<>();

}
