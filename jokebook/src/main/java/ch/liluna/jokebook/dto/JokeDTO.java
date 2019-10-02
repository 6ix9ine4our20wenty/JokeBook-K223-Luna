package ch.liluna.jokebook.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import ch.liluna.jokebook.domain.Joke;

@Entity
public class JokeDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long JokeId;

	private String JokeName;

	private long categoryIDFS;

	public JokeDTO(long categroyIDFS, String JokeName, long JokeId) {
		this.categoryIDFS = categroyIDFS;
		this.JokeName = JokeName;
		this.JokeId = JokeId;
	}
	
	public long getJokeId() {
		return JokeId;
	}

	public void setJokeId(long jokeId) {
		JokeId = jokeId;
	}

	public long getCategoryIDFS() {
		return categoryIDFS;
	}

	public void setCategoryIDFS(long categoryIDFS) {
		this.categoryIDFS = categoryIDFS;
	}

	public String getJokeName() {
		return JokeName;
	}

	public void setJokeName(String jokeName) {
		JokeName = jokeName;
	}
	
	public static JokeDTO toDTO(Joke joke) {
		JokeDTO jokedto = new JokeDTO(joke.getCategoryIDFS().getCategoryId(), joke.getJokeName(), joke.getJokeId());	
		return jokedto;
	}

}
