package cujae.edu.cu.bibcujae.modules.security.user_role.repository;

import org.springframework.stereotype.Repository;

import cujae.edu.cu.bibcujae.modules.security.user_role.entity.UserRoleEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{
}