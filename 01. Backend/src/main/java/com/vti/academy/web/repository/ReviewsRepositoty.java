package com.vti.academy.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.academy.web.model.Reviews;

public interface ReviewsRepositoty extends JpaRepository<Reviews, Long> {

}
