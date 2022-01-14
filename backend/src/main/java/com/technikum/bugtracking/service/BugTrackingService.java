package com.technikum.bugtracking.service;

import com.technikum.bugtracking.entity.BugTrackEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BugTrackingService {

    BugTrackEntity save(BugTrackEntity bugTrackEntity);

    List<BugTrackEntity> getAll();

    BugTrackEntity findById(UUID personId);

    void deletePerson(UUID personId);

    int countActivePerson();

    int countInActivePerson();
}
