package org.darktech.repository;

import org.darktech.entity.User;
import org.darktech.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
	
	List<User> findByStatus(UserStatus status);
}
