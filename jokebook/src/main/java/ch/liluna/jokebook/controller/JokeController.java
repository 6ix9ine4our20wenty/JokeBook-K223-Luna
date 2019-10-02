package ch.liluna.jokebook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.liluna.jokebook.domain.Category;
import ch.liluna.jokebook.domain.Joke;
import ch.liluna.jokebook.domain.User;
import ch.liluna.jokebook.dto.JokeDTO;
import ch.liluna.jokebook.service.CategoryService;
import ch.liluna.jokebook.service.JokeService;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private JokeService jokeService;
    private CategoryService categoryService;

    public JokeController(JokeService jokeService, CategoryService categoryService) {
        this.jokeService = jokeService;
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Joke> getAllJokes() {
        return jokeService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JokeDTO createJokey(@Valid @RequestBody JokeDTO jokedto) {
    	Joke joke = new Joke();
    	joke.setCategoryIDFS(categoryService.findUserById(jokedto.getCategoryIDFS()).get());
    	joke.setJokeName(jokedto.getJokeName());
    	Joke createdJoke = jokeService.createJoke(joke);
        return JokeDTO.toDTO(createdJoke);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJoke(@PathVariable Long id) {
        jokeService.deleteJokeById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Joke updateJoke(@Valid @RequestBody Joke joke, @PathVariable Long id) {
        return jokeService.updateJoke(joke, id);
    }
}
