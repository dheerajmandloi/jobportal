package com.example.jobportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobportal.Model.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}