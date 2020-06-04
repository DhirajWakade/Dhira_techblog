package com.techblog.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techblog.Exceptions.FolderNotFoundException;
import com.techblog.entites.Post;

import com.techblog.repository.PostRepository;

@Service
public class PostServices {

	@Autowired
	private PostRepository postRepository;

	public static String uploadFolder = System.getProperty("user.dir") + "/target/classes/static/images";
	
	

	public Post savePost(Post post) {
		try
		{
		post.setIsPublish("Y");
		Post p = postRepository.save(post);
		
		return p;
		}
		catch (Exception e) {
			return null;
		}
	}

	public Post savePostData(MultipartFile mfile, String postJson) throws FolderNotFoundException {

		String fileName = mfile.getOriginalFilename();
		File f = new File(uploadFolder);

		File convertfile = new File(uploadFolder + "\\" + mfile.getOriginalFilename());
		try {
			if (!f.isDirectory()) {
				f.mkdir();
			}
			convertfile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertfile);
			fout.write(mfile.getBytes());
			fout.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		Post post = null;
		try {
			post = objectMapper.readValue(postJson, Post.class);
			post.setImageUrl("/images/"+fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return savePost(post);
	}
	
	public List<Post>getAllPost()
	{
		return postRepository.findAll();
	}
	public void deleteAll()
	{
		 postRepository.deleteAll();
	}
	
	public void deletePost(Long postid)
	{
		Optional<Post> p=postRepository.findById(postid);
		if(p.isPresent()) {
		postRepository.delete(p.get());
		}
	}
	
	public List<Post>getPostByType(String postType)
	{
		return postRepository.findByPostType(postType);
	}
	

}
