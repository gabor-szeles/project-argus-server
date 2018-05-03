package org.projectargus.argus_server.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetTagRepository extends JpaRepository<StreetTag, Long> {

    List<StreetTag> findAllByIdAndPrivacy(Long id, Privacy privacy);
}
