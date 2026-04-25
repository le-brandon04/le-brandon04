package org.csu.cpsc.roadmap;

public class StudyResource {
    private String resourceName;
    private String resourceType; // "Video", "Book", "Course", "Article"
    private String url;
    private boolean completed;

    public StudyResource(String resourceName, String resourceType, String url) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.url = url;
        this.completed = false;
    }

    public String getResourceName() { return resourceName; }
    public String getResourceType() { return resourceType; }
    public String getUrl() { return url; }
    public boolean isCompleted() { return completed; }

    public void markComplete() { this.completed = true; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s",
                completed ? "✓" : " ", resourceName, resourceType, url);
    }
}