package ch.liluna.jokebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ch.liluna.jokebook.domain.User;
import ch.liluna.jokebook.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public void deleteUserById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public User updateUser(User user, Long id) {
        User updatedUser;
        Optional<User> optionalUpdatedEntry = findUserById(id);

        if (optionalUpdatedEntry.isPresent()) {
            updatedUser = optionalUpdatedEntry.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
        } else {
            updatedUser = user;
            updatedUser.setUserId(id);
        }
        return userRepository.saveAndFlush(updatedUser);
    }
}
