package com.sunbeam.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.dao.BlogPostDao;
import com.sunbeam.dao.CommentDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.CommentRequestDTO;
import com.sunbeam.entities.BlogPost;
import com.sunbeam.entities.Comment;
import com.sunbeam.entities.Role;
import com.sunbeam.entities.User;

@Service
@Transactional
public class CommentServiceImp implements CommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BlogPostDao blogPostDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public ApiResponse addComment(CommentRequestDTO commDto) {
		// TODO Auto-generated method stub
		BlogPost post= blogPostDao.findById(commDto.getBlogPostId())
				.orElseThrow(()-> new RuntimeException("BlogPost Not Found!!"));
		User blogger= userDao.findById(commDto.getCommenterId()).
				orElseThrow(()->new RuntimeException("Blogger Not found!!"));
		
		Comment persistentComment = new Comment();
//		if((blogger.getRole()==Role.BLOGGER)&& blogger.getId()!=post.getBlogger().getId())//validation author should not post comment on self post
//		{
			Comment comment= mapper.map(commDto, Comment.class);
			comment.setCommenter(blogger);
			comment.setPost(post);
			persistentComment = commentDao.save(comment);	
	//	}
		

		return new ApiResponse("New Commemt added" + persistentComment.getId());
	}

	@Override
	public ApiResponse deleteCommentsByCommenterId(Long commenterId) {
		// TODO Auto-generated method stub
		User user = userDao.findById(commenterId).
				orElseThrow(()->new RuntimeException("Commenter Not found"));
		Optional<Integer> count=commentDao.deleteAllCommentsByCommenterId(commenterId);
		
		return new ApiResponse("Comments Deleted "+count);
	}
	
	
	

}
