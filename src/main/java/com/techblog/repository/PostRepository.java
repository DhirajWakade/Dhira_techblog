package com.techblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.techblog.entites.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	@Query("SELECT post FROM Post post WHERE post.postType = ?1")
	List<Post>findByPostType(String posttype);
}
