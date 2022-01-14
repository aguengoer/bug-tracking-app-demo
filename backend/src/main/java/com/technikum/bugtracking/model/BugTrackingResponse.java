package com.technikum.bugtracking.model;

public class BugTrackingResponse {

    private String userId;

    private String firstName;

    private String lastName;

    private String email;

    private String recordingDate;

    private String description;

    private boolean status;

    public BugTrackingResponse(String userId, String firstName, String lastName, String email, String recordingDate, String description, boolean status) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.recordingDate = recordingDate;
        this.description = description;
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(String recordingDate) {
        this.recordingDate = recordingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
