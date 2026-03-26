package com.beforesecurity.beforesecurity.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.beforesecurity.beforesecurity.validations.Longvalidations;
import com.beforesecurity.beforesecurity.validations.Longvalidations;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserAccount {

 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;


@Column(nullable= false, unique= true)
private String userName;


@Column(nullable= false, unique= true)
private String email;

@Column(nullable= false)
private String password;



@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
private  LocalDate registeredAt;




@Column(nullable=false)
private boolean enabled = true;

 @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles", // tabla intermedia
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = {@UniqueConstraint(columnNames={"user_id", "role_id"})}
    )
private Set<Role> roles;

 public UserAccount(Long id, String userName, String email, String password, LocalDate registeredAt,Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registeredAt = registeredAt;
        this.roles = roles;
 }

 public UserAccount() {
        roles= new  HashSet<>();
 }

 public Long getId() {
        return id;
 }

 public void setId(Long id) {
        this.id = id;
 }

 public String getUserName() {
        return userName;
 }

 public void setUserName(String userName) {
        this.userName = userName;
 }

 public String getEmail() {
        return email;
 }

 public void setEmail(String email) {
        this.email = email;
 }

 public String getPassword() {
        return password;
 }

 public void setPassword(String password) {
        this.password = password;
 }



 public LocalDate getRegisteredAt() {
        return registeredAt;
 }

 public void setRegisteredAt(LocalDate registeredAt) {
        this.registeredAt = registeredAt;
 }



 public boolean isEnabled() {
        return enabled;
 }

 public void setEnabled(boolean enabled) {
        this.enabled = enabled;
 }

 public Set<Role> getRoles() {
        return roles;
 }

 public void setRoles(Set<Role> roles) {
        this.roles = roles;
 }

   @Override
public int hashCode() {
    return getClass().hashCode();
}

    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof UserAccount)) return false;

    UserAccount other = (UserAccount) obj;

    return id != null && id.equals(other.id);
}

  

 

 

 
























}
