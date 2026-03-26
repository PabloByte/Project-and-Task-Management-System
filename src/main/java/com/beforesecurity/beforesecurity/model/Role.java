package com.beforesecurity.beforesecurity.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {


@GeneratedValue(strategy=GenerationType.IDENTITY)        
@Id        
private Long id;

@Column(nullable=false, unique= true)
private String roleName;

@ManyToMany(mappedBy = "roles" )
private Set<UserAccount> users = new HashSet<>();



public Role(String roleName, Set<UserAccount> users) {
        this.roleName = roleName;
        this.users = users;
}



public Role() {
}



public long getId() {
        return id;
}

public void setId(long id) {
        this.id = id;
}



public String getRoleName() {
        return roleName;
}



public void setRoleName(String roleName) {
        this.roleName = roleName;
}



public Set<UserAccount> getUsers() {
        return users;
}

public void setUsers(Set<UserAccount> users) {
        this.users = users;
}

   
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Role)) return false;

    Role other = (Role) obj;

    return id != null && id.equals(other.id);
}

   @Override
public int hashCode() {
    return getClass().hashCode();
}

    
































}
