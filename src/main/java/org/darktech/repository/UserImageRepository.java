package org.darktech.repository;
import java.util.Optional;
import org.darktech.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserImageRepository extends JpaRepository<UserImage, Long> {
    Optional<UserImage> findByUser_Id(Long userId);
}
