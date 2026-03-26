package com.beforesecurity.beforesecurity.dto;

import java.time.LocalDate;
import java.util.Set;

import com.beforesecurity.beforesecurity.validations.Longvalidations;
import com.beforesecurity.beforesecurity.validations.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserAccountDtoInsert {



@Longvalidations(min=10, max=50, message="Invalid Name")
private String userName;


    @Email
    @NotBlank
    @UniqueEmail
    private String email;


    @Longvalidations(min=5, max=25, message="Invalid Passcode")
    @NotBlank
    @Pattern(
  regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
  message = "La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula y un número"
)
    private String password;

    // opcional: ids de roles
    private Set<Long> roleIds;

 

  

    public UserAccountDtoInsert(String userName, String email, String password, Set<Long> roleIds) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roleIds = roleIds;
        
}

    public UserAccountDtoInsert() {}

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

    public Set<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }































}
