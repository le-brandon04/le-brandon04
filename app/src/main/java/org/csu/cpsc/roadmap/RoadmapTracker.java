package org.csu.cpsc.roadmap;

import java.util.*;

public class RoadmapTracker {

    // Feature 1: List — stores all certifications
    private List<Certification> certifications;

    // Feature 2: Map — maps certification name to study resources
    private Map<String, List<StudyResource>> studyMaterials;

    // Feature 3: Queue — manages upcoming study goals by priority
    private PriorityQueue<Goal> studyQueue;

    // Feature 4: Stack — tracks completed certifications
    private Stack<Certification> completionHistory;

    public RoadmapTracker() {
        certifications = new ArrayList<>();
        studyMaterials = new HashMap<>();
        studyQueue = new PriorityQueue<>();
        completionHistory = new Stack<>();
    }

    // ── Feature 1: Certification Manager ─────────────────────────────────

    public void addCertification(Certification cert) {
        certifications.add(cert);
        studyMaterials.put(cert.getName(), new ArrayList<>());
        System.out.println("Added certification: " + cert.getName());
    }

    public void removeCertification(String name) {
        certifications.removeIf(c -> c.getName().equals(name));
        studyMaterials.remove(name);
        System.out.println("Removed certification: " + name);
    }

    public void updateStatus(String name, String status) {
        for (Certification c : certifications) {
            if (c.getName().equals(name)) {
                c.setStatus(status);
                System.out.println("Updated status for " + name + " to: " + status);

                // If completed, push to history stack
                if (status.equals("Completed")) {
                    completionHistory.push(c);
                    System.out.println(name + " pushed to completion history.");
                }
                return;
            }
        }
        System.out.println("Certification not found: " + name);
    }

    public void displayAll() {
        System.out.println("\n=== All Certifications ===");
        if (certifications.isEmpty()) {
            System.out.println("No certifications found.");
            return;
        }
        for (int i = 0; i < certifications.size(); i++) {
            System.out.println((i + 1) + ". " + certifications.get(i));
        }
    }

    // ── Feature 2: Study Material Tracker ────────────────────────────────

    public void addResource(String certName, StudyResource resource) {
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found: " + certName);
            return;
        }
        studyMaterials.get(certName).add(resource);
        System.out.println("Added resource '" + resource.getResourceName() + "' to " + certName);
    }

    public void removeResource(String certName, String resourceName) {
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found: " + certName);
            return;
        }
        studyMaterials.get(certName).removeIf(r -> r.getResourceName().equals(resourceName));
        System.out.println("Removed resource '" + resourceName + "' from " + certName);
    }

    public void markResourceComplete(String certName, String resourceName) {
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found: " + certName);
            return;
        }
        for (StudyResource r : studyMaterials.get(certName)) {
            if (r.getResourceName().equals(resourceName)) {
                r.markComplete();
                System.out.println("Marked '" + resourceName + "' as complete.");
                return;
            }
        }
        System.out.println("Resource not found: " + resourceName);
    }

    public void getResourcesByCert(String certName) {
        System.out.println("\n=== Study Resources for " + certName + " ===");
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found.");
            return;
        }
        List<StudyResource> resources = studyMaterials.get(certName);
        if (resources.isEmpty()) {
            System.out.println("No resources found.");
            return;
        }
        for (StudyResource r : resources) {
            System.out.println(r);
        }
    }

    // ── Feature 3: Study Goal Queue ───────────────────────────────────────

    public void enqueueGoal(Goal goal) {
        studyQueue.add(goal);
        System.out.println("Enqueued goal: " + goal.getGoalName());
    }

    public void dequeueGoal() {
        if (studyQueue.isEmpty()) {
            System.out.println("No goals in queue.");
            return;
        }
        Goal goal = studyQueue.poll();
        System.out.println("Dequeued goal: " + goal.getGoalName());
    }

    public void peekNextGoal() {
        if (studyQueue.isEmpty()) {
            System.out.println("No goals in queue.");
            return;
        }
        System.out.println("Next goal: " + studyQueue.peek());
    }

    public void displayQueue() {
        System.out.println("\n=== Study Goal Queue ===");
        if (studyQueue.isEmpty()) {
            System.out.println("No goals in queue.");
            return;
        }
        PriorityQueue<Goal> copy = new PriorityQueue<>(studyQueue);
        int count = 1;
        while (!copy.isEmpty()) {
            System.out.println(count++ + ". " + copy.poll());
        }
    }

    // ── Feature 4: Completion History (Stack) ────────────────────────────

    public void pushToHistory(Certification cert) {
        completionHistory.push(cert);
        System.out.println("Pushed to history: " + cert.getName());
    }

    public void popHistory() {
        if (completionHistory.isEmpty()) {
            System.out.println("No history to undo.");
            return;
        }
        Certification cert = completionHistory.pop();
        System.out.println("Removed from history: " + cert.getName());
    }

    public void peekHistory() {
        if (completionHistory.isEmpty()) {
            System.out.println("No completion history.");
            return;
        }
        System.out.println("Most recently completed: " + completionHistory.peek());
    }

    public void displayHistory() {
        System.out.println("\n=== Completion History ===");
        if (completionHistory.isEmpty()) {
            System.out.println("No completions yet.");
            return;
        }
        Stack<Certification> copy = new Stack<>();
        copy.addAll(completionHistory);
        int count = 1;
        while (!copy.isEmpty()) {
            System.out.println(count++ + ". " + copy.pop());
        }
    }

    // ── Feature 5: Custom Insertion Sort by Difficulty ───────────────────

    public void sortByDifficulty() {
        for (int i = 1; i < certifications.size(); i++) {
            Certification key = certifications.get(i);
            int j = i - 1;
            while (j >= 0 && certifications.get(j).compareTo(key) > 0) {
                certifications.set(j + 1, certifications.get(j));
                j--;
            }
            certifications.set(j + 1, key);
        }
        System.out.println("Certifications sorted by difficulty.");
    }

    public void sortByExamDate() {
        for (int i = 1; i < certifications.size(); i++) {
            Certification key = certifications.get(i);
            int j = i - 1;
            while (j >= 0 && certifications.get(j).getExamDate().compareTo(key.getExamDate()) > 0) {
                certifications.set(j + 1, certifications.get(j));
                j--;
            }
            certifications.set(j + 1, key);
        }
        System.out.println("Certifications sorted by exam date.");
    }
}