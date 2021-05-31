package br.com.zupedu.olucas.mlivre.product.repository;

import br.com.zupedu.olucas.mlivre.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
