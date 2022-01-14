package com.technikum.bugtracking.service;

import com.technikum.AbstractTestBase;
import com.technikum.bugtracking.BugTrackingApplication;
import com.technikum.bugtracking.entity.BugTrackEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("bug service")
@Transactional
@SpringBootTest(classes = BugTrackingApplication.class)
class BugTrackingServiceTest extends AbstractTestBase {

    @Autowired
    BugTrackingService bugTrackingService;

    @Test
    @DisplayName("bug create")
    public void _1() {
        BugTrackEntity expectedPerson = randomizer().createRandomObject(BugTrackEntity.class);

        BugTrackEntity result = bugTrackingService.save(expectedPerson);

        assertEquals(expectedPerson.getFirstName(), result.getFirstName());
        assertEquals(expectedPerson.getLastName(), result.getLastName());
        assertEquals(expectedPerson.getRecordingDate(), result.getRecordingDate());
    }

    @Test
    @DisplayName("get all")
    public void _2() {
        createRandomBug();
        createRandomBug();
        createRandomBug();

        List<BugTrackEntity> result = bugTrackingService.getAll();

        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("read bug with ID")
    public void _3() {
        BugTrackEntity expectedPerson = createRandomBug();

        BugTrackEntity result = bugTrackingService.findById(expectedPerson.getId());

        assertEquals(expectedPerson, result);
    }

    @Test
    @DisplayName("find by id not found, throws Exception")
    public void _4() {
        assertThrows(IllegalArgumentException.class, () -> bugTrackingService.findById(UUID.randomUUID()));
    }

    @Test
    @DisplayName("delete bug")
    public void _5() {
        BugTrackEntity expected = createRandomBug();

        bugTrackingService.deletePerson(expected.getId());

        assertEquals(0, bugTrackingService.getAll().size());
    }

    public BugTrackEntity createRandomBug() {
        BugTrackEntity expectedPerson = randomizer().createRandomObject(BugTrackEntity.class);
        return bugTrackingService.save(expectedPerson);
    }
}
