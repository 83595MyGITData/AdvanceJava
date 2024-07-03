package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	public CommentController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside "+getClass());
	}
	
	@DeleteMapping("/{commenterId}")
	
	public ResponseEntity<?> deleteComments(@PathVariable Long commenterId )
	{
		try {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(commentService.deleteCommentsByCommenterId(commenterId));
		}
		catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		//return null;
		
	}

}
