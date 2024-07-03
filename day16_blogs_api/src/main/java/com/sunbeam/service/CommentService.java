package com.sunbeam.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentRequestDTO;

public interface CommentService {
	
	public ApiResponse addComment(CommentRequestDTO comm);
	
	public ApiResponse deleteCommentsByCommenterId(Long commenterId);

}
