package ch.liluna.jokebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.liluna.jokebook.domain.Joke;
import ch.liluna.jokebook.repository.JokeRepository;

@Service
public class JokeService {
	 private JokeRepository jokeRepository;

	    public JokeService(JokeRepository jokeRepository) {
	        this.jokeRepository = jokeRepository;
	    }

	    public List<Joke> findAll() {
	        return jokeRepository.findAll();
	    }

	    public Optional<Joke> findUserById(long id) {
	        return jokeRepository.findById(id);
	    }

	    public Joke createJoke(Joke joke) {
	        return jokeRepository.saveAndFlush(joke);
	    }

	    public void deleteJokeById(long id) {
	        if (jokeRepository.existsById(id)) {
	            jokeRepository.deleteById(id);
	        }
	    }

	    public Joke updateJoke(Joke joke, Long id) {
	        Joke updatedJoke;
	        Optional<Joke> optionalUpdatedEntry = findUserById(id);

	        if (optionalUpdatedEntry.isPresent()) {
	            updatedJoke = optionalUpdatedEntry.get();
	            updatedJoke.setJokeName(joke.getJokeName());
	            updatedJoke.setCategoryIDFS(joke.getCategoryIDFS());
	        } else {
	            updatedJoke = joke;
	            updatedJoke.setJokeId(id);
	        }
	        return jokeRepository.saveAndFlush(updatedJoke);
	    }

}
