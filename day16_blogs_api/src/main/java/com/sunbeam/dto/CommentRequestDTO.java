package com.sunbeam.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentRequestDTO extends BaseDTO {
	
	private String commentText;
	private int rating;
	private Long commenterId;
	private Long blogPostId;


}
