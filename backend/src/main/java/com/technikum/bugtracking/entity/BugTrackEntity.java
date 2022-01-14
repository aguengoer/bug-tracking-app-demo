package com.technikum.bugtracking.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "bug_track")
public class BugTrackEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, columnDefinition = "CHAR(36)")
    protected UUID id;

    @Nationalized
    @Column(name = "first_name")
    private String firstName;

    @Nationalized
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column(name = "recording_date")
    private LocalDate recordingDate;

    @Column(name = "description", columnDefinition = "NCLOB")
    @Nationalized
    private String description;

    @Column(name = "status")
    private Boolean status;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public LocalDate getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(LocalDate recordingDate) {
        this.recordingDate = recordingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
