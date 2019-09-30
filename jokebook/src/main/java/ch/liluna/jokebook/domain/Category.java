package ch.liluna.jokebook.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long CategoryId;
	
	@OneToMany(mappedBy = "categoryIDFS")
	private List<Joke> jokes;
	
	private String CategoryName;

	public long getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(long categoryId) {
		CategoryId = categoryId;
	}

	public List<Joke> getJokes() {
		return jokes;
	}

	public void setJokes(List<Joke> jokes) {
		this.jokes = jokes;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	
	

}
