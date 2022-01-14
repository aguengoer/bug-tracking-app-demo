package com.technikum.bugtracking.repository;

import com.technikum.bugtracking.entity.BugTrackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BugTrackingRepository extends JpaRepository<BugTrackEntity, UUID> {

    @Query("select p from BugTrackEntity p where p.status=true")
    List<BugTrackEntity> getAllActive();

    @Query("select p from BugTrackEntity p where p.status=false")
    List<BugTrackEntity> getAllInActive();

}
