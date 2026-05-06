package org.csu.cpsc.roadmap;

import java.util.Calendar;

/**
 * Represents a study goal associated with a cybersecurity certification.
 * Implements Comparable to allow sorting by priority level.
 */
public class Goal implements Comparable<Goal> {

    /** The name of the study goal. */
    private String goalName;

    /** The name of the certification this goal is associated with. */
    private String certificationName;

    /** The deadline for completing this goal. */
    private Calendar deadline;

    /** The priority level of this goal on a scale of 1-5. */
    private int priority;

    /**
     * Constructs a new Goal with the specified details.
     *
     * @param goalName          the name of the goal
     * @param certificationName the associated certification name
     * @param deadline          the deadline for the goal
     * @param priority          the priority level from 1 (lowest) to 5 (highest)
     */
    public Goal(String goalName, String certificationName, Calendar deadline, int priority) {
        this.goalName = goalName;
        this.certificationName = certificationName;
        this.deadline = deadline;
        this.priority = priority;
    }

    /**
     * Returns the name of the goal.
     * @return the goal name
     */
    public String getGoalName() { return goalName; }

    /**
     * Returns the associated certification name.
     * @return the certification name
     */
    public String getCertificationName() { return certificationName; }

    /**
     * Returns the deadline of the goal.
     * @return the deadline as a Calendar object
     */
    public Calendar getDeadline() { return deadline; }

    /**
     * Returns the priority level of the goal.
     * @return the priority level from 1 to 5
     */
    public int getPriority() { return priority; }

    /**
     * Compares this goal to another by priority level (higher priority comes first).
     *
     * @param other the other Goal to compare to
     * @return negative if this has higher priority, zero if equal, positive if lower
     */
    @Override
    public int compareTo(Goal other) {
        return Integer.compare(other.priority, this.priority);
    }

    /**
     * Returns a string representation of the goal.
     *
     * @return formatted string with priority, goal name, certification, and deadline
     */
    @Override
    public String toString() {
        return String.format("[Priority: %d] %s -> %s | Deadline: %d/%d/%d",
                priority, goalName, certificationName,
                deadline.get(Calendar.MONTH) + 1,
                deadline.get(Calendar.DAY_OF_MONTH),
                deadline.get(Calendar.YEAR));
    }
}