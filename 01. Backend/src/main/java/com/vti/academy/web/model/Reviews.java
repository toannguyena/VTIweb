package com.vti.academy.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "Reviews")
@Data
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "image")
	private String image;
	@Column(name = "content")
	private String content;
	@Column(name = "reviewerName")
	private String reviewerName;
	@Column(name = "office")
	private String office;
	@Column(name = "type")
	private int type;
}
