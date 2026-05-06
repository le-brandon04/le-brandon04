package org.csu.cpsc.roadmap;

import java.util.*;

/**
 * Manages the Cybersecurity Learning Roadmap Tracker.
 * Provides functionality for managing certifications, study materials,
 * study goals, completion history, and sorting.
 */
public class RoadmapTracker {

    /** List of all certifications being tracked. */
    private List<Certification> certifications;

    /** Map of certification names to their associated study resources. */
    private Map<String, List<StudyResource>> studyMaterials;

    /** Priority queue of upcoming study goals ordered by priority. */
    private PriorityQueue<Goal> studyQueue;

    /** Stack tracking completed certifications in order of completion. */
    private Stack<Certification> completionHistory;

    /**
     * Constructs a new RoadmapTracker with empty data structures.
     */
    public RoadmapTracker() {
        certifications = new ArrayList<>();
        studyMaterials = new HashMap<>();
        studyQueue = new PriorityQueue<>();
        completionHistory = new Stack<>();
    }

    // ── Feature 1: Certification Manager ─────────────────────────────────

    /**
     * Adds a certification to the tracker.
     *
     * @param cert the Certification to add
     */
    public void addCertification(Certification cert) {
        certifications.add(cert);
        studyMaterials.put(cert.getName(), new ArrayList<>());
        System.out.println("Added certification: " + cert.getName());
    }

    /**
     * Removes a certification from the tracker by name.
     *
     * @param name the name of the certification to remove
     */
    public void removeCertification(String name) {
        certifications.removeIf(c -> c.getName().equals(name));
        studyMaterials.remove(name);
        System.out.println("Removed certification: " + name);
    }

    /**
     * Updates the status of a certification.
     * If the status is set to Completed, the certification is pushed to the history stack.
     *
     * @param name   the name of the certification to update
     * @param status the new status
     */
    public void updateStatus(String name, String status) {
        for (Certification c : certifications) {
            if (c.getName().equals(name)) {
                c.setStatus(status);
                System.out.println("Updated status for " + name + " to: " + status);
                if (status.equals("Completed")) {
                    completionHistory.push(c);
                    System.out.println(name + " pushed to completion history.");
                }
                return;
            }
        }
        System.out.println("Certification not found: " + name);
    }

    /**
     * Displays all certifications currently being tracked.
     */
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

    /**
     * Adds a study resource to a certification.
     *
     * @param certName the name of the certification
     * @param resource the StudyResource to add
     */
    public void addResource(String certName, StudyResource resource) {
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found: " + certName);
            return;
        }
        studyMaterials.get(certName).add(resource);
        System.out.println("Added resource '" + resource.getResourceName() + "' to " + certName);
    }

    /**
     * Removes a study resource from a certification.
     *
     * @param certName     the name of the certification
     * @param resourceName the name of the resource to remove
     */
    public void removeResource(String certName, String resourceName) {
        if (!studyMaterials.containsKey(certName)) {
            System.out.println("Certification not found: " + certName);
            return;
        }
        studyMaterials.get(certName).removeIf(r -> r.getResourceName().equals(resourceName));
        System.out.println("Removed resource '" + resourceName + "' from " + certName);
    }

    /**
     * Marks a study resource as complete.
     *
     * @param certName     the name of the certification
     * @param resourceName the name of the resource to mark complete
     */
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

    /**
     * Displays all study resources for a given certification.
     *
     * @param certName the name of the certification
     */
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

    /**
     * Adds a study goal to the priority queue.
     *
     * @param goal the Goal to enqueue
     */
    public void enqueueGoal(Goal goal) {
        studyQueue.add(goal);
        System.out.println("Enqueued goal: " + goal.getGoalName());
    }

    /**
     * Removes and displays the highest priority goal from the queue.
     */
    public void dequeueGoal() {
        if (studyQueue.isEmpty()) {
            System.out.println("No goals in queue.");
            return;
        }
        Goal goal = studyQueue.poll();
        System.out.println("Dequeued goal: " + goal.getGoalName());
    }

    /**
     * Displays the next goal in the queue without removing it.
     */
    public void peekNextGoal() {
        if (studyQueue.isEmpty()) {
            System.out.println("No goals in queue.");
            return;
        }
        System.out.println("Next goal: " + studyQueue.peek());
    }

    /**
     * Displays all goals in the queue in priority order.
     */
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

    /**
     * Pushes a certification onto the completion history stack.
     *
     * @param cert the Certification to push
     */
    public void pushToHistory(Certification cert) {
        completionHistory.push(cert);
        System.out.println("Pushed to history: " + cert.getName());
    }

    /**
     * Removes the most recently completed certification from the history stack.
     */
    public void popHistory() {
        if (completionHistory.isEmpty()) {
            System.out.println("No history to undo.");
            return;
        }
        Certification cert = completionHistory.pop();
        System.out.println("Removed from history: " + cert.getName());
    }

    /**
     * Displays the most recently completed certification without removing it.
     */
    public void peekHistory() {
        if (completionHistory.isEmpty()) {
            System.out.println("No completion history.");
            return;
        }
        System.out.println("Most recently completed: " + completionHistory.peek());
    }

    /**
     * Displays all completed certifications in the history stack.
     */
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

    // ── Feature 5: Custom Insertion Sort ─────────────────────────────────

    /**
     * Sorts all certifications by difficulty level in ascending order
     * using a custom insertion sort algorithm.
     */
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

    /**
     * Sorts all certifications by exam date in ascending order
     * using a custom insertion sort algorithm.
     */
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