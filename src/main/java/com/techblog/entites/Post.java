package com.techblog.entites;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="tbl_post")
public class Post 
{
	@Id
	@Column(name="PostId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long postId;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Post_Categary")
	private String postCategary;	
	
	
	@Column(name="SubTitle")
	private String subTitle;
	
	@Column(name="ImageUrl")
	private String imageUrl;
	
	@Column(name="PublishDate")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date publishDate;
	
	@Column(name="Content",length = 100000)
	private String content;
	
	@Column(name="PostType")
	private String postType;
	
	@Column(name="IsPublish")
	private String isPublish;
	
	@Column
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertTime;
	
	public Post() {}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsPublish() {
		return isPublish;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostCategary() {
		return postCategary;
	}

	public void setPostCategary(String postCategary) {
		this.postCategary = postCategary;
	}	
	
 
}
