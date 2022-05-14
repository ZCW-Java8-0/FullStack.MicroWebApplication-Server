package com.nyce.tube.repository;

import com.nyce.tube.domain.Videos;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Videos entity.
 */
@Repository
public interface VideosRepository extends JpaRepository<Videos, Long> {
    @Query("select videos from Videos videos where videos.user.login = ?#{principal.username}")
    List<Videos> findByUserIsCurrentUser();

    default Optional<Videos> findOneWithEagerRelationships(Long id) {
        return this.findOneWithToOneRelationships(id);
    }

    default List<Videos> findAllWithEagerRelationships() {
        return this.findAllWithToOneRelationships();
    }

    default Page<Videos> findAllWithEagerRelationships(Pageable pageable) {
        return this.findAllWithToOneRelationships(pageable);
    }

    @Query(
        value = "select distinct videos from Videos videos left join fetch videos.user",
        countQuery = "select count(distinct videos) from Videos videos"
    )
    Page<Videos> findAllWithToOneRelationships(Pageable pageable);

    @Query("select distinct videos from Videos videos left join fetch videos.user")
    List<Videos> findAllWithToOneRelationships();

    @Query("select videos from Videos videos left join fetch videos.user where videos.id =:id")
    Optional<Videos> findOneWithToOneRelationships(@Param("id") Long id);
}
