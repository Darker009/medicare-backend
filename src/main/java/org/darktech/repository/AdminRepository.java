package org.darktech.repository;

import java.util.Optional;

import org.darktech.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findFirstByOrderByAdminIdAsc();

}
