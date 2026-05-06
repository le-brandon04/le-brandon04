package org.csu.cpsc.roadmap;

import java.util.Calendar;

/**
 * Represents a cybersecurity certification being tracked in the roadmap.
 * Implements Comparable to allow sorting by difficulty level.
 */
public class Certification implements Comparable<Certification> {

    /** The name of the certification. */
    private String name;

    /** The organization that provides the certification. */
    private String provider;

    /** The current status of the certification (e.g. Not Started, In Progress, Completed). */
    private String status;

    /** The date of the certification exam. */
    private Calendar examDate;

    /** The difficulty level of the certification on a scale of 1-5. */
    private int difficulty;

    /**
     * Constructs a new Certification with the specified details.
     *
     * @param name       the name of the certification
     * @param provider   the organization providing the certification
     * @param status     the current status of the certification
     * @param examDate   the date of the certification exam
     * @param difficulty the difficulty level from 1 (easiest) to 5 (hardest)
     */
    public Certification(String name, String provider, String status, Calendar examDate, int difficulty) {
        this.name = name;
        this.provider = provider;
        this.status = status;
        this.examDate = examDate;
        this.difficulty = difficulty;
    }

    /**
     * Returns the name of the certification.
     * @return the certification name
     */
    public String getName() { return name; }

    /**
     * Returns the provider of the certification.
     * @return the certification provider
     */
    public String getProvider() { return provider; }

    /**
     * Returns the current status of the certification.
     * @return the certification status
     */
    public String getStatus() { return status; }

    /**
     * Returns the exam date of the certification.
     * @return the exam date as a Calendar object
     */
    public Calendar getExamDate() { return examDate; }

    /**
     * Returns the difficulty level of the certification.
     * @return the difficulty level from 1 to 5
     */
    public int getDifficulty() { return difficulty; }

    /**
     * Sets the status of the certification.
     * @param status the new status
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Sets the exam date of the certification.
     * @param examDate the new exam date
     */
    public void setExamDate(Calendar examDate) { this.examDate = examDate; }

    /**
     * Compares this certification to another by difficulty level.
     *
     * @param other the other Certification to compare to
     * @return negative if this is easier, zero if equal, positive if harder
     */
    @Override
    public int compareTo(Certification other) {
        return Integer.compare(this.difficulty, other.difficulty);
    }

    /**
     * Returns a string representation of the certification.
     *
     * @return formatted string with status, name, provider, difficulty, and exam date
     */
    @Override
    public String toString() {
        return String.format("[%s] %s (%s) | Difficulty: %d/5 | Exam: %d/%d/%d",
                status, name, provider, difficulty,
                examDate.get(Calendar.MONTH) + 1,
                examDate.get(Calendar.DAY_OF_MONTH),
                examDate.get(Calendar.YEAR));
    }
}