package ch.liluna.jokebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.liluna.jokebook.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
