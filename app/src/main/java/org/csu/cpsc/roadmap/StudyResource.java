package org.csu.cpsc.roadmap;

/**
 * Represents a study resource associated with a cybersecurity certification.
 */
public class StudyResource {

    /** The name of the study resource. */
    private String resourceName;

    /** The type of the resource (e.g. Video, Book, Course, Article). */
    private String resourceType;

    /** The URL where the resource can be accessed. */
    private String url;

    /** Whether the resource has been completed. */
    private boolean completed;

    /**
     * Constructs a new StudyResource with the specified details.
     *
     * @param resourceName the name of the resource
     * @param resourceType the type of the resource
     * @param url          the URL of the resource
     */
    public StudyResource(String resourceName, String resourceType, String url) {
        this.resourceName = resourceName;
        this.resourceType = resourceType;
        this.url = url;
        this.completed = false;
    }

    /**
     * Returns the name of the resource.
     * @return the resource name
     */
    public String getResourceName() { return resourceName; }

    /**
     * Returns the type of the resource.
     * @return the resource type
     */
    public String getResourceType() { return resourceType; }

    /**
     * Returns the URL of the resource.
     * @return the resource URL
     */
    public String getUrl() { return url; }

    /**
     * Returns whether the resource has been completed.
     * @return true if completed, false otherwise
     */
    public boolean isCompleted() { return completed; }

    /**
     * Marks the resource as completed.
     */
    public void markComplete() { this.completed = true; }

    /**
     * Returns a string representation of the study resource.
     *
     * @return formatted string with completion status, name, type, and URL
     */
    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s",
                completed ? "✓" : " ", resourceName, resourceType, url);
    }
}