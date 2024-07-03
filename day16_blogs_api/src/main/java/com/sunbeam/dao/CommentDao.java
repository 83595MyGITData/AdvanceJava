package com.sunbeam.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.entities.Comment;

public interface CommentDao extends JpaRepository<Comment, Long>{
	
	//Comment*-->Post
	//Comment*-->User

	//@Query("Delete from Comment c where c.commenter.id=:commenterId")

	//public Long deleteAllCommentsByCommenterId(@Param("commenterId") Long commenterId);
	
	@Modifying
    //@Transactional
    @Query("DELETE FROM Comment c WHERE c.commenter.id = :commenterId")
	public Optional<Integer> deleteAllCommentsByCommenterId(@Param("commenterId") Long commenterId);
	 
}
