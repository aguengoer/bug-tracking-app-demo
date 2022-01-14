package com.technikum.bugtracking.validator;

import com.technikum.bugtracking.entity.BugTrackEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BugTrackingRequiredFieldsSetValidator {

    public void validate(BugTrackEntity bugTrackEntity) {
        Assert.notNull(bugTrackEntity.getId(), "Id is null");
        Assert.notNull(bugTrackEntity.getFirstName(), "Firstname is null");
        Assert.notNull(bugTrackEntity.getLastName(), "Lastname is null");
        Assert.notNull(bugTrackEntity.getRecordingDate(), "Recordingdate is null");
        Assert.notNull(bugTrackEntity.getDescription(), "Description is null");
        Assert.notNull(bugTrackEntity.getStatus(), "Status is null");
    }

}
