package org.csu.cpsc.roadmap;

import java.util.Calendar;

public class Certification implements Comparable<Certification> {
    private String name;
    private String provider;
    private String status; // "Not Started", "In Progress", "Completed"
    private Calendar examDate;
    private int difficulty; // 1-5

    public Certification(String name, String provider, String status, Calendar examDate, int difficulty) {
        this.name = name;
        this.provider = provider;
        this.status = status;
        this.examDate = examDate;
        this.difficulty = difficulty;
    }

    public String getName() { return name; }
    public String getProvider() { return provider; }
    public String getStatus() { return status; }
    public Calendar getExamDate() { return examDate; }
    public int getDifficulty() { return difficulty; }

    public void setStatus(String status) { this.status = status; }
    public void setExamDate(Calendar examDate) { this.examDate = examDate; }

    @Override
    public int compareTo(Certification other) {
        return Integer.compare(this.difficulty, other.difficulty);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) | Difficulty: %d/5 | Exam: %d/%d/%d",
                status, name, provider, difficulty,
                examDate.get(Calendar.MONTH) + 1,
                examDate.get(Calendar.DAY_OF_MONTH),
                examDate.get(Calendar.YEAR));
    }
}