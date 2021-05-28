package br.com.zupedu.olucas.mlivre.user.repository;

import br.com.zupedu.olucas.mlivre.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
