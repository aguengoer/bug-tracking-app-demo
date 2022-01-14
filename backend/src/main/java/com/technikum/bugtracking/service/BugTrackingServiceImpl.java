package com.technikum.bugtracking.service;

import com.technikum.bugtracking.entity.BugTrackEntity;
import com.technikum.bugtracking.repository.BugTrackingRepository;
import com.technikum.bugtracking.validator.BugTrackingDateValidator;
import com.technikum.bugtracking.validator.BugTrackingRequiredFieldsSetValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class BugTrackingServiceImpl implements BugTrackingService {

    private final BugTrackingRepository bugTrackingRepository;

    private final BugTrackingRequiredFieldsSetValidator bugTrackingRequiredFieldsSetValidator;

    private final BugTrackingDateValidator bugTrackingDateValidator;

    public BugTrackingServiceImpl(BugTrackingRepository bugTrackingRepository, BugTrackingRequiredFieldsSetValidator bugTrackingRequiredFieldsSetValidator, BugTrackingDateValidator bugTrackingDateValidator) {
        this.bugTrackingRepository = bugTrackingRepository;
        this.bugTrackingRequiredFieldsSetValidator = bugTrackingRequiredFieldsSetValidator;
        this.bugTrackingDateValidator = bugTrackingDateValidator;
    }

    @Override
    public BugTrackEntity save(BugTrackEntity bugTrackEntity) {
        bugTrackingRequiredFieldsSetValidator.validate(bugTrackEntity);
        bugTrackingDateValidator.validate(bugTrackEntity);
        return bugTrackingRepository.save(bugTrackEntity);
    }

    @Override
    public List<BugTrackEntity> getAll() {
        return bugTrackingRepository.findAll();
    }

    @Override
    public BugTrackEntity findById(UUID personId) {
        Optional<BugTrackEntity> personById = bugTrackingRepository.findById(personId);

        Assert.isTrue(personById.isPresent(), String.format("Person with id %s not found", personById.toString()));

        return personById.get();
    }

    @Override
    public void deletePerson(UUID personId) {
        bugTrackingRepository.deleteById(personId);
    }

    @Override
    public int countActivePerson() {
        return  bugTrackingRepository.getAllActive().size();
    }

    @Override
    public int countInActivePerson() {
        return bugTrackingRepository.getAllInActive().size();
    }
}
