package br.com.zupedu.olucas.mlivre.category.repository;

import br.com.zupedu.olucas.mlivre.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
