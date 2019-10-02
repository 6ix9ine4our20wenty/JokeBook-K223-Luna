package ch.liluna.jokebook.controller;

import java.util.ArrayList;
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

import ch.liluna.jokebook.domain.User;
import ch.liluna.jokebook.dto.UsersDTO;
import ch.liluna.jokebook.service.RoleService;
import ch.liluna.jokebook.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
	private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    // DTO Mapping um alle User anzuzeigen
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsersDTO> getAllUsers() {
    	List<UsersDTO> users = new ArrayList<>();
    	List<User> dbUsers = userService.findAll();
    	for(User u : dbUsers) {
    		users.add(UsersDTO.toDTO(u));
    	}
    	return users;
    }
    // User Erstellen mit der Entität User
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsersDTO createUser(@Valid @RequestBody UsersDTO usersdto) {
    	User user = new User();
    	user.setUsername(usersdto.getUsername());
    	user.setRoleIDFS(roleService.findUserById(usersdto.getRoleIDFS()).orElse(null)); 
        User createdUser = userService.createUser(user);
        return UsersDTO.toDTO(createdUser);
    }
    // User Löschen anhand der ID
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
    //Update/Edit User mit Fachklasse User und zugehörige ID
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}
