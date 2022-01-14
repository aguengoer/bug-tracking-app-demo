package com.technikum.bugtracking.mapper;

import com.technikum.bugtracking.converter.DateConverter;
import com.technikum.bugtracking.entity.BugTrackEntity;
import com.technikum.bugtracking.model.BugTrackingRequest;
import com.technikum.bugtracking.model.BugTrackingResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BugTrackingMapper {

    private final DateConverter dateConverter;

    public BugTrackingMapper(DateConverter dateConverter) {this.dateConverter = dateConverter;}

    public BugTrackEntity mapFromRequestToEntity(BugTrackingRequest bugTrackingRequest) {
        BugTrackEntity bugTrackEntity = new BugTrackEntity();
        bugTrackEntity.setId(UUID.randomUUID());
        bugTrackEntity.setRecordingDate(dateConverter.convert(bugTrackingRequest.getRecordingDate()));
        bugTrackEntity.setFirstName(bugTrackingRequest.getFirstName());
        bugTrackEntity.setLastName(bugTrackingRequest.getLastName());
        bugTrackEntity.setEmail(bugTrackingRequest.getEmail());
        bugTrackEntity.setDescription(bugTrackingRequest.getDescription());
        bugTrackEntity.setStatus(bugTrackingRequest.isStatus());

        return bugTrackEntity;
    }

    public BugTrackingResponse mapFromEntityToResponse(BugTrackEntity bugTrackEntity) {
        return new BugTrackingResponse(bugTrackEntity.getId().toString(), bugTrackEntity.getFirstName(),
                bugTrackEntity.getLastName(), bugTrackEntity.getEmail(), bugTrackEntity.getRecordingDate().toString(),
                bugTrackEntity.getDescription(), bugTrackEntity.getStatus());

    }
}
