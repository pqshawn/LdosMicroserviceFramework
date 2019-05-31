package com.dodony.cloud.Dao;

import com.dodony.cloud.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
