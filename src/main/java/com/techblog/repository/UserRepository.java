package com.techblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techblog.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
