# SauceLabs Tests Java

## About
This repo is an example of a test project for [SauceLabs](https://www.saucedemo.com/) web app.

The tech stack is:

* Java
* Maven
* TestNG
* Playwright

This project follows [Google Java Style](https://google.github.io/styleguide/javaguide.html). 

## Requirements
* [JDK 17+](https://www.oracle.com/java/technologies/downloads/)
* [Maven](https://maven.apache.org/download.cgi?.)

## Usage
Simply clone the repo and run tests with **Maven** CLI command:
> mvn test -e

Where `-e` is the flag that enables error tracing.

For code linting, use:
> mvn com.spotify.fmt:fmt-maven-plugin:check -Dmaven.plugin.validation=VERBOSE

For code formatting, use:
> mvn com.spotify.fmt:fmt-maven-plugin:format
