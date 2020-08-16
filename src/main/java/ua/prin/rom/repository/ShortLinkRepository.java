package ua.prin.rom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.prin.rom.entity.ShortLink;
import ua.prin.rom.entity.User;

import javax.transaction.Transactional;

public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {

    ShortLink findByShortlink(Integer shortLink);
    boolean existsByLongLinkAndUser(String longLink, User user);

    @Modifying
    @Transactional
    @Query("update ShortLink s set s.count= :count where s.id= :id")
    void updateCount(@Param("count") Long count, @Param("id") Long id);


}
