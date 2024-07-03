package com.sunbeam.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDTO {
	
	private String commentText;
	private int rating;
	private Long commenterId;
	private Long blogPostId;

}
