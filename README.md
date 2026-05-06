# Cybersecurity Learning Roadmap Tracker

A Java-based application for tracking progress through cybersecurity certifications and learning goals.

## Overview

The Cybersecurity Learning Roadmap Tracker helps users organize and manage their cybersecurity certification journey. It demonstrates the use of core data structures including List, Map, Queue, Stack, and a custom sorting algorithm with Comparable.

## Features

1. **Certification Manager (List)** — Add, remove, update, and display certifications
2. **Study Material Tracker (Map)** — Map study resources to certifications
3. **Study Goal Queue (PriorityQueue)** — Manage study goals by priority
4. **Completion History (Stack)** — Track completed certifications with undo support
5. **Custom Sorting (Comparable)** — Sort certifications by difficulty or exam date

## How to Run

### Prerequisites
- Java 21
- Gradle

### Steps

1. Clone the repository
git clone https://github.com/le-brandon04/le-brandon04.git
cd le-brandon04

2. Build the project
./gradlew clean build -x test

3. Run the application
./gradlew run

## Project Structure
app/src/main/java/org/csu/cpsc/roadmap/
├── Main.java               # Entry point
├── RoadmapTracker.java     # Core tracker logic
├── Certification.java      # Certification custom object
├── StudyResource.java      # Study resource custom object
└── Goal.java               # Study goal custom object

## Data Structures Used

| Feature | Data Structure |
|---------|----------------|
| Certification Manager | ArrayList |
| Study Material Tracker | HashMap |
| Study Goal Queue | PriorityQueue |
| Completion History | Stack |
| Sorting | Custom Insertion Sort with Comparable |

## Author

Brandon — Columbus State University, CPSC 2108
