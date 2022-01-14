package com.technikum.bugtracking.validator;

import com.technikum.bugtracking.UnitTestBase;
import com.technikum.bugtracking.entity.BugTrackEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("bug required fields set validator")
class BugTrackingRequiredFieldsSetValidatorTest extends UnitTestBase {

    BugTrackingRequiredFieldsSetValidator testable = new BugTrackingRequiredFieldsSetValidator();

    @Test
    @DisplayName("all fields set")
    public void _1() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);

        testable.validate(bugTrackEntity);
    }

    @Test
    @DisplayName("id: null, should throw excpetion")
    public void _2() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);
        bugTrackEntity.setId(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(bugTrackEntity));
    }

    @Test
    @DisplayName("firstname: null, should throw excpetion")
    public void _3() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);
        bugTrackEntity.setFirstName(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(bugTrackEntity));
    }

    @Test
    @DisplayName("lastname: null, should throw excpetion")
    public void _4() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);
        bugTrackEntity.setLastName(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(bugTrackEntity));
    }

    @Test
    @DisplayName("recordingdate: null, should throw excpetion")
    public void _5() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);
        bugTrackEntity.setRecordingDate(null);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(bugTrackEntity));
    }
}
