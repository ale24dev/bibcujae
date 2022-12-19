package cujae.edu.cu.bibcujae.modules.security.role.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cujae.edu.cu.bibcujae.modules.security.role.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
}