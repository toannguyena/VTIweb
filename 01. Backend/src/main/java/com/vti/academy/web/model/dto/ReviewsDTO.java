package com.vti.academy.web.model.dto;

public class ReviewsDTO {
	private String image;
	private String content;
	private String reviewerName;
	private String office;
	private int type;

	public ReviewsDTO(String image, String content, String reviewerName, String office, int type) {
		this.image = image;
		this.content = content;
		this.reviewerName = reviewerName;
		this.office = office;
		this.type = type;
	}
}
