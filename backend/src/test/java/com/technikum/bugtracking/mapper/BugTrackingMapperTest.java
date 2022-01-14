package com.technikum.bugtracking.mapper;


import com.technikum.bugtracking.UnitTestBase;
import com.technikum.bugtracking.converter.DateConverter;
import com.technikum.bugtracking.entity.BugTrackEntity;
import com.technikum.bugtracking.model.BugTrackingRequest;
import com.technikum.bugtracking.model.BugTrackingResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("bug mapper")
class BugTrackingMapperTest extends UnitTestBase {

    private final BugTrackingMapper testable = new BugTrackingMapper(new DateConverter());

    @Test
    @DisplayName("mapFromEntityToResponse")
    public void _1() {
        BugTrackEntity expected = randomizer().createRandomObject(BugTrackEntity.class);

        BugTrackingResponse result = testable.mapFromEntityToResponse(expected);

        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getRecordingDate().toString(), result.getRecordingDate());
    }


    @Test
    @DisplayName("mapFromRequestToEntity")
    public void _2() {
        String date = "2019-01-01";
        BugTrackingRequest expected = randomizer().appendFixedField("birthDate", date, BugTrackingRequest.class)
                .appendFixedField("recordingDate", date, BugTrackingRequest.class)
                .appendFixedField("leavingDate", date, BugTrackingRequest.class)
                .appendFixedField("salary", "2000", BugTrackingRequest.class)
                .createRandomObject(BugTrackingRequest.class);

        BugTrackEntity result = testable.mapFromRequestToEntity(expected);

        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getRecordingDate(), result.getRecordingDate().toString());
    }


}
