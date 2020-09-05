package com.example.demo.Repository;

import com.example.demo.Domain.UserLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLogRepository extends JpaRepository<UserLog, Long> {
}
