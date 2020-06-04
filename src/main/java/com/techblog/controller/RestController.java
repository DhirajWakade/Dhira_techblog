package com.techblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.techblog.Exceptions.FolderNotFoundException;
import com.techblog.configuration.MessageConfig;
import com.techblog.configuration.ResponseClass;
import com.techblog.configuration.StatusConfig;
import com.techblog.entites.Post;
import com.techblog.services.PostServices;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "http://localhost:4200")
public class RestController {

	@Autowired
	private PostServices postServices;
	
	@Autowired
	private StatusConfig statusConfig;
	
	@Autowired
	private MessageConfig messageConfig;

	@RequestMapping(value = "/savePost", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseClass<?> SavePost(@RequestParam("file") MultipartFile mfile,
			@RequestParam("PostJSON") String postJSON) {
		Post p;
		try {
			p = postServices.savePostData(mfile, postJSON);
		} catch (FolderNotFoundException e) {
			return new ResponseClass<>(null, messageConfig.getMsgFailedTryAgain(), statusConfig.getResponceStatusFailed());
		}
		if (p != null) {
			return new ResponseClass<>(p, messageConfig.getMsgSuccessfullyInserted(),
					statusConfig.getResponceStatusSuccess());
		} else {
			return new ResponseClass<>(null, messageConfig.getMsgFailedTryAgain(), statusConfig.getResponceStatusFailed());
		}
	}

	@RequestMapping(value = "/AllPost", method = RequestMethod.GET)
	public ResponseClass<?> allPost() {
		List<Post> pList = postServices.getAllPost();

		if (pList != null) {
			return new ResponseClass<>(pList, statusConfig.getResponceStatusSuccess(),
					statusConfig.getResponceStatusSuccess());
		} else {
			return new ResponseClass<>(null, messageConfig.getMsgFailedTryAgain(), statusConfig.getResponceStatusFailed());
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResponseClass<?> allDeleteAllPost() {

		postServices.deleteAll();
		return new ResponseClass<>(null, statusConfig.getResponceStatusSuccess(), statusConfig.getResponceStatusSuccess());

	}

	@RequestMapping(value = "/delete/{postid}", method = RequestMethod.GET)
	public ResponseClass<?> deletePost(@RequestParam("postid") Long postid) {
		postServices.deletePost(postid);
		return new ResponseClass<>(null, statusConfig.getResponceStatusSuccess(), statusConfig.getResponceStatusSuccess());
	}
	
	@RequestMapping(value = "/getPost/{postType}", method = RequestMethod.GET)
	public ResponseClass<?> getPostByType(@PathVariable String postType)
	{
		//
		List<Post> pList = postServices.getPostByType(postType);

		if (pList != null) {
			return new ResponseClass<>(pList, statusConfig.getResponceStatusSuccess(),
					statusConfig.getResponceStatusSuccess());
		} else {
			return new ResponseClass<>(null, messageConfig.getMsgFailedTryAgain(), statusConfig.getResponceStatusFailed());
		}
	}

}
