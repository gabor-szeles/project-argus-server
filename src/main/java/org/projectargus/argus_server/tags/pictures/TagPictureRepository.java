package org.projectargus.argus_server.tags.pictures;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagPictureRepository extends JpaRepository<TagPicture, Long> {
}
