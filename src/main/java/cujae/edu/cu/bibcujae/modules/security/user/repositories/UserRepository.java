package cujae.edu.cu.bibcujae.modules.security.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cujae.edu.cu.bibcujae.modules.security.user.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
}