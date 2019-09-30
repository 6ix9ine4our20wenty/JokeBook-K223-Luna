package ch.liluna.jokebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.liluna.jokebook.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
