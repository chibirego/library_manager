package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Library;
import com.example.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
