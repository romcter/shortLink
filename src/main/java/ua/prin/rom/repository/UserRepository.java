package ua.prin.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.prin.rom.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    boolean existsByLogin(String login);
    boolean existsByPhone(String phone);
    boolean existsByEmail(String email);

}
