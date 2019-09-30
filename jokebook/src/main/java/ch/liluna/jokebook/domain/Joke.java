package ch.liluna.jokebook.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Joke {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long JokeId;

	private String JokeName;

	@ManyToOne(optional = false)
	private Category categoryIDFS;

	public long getJokeId() {
		return JokeId;
	}

	public void setJokeId(long jokeId) {
		JokeId = jokeId;
	}

	public Category getCategoryIDFS() {
		return categoryIDFS;
	}

	public void setCategoryIDFS(Category categoryIDFS) {
		this.categoryIDFS = categoryIDFS;
	}

	public String getJokeName() {
		return JokeName;
	}

	public void setJokeName(String jokeName) {
		JokeName = jokeName;
	}

}
