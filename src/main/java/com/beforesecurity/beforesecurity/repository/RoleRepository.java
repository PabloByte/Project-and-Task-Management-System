package com.beforesecurity.beforesecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beforesecurity.beforesecurity.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{





        Optional<Role> findByroleName (String name);








}
