/*
Kyle Reed
Prof. Huang
COS-210-300
14 April 2025
*/


// JobScheduler.java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

//JobScheduler can read jobs.txt file and process in order of their priorities

public class JobScheduler {
    public static void main(String[] args) {
        // PriorityQueue to sort by priority
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();

        try {
            File file = new File("jobs.txt");
            Scanner scanner = new Scanner(file);

            // Reads each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Skips empty lines
                if (line.isEmpty()) continue;

                // Splits line into parts
                String[] parts = line.split("\\s+");  // can handle many spaces

                // Parses values
                int id = Integer.parseInt(parts[0]);
                int length = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);

                // Creates a Job object and adds to the queue
                Job job = new Job(id, length, priority);
                jobQueue.add(job);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File is not found: jobs.txt");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Error parsing job data.");
            return;
        }

        // Starts simulation
        int currentTime = 0;

        // Prints out header
        System.out.println("jobID length priority completionTime");

        // Process jobs based on priority
        while (!jobQueue.isEmpty()) {
            Job job = jobQueue.poll(); // Gets the job with highest priority
            currentTime += job.getLength(); // Adds the job length to current time
            System.out.printf("%d %d %d %d\n", job.getJobId(), job.getLength(), job.getPriority(), currentTime);
        }
    }
}