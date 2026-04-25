package org.csu.cpsc.roadmap;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        RoadmapTracker tracker = new RoadmapTracker();

        // ── Feature 1: Certification Manager ─────────────────────────────

        System.out.println("=== Feature 1: Certification Manager ===\n");

        Calendar secPlusDate = Calendar.getInstance();
        secPlusDate.set(2025, Calendar.JUNE, 15);

        Calendar cehDate = Calendar.getInstance();
        cehDate.set(2025, Calendar.SEPTEMBER, 1);

        Calendar cisspDate = Calendar.getInstance();
        cisspDate.set(2026, Calendar.JANUARY, 20);

        Calendar awsDate = Calendar.getInstance();
        awsDate.set(2025, Calendar.AUGUST, 10);

        Certification secPlus = new Certification("CompTIA Security+", "CompTIA", "In Progress", secPlusDate, 2);
        Certification ceh = new Certification("CEH", "EC-Council", "Not Started", cehDate, 3);
        Certification cissp = new Certification("CISSP", "ISC2", "Not Started", cisspDate, 5);
        Certification aws = new Certification("AWS Security Specialty", "Amazon", "Not Started", awsDate, 4);

        tracker.addCertification(secPlus);
        tracker.addCertification(ceh);
        tracker.addCertification(cissp);
        tracker.addCertification(aws);

        tracker.displayAll();

        tracker.updateStatus("CompTIA Security+", "Completed");
        tracker.displayAll();

        tracker.removeCertification("AWS Security Specialty");
        tracker.displayAll();

        // ── Feature 2: Study Material Tracker ────────────────────────────

        System.out.println("\n=== Feature 2: Study Material Tracker ===\n");

        tracker.addResource("CEH", new StudyResource("CEH Study Guide", "Book", "https://www.eccouncil.org"));
        tracker.addResource("CEH", new StudyResource("CEH Practice Labs", "Course", "https://www.udemy.com"));
        tracker.addResource("CISSP", new StudyResource("CISSP Official Study Guide", "Book", "https://www.isc2.org"));
        tracker.addResource("CISSP", new StudyResource("CISSP Video Course", "Video", "https://www.linkedin.com/learning"));

        tracker.getResourcesByCert("CEH");
        tracker.getResourcesByCert("CISSP");

        tracker.markResourceComplete("CEH", "CEH Study Guide");
        tracker.getResourcesByCert("CEH");

        tracker.removeResource("CISSP", "CISSP Video Course");
        tracker.getResourcesByCert("CISSP");

        // ── Feature 3: Study Goal Queue ───────────────────────────────────

        System.out.println("\n=== Feature 3: Study Goal Queue ===\n");

        Calendar goal1Date = Calendar.getInstance();
        goal1Date.set(2025, Calendar.MAY, 30);

        Calendar goal2Date = Calendar.getInstance();
        goal2Date.set(2025, Calendar.JULY, 15);

        Calendar goal3Date = Calendar.getInstance();
        goal3Date.set(2025, Calendar.AUGUST, 1);

        tracker.enqueueGoal(new Goal("Complete practice exams", "CEH", goal2Date, 3));
        tracker.enqueueGoal(new Goal("Finish study guide", "CISSP", goal3Date, 2));
        tracker.enqueueGoal(new Goal("Schedule exam date", "CEH", goal1Date, 5));

        tracker.displayQueue();
        tracker.peekNextGoal();
        tracker.dequeueGoal();
        tracker.displayQueue();

        // ── Feature 4: Completion History (Stack) ────────────────────────

        System.out.println("\n=== Feature 4: Completion History ===\n");

        tracker.displayHistory();
        tracker.peekHistory();
        tracker.popHistory();

        // ── Feature 5: Custom Sorting ─────────────────────────────────────

        System.out.println("\n=== Feature 5: Custom Sorting ===\n");

        System.out.println("Before sorting:");
        tracker.displayAll();

        tracker.sortByDifficulty();
        System.out.println("\nAfter sorting by difficulty:");
        tracker.displayAll();

        tracker.sortByExamDate();
        System.out.println("\nAfter sorting by exam date:");
        tracker.displayAll();
    }
}