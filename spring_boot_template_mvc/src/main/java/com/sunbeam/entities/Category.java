package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
	@Column(name = "name", length = 30, unique = true)
	private String categoryName;
	private String description;
	//Category 1--->* BlogPost
	//One -- Parent -- Non Owing --since it does not contain foreign key
	//Mapped by :: Mandatory in bi-directional Association between entities appears in inverse (non-owning) 
	//def fetch type for any to many-LAZY
	//While accessing un-fetched data (i.e a proxy)outside of the session
	//hibernate throws -LazyInitializationException
	
	@OneToMany(mappedBy = "selectedCategory",  //MappingException If not declared
			cascade = CascadeType.ALL/* ,fetch = FetchType.EAGER */, 
			orphanRemoval = true)
	private List<BlogPost> posts = new ArrayList<>();

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BlogPost> getPosts() {
		return posts;
	}

	public void setPosts(List<BlogPost> posts) {
		this.posts = posts;
	}

	//Use case: To add Post(Child) in Existing Category(Parent)
	// add helper method in the entity layer to establish bi-dir association between
	// Category n post
	public void addBlogPost(BlogPost post) {
		// establish category --> post (parent --> child)
		this.posts.add(post);
		// establish post --> category (child -> parent)
		post.setSelectedCategory(this);
	}

	// add helper method in the entity layer to un - establish bi-dir association
	// between Category n post
	public void removeBlogPost(BlogPost post) {
		this.posts.remove(post);
		post.setSelectedCategory(null);
	}

	@Override
	public String toString() {
		return "Category ID " + getId() + " [categoryName=" + categoryName + ", description=" + description + "]";
	}

}
