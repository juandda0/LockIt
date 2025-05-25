package org.juannn.lockit.repository;

import org.juannn.lockit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
