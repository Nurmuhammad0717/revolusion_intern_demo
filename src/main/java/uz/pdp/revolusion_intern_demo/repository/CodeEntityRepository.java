package uz.pdp.revolusion_intern_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.revolusion_intern_demo.entity.CodeEntity;


import java.util.Optional;

@Repository
public interface CodeEntityRepository extends JpaRepository<CodeEntity, Long> {
    Optional<CodeEntity> findByEmail(String email);
}