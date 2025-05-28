/*
Kyle Reed
Prof. Huang
COS-210-300
14 April 2025
*/

// Job.java

// Represents Job with ID, length, and priority. Implements comparables for priority implementation
public class Job implements Comparable<Job> {
    private int jobId;
    private int length;
    private int priority;

    // Constructor
    public Job(int jobId, int length, int priority) {
        this.jobId = jobId;
        this.length = length;
        this.priority = priority;
    }

    // Gets jobs
    public int getJobId() { return jobId; }
    public int getLength() { return length; }
    public int getPriority() { return priority; }

    // Compares jobs by priority (lower integer = higher priority)
    @Override
    public int compareTo(Job other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return jobId + " " + length + " " + priority;
    }
}
