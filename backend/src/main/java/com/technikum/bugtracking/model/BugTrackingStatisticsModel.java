package com.technikum.bugtracking.model;

public class BugTrackingStatisticsModel {

    private int allBugsCount;

    private int activeBugs;

    private int inActiveBugs;

    public BugTrackingStatisticsModel(int allBugsCount, int activeBugs, int inActiveBugs) {
        this.allBugsCount = allBugsCount;
        this.activeBugs = activeBugs;
        this.inActiveBugs = inActiveBugs;
    }

    public int getAllBugsCount() {
        return allBugsCount;
    }

    public int getActiveBugs() {
        return activeBugs;
    }

    public int getInActiveBugs() {
        return inActiveBugs;
    }
}
