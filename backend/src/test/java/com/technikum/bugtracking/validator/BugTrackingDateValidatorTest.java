package com.technikum.bugtracking.validator;


import com.technikum.bugtracking.UnitTestBase;
import com.technikum.bugtracking.entity.BugTrackEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("person birth date validator")
class BugTrackingDateValidatorTest extends UnitTestBase {

    BugTrackingDateValidator testable = new BugTrackingDateValidator();

    @Test
    @DisplayName("validate: older than 14")
    public void _1() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);

        testable.validate(bugTrackEntity);
    }

    @Test
    @DisplayName("validate: younger than 14, should throw exception")
    public void _2() {
        BugTrackEntity bugTrackEntity = randomizer().createRandomObject(BugTrackEntity.class);

        assertThrows(IllegalArgumentException.class, () -> testable.validate(bugTrackEntity));
    }

}
