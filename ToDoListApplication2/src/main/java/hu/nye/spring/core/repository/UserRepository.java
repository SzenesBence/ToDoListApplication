package hu.nye.spring.core.repository;

import hu.nye.spring.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserEntity, Long > {
}
