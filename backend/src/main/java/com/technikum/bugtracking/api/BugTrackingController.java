package com.technikum.bugtracking.api;

import com.technikum.bugtracking.entity.BugTrackEntity;
import com.technikum.bugtracking.mapper.BugTrackingMapper;
import com.technikum.bugtracking.model.BugTrackingRequest;
import com.technikum.bugtracking.model.BugTrackingResponse;
import com.technikum.bugtracking.model.BugTrackingStatisticsModel;
import com.technikum.bugtracking.service.BugTrackingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/bug")
public class BugTrackingController {

    private final BugTrackingService bugTrackingService;

    private final BugTrackingMapper mapper;

    public BugTrackingController(BugTrackingService bugTrackingService, BugTrackingMapper mapper) {
        this.bugTrackingService = bugTrackingService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<BugTrackingResponse> getAll() {
        List<BugTrackEntity> allPerson = bugTrackingService.getAll();

        return allPerson.stream().map(mapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BugTrackingResponse getById(@PathVariable("id") UUID id) {
        return mapper.mapFromEntityToResponse(bugTrackingService.findById(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody BugTrackingRequest bugTrackingRequest) {
        bugTrackingService.save(mapper.mapFromRequestToEntity(bugTrackingRequest));
    }

    @PutMapping("/{id}")
    public BugTrackingResponse update(@PathVariable("id") UUID id, @RequestBody BugTrackingRequest bugTrackingRequest) {
        BugTrackEntity mappedBugTrackEntity = mapper.mapFromRequestToEntity(bugTrackingRequest);
        mappedBugTrackEntity.setId(id);

        BugTrackEntity savedBugTrackEntity = bugTrackingService.save(mappedBugTrackEntity);

        return mapper.mapFromEntityToResponse(savedBugTrackEntity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id) {
        bugTrackingService.deletePerson(id);
    }

    @GetMapping("/statistic")
    public BugTrackingStatisticsModel getTrends() {
        return new BugTrackingStatisticsModel(bugTrackingService.getAll().size(),
                bugTrackingService.countActivePerson(),
                bugTrackingService.countInActivePerson());
    }


    /*private void createDemo(UUID uuid) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(uuid);
        personEntity.setBirthDate(LocalDate.now());
        personEntity.setFirstName("testName");
        personEntity.setLastName("testn");
        personEntity.setAdress("test-adress 123");
        personEntity.setSalary(2000);
        personEntity.setLeavingDate(LocalDate.now());
        personEntity.setRecordingDate(LocalDate.now());
        personEntity.setStatus(false);

        personService.save(personEntity);
    }*/
}
