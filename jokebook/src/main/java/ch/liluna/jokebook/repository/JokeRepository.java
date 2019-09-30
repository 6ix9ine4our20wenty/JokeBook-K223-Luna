package ch.liluna.jokebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.liluna.jokebook.domain.Joke;

public interface JokeRepository extends JpaRepository<Joke, Long> {

}
