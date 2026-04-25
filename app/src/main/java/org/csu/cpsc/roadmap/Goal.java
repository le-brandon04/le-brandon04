package org.csu.cpsc.roadmap;

import java.util.Calendar;

public class Goal implements Comparable<Goal> {
    private String goalName;
    private String certificationName;
    private Calendar deadline;
    private int priority; // 1-5, 5 being highest

    public Goal(String goalName, String certificationName, Calendar deadline, int priority) {
        this.goalName = goalName;
        this.certificationName = certificationName;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getGoalName() { return goalName; }
    public String getCertificationName() { return certificationName; }
    public Calendar getDeadline() { return deadline; }
    public int getPriority() { return priority; }

    @Override
    public int compareTo(Goal other) {
        // Higher priority comes first
        return Integer.compare(other.priority, this.priority);
    }

    @Override
    public String toString() {
        return String.format("[Priority: %d] %s -> %s | Deadline: %d/%d/%d",
                priority, goalName, certificationName,
                deadline.get(Calendar.MONTH) + 1,
                deadline.get(Calendar.DAY_OF_MONTH),
                deadline.get(Calendar.YEAR));
    }
}