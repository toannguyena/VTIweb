package com.vti.academy.web.service.impl;

import java.util.List;

import com.vti.academy.web.model.Reviews;
import com.vti.academy.web.repository.ReviewsRepositoty;
import com.vti.academy.web.service.ReviewsService;

public class ReviewsServiceImpl implements ReviewsService {

	private ReviewsRepositoty repository;

	@Override
	public List<Reviews> viewList() {

		return repository.findAll();
	}

	@Override
	public Reviews getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reviews createReviews(Reviews entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reviews editReviews(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reviews deleteReviews(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
