package ch.liluna.jokebook.controller;

import java.util.List;
import java.util.stream.Collectors;

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
import ch.liluna.jokebook.dto.UsersDTO;
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
    // DTO Mapping um alle Joke anzuzeigen
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<JokeDTO> getAllJokes() {
    	//joke -> JokeDTO.toUser(joke)
        return jokeService.findAll().stream().map(JokeDTO::toDTO).collect(Collectors.toList());
    }
 // Witz Erstellen mit der Entität Witz
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JokeDTO createJokey(@Valid @RequestBody JokeDTO jokedto) {
    	Joke joke = new Joke();
    	joke.setCategoryIDFS(categoryService.findUserById(jokedto.getCategoryIDFS()).get());
    	joke.setJokeName(jokedto.getJokeName());
    	Joke createdJoke = jokeService.createJoke(joke);
        return JokeDTO.toDTO(createdJoke);
    }
    // Witz Löschen anhand der ID
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJoke(@PathVariable Long id) {
        jokeService.deleteJokeById(id);
    }
    //Update/Edit Witz mit Fachklasse User und zugehörige ID
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Joke updateJoke(@Valid @RequestBody Joke joke, @PathVariable Long id) {
        return jokeService.updateJoke(joke, id);
    }
}
