package SpringSecurity.repository;

import SpringSecurity.model.GeekUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<GeekUser, Long> {

    Optional<GeekUser> findByName(String name);
}
