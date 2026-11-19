package com.hanan.restful_crud_api.repository;

import com.hanan.restful_crud_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}