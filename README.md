# Time Travel Paradox Simulator

A Java 17 console simulation about changing fictional history, following the consequences, and deciding whether a fragile timeline is worth saving. Every historical intervention creates a branch, so the original history remains available for comparison.

## Concept

The player is a time traveler moving through a fictional 2000–2050 history. Travel consumes temporal energy; past jumps and event changes raise paradox pressure. A rule based consequence engine translates each intervention into changes to timeline metrics, while the paradox engine estimates stability and causality risk.

## Features

- Branching timeline tree with parent relationships and preserved original histories
- Eleven fictional historical events across technology, economy, science, society, space, and environment
- Six event interventions: prevent, delay, accelerate, change outcome, increase impact, and decrease impact
- Chained consequences with domains, effect sizes, and depth
- Time travel limits, energy costs, paradox and stability analysis, and recovery actions
- Compare metrics across any two timelines
- Seeded random-event outcomes, save/load/list/delete service, simulation statistics, and achievements
- Validated console input and friendly error handling

## Technology

Java 17, Maven, Java Time API, Java collections, and JUnit 5 for tests. Runtime persistence uses Java object serialization with a depth/reference input filter; no database or runtime library dependency is required.

## Architecture

`model` contains serializable simulation entities and enums. `engine` holds the timeline, time travel, consequence, paradox, catalog, and random-event rules. `service` coordinates simulation actions, save files, and achievements. `ui.ConsoleUI` owns console prompts and rendering; `Main` starts it. The service layer keeps rule changes independent of console interaction.

## How it works

Start a simulation with a seed or accept a random seed. Travel to an event's year before changing it. The simulator copies the active timeline into a child branch, applies the intervention and its consequence chain, then updates paradox and stability. Switch between branches by entering their IDs in comparison and inspect their lineage in the tree view. Save files are written to `saves/` in the working directory.

## Requirements and setup

- JDK 17 or newer
- Maven 3.8 or newer

```bash
git clone <repository-url>
cd time-travel-paradox-simulator
mvn clean test
mvn clean package
java -jar target/time-travel-paradox-simulator-1.0.0.jar
```

Run directly with Maven using `mvn exec:java -Dexec.mainClass=com.timetravel.Main` if the Maven Exec plugin is already available; the packaged executable JAR is the dependency-free launch option.

## Example session

```text
============================================================
             TIME TRAVEL PARADOX SIMULATOR
============================================================
 Timeline T-001 | Year 2026 | Stability 100% | Paradox 0 | Energy 100%
 1. Start New Simulation
 4. Time Travel
 5. Modify Historical Event
 7. Analyze Paradox
```

After traveling to 2032 and accelerating the AI Breakthrough, the simulator creates a child timeline and reports consequences such as productivity, education demand, and energy demand, along with the new paradox score.

## Project structure

```text
src/
  main/java/com/timetravel/
    Main.java
    engine/       # domain rules and event catalog
    model/        # events, timelines, changes, metrics, state
    service/      # simulation coordination, persistence, achievements
    ui/           # interactive console
  test/java/com/timetravel/SimulationTest.java
pom.xml
README.md
.gitignore
```

## Screenshots

Add terminal screenshots here after running the application in your preferred console.

## Future improvements

- Add a richer dependency graph for event-to-event consequence propagation
- Add timeline selection as a dedicated menu action and richer branch comparison
- Add schema-versioned human-readable save exports
- Expand scenario packs and configurable simulation rules

## Author

Project by **[Your Name]**. Replace this line with your GitHub profile before publishing.

## GitHub upload

```bash
git init
git add .
git commit -m "Build Time Travel Paradox Simulator"
git branch -M main
git remote add origin https://github.com/<username>/time-travel-paradox-simulator.git
git push -u origin main
```
