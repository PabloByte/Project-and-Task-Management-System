package com.beforesecurity.beforesecurity.dto;

public class CollaboratorDtoInsert {

  

 private String fullName;

  private String email;

  private String position;

  public CollaboratorDtoInsert() {
  }

  public CollaboratorDtoInsert(String fullName, String email, String position) {
    this.fullName = fullName;
    this.email = email;
    this.position = position;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "CollaboratorDtoInsert [fullName=" + fullName + ", email=" + email + ", position=" + position + "]";
  }

  


  














}
