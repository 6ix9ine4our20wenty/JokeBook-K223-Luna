package ch.liluna.jokebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.liluna.jokebook.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
