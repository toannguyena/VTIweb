package com.vti.academy.web.service;

import java.util.List;

import com.vti.academy.web.model.Reviews;

public interface ReviewsService {

	public List<Reviews> viewList();

	public Reviews getById(Long id);
	
	public Reviews createReviews(Reviews entity);
	
	public Reviews editReviews(Long id);
	
	public Reviews deleteReviews(Long id);

}
