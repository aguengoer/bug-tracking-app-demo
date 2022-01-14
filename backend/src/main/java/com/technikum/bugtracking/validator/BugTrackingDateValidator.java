package com.technikum.bugtracking.validator;

import com.technikum.bugtracking.entity.BugTrackEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class BugTrackingDateValidator {

    public void validate(BugTrackEntity bugTrackEntity) {
        LocalDate nowTimeMinusFourTeen = LocalDate.now().minus(14, ChronoUnit.YEARS);

    }
}
