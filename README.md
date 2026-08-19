# Java Core Exercises

A collection of introductory Java Core exercises with JUnit 5 tests.

The repository contains several training task sets covering language basics, operators, conditional statements, loops and small console-oriented programs. The source code is intentionally organized by the original course packages so that each exercise remains easy to compare with its task and tests.

## Project structure

- `src/main/java/com/it/academy/gd/jc1` — introductory exercises, operators and decision-making statements;
- `src/main/java/com/it/academy/md/jc1` — additional introductory, operators and statements exercises;
- `src/main/java/com/it/academy/gk/sc0` — homework, operators and looping/statement tasks;
- `src/test/java` — JUnit 5 and Mockito tests mirroring the production packages.

## Requirements

- Java 17;
- no global Gradle installation is required because the repository includes the Gradle Wrapper.

## Run the tests

Linux/macOS:

```bash
./gradlew clean test
```

Windows:

```bat
gradlew.bat clean test
```

## Build

```bash
./gradlew clean build
```

## Completed cleanup

The repository includes fixes for previously unfinished exercises and stronger edge-case coverage, including:

- Russian ruble word-form selection;
- next-day calculation across month, leap-year and year boundaries;
- validation of negative game-session time;
- restored tests for the interactive square exercise;
- deterministic numeric formatting where output is asserted.

## Continuous integration

GitHub Actions runs the full Gradle build on Java 17 for pushes and pull requests targeting `master`.
