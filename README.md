# Spring Boot JTE Production

## Description

This project is a Spring Boot application that utilizes the JTE (Java Template Engine) library for templating. This project demonstrates how to properly deploy a Spring Boot application using JTE (Java Template Engine) templates to production

## Features

* Spring Boot 3.4.3
* JTE 3.1.16
* Spring Boot Starter Web

## Requirements

* Java 23
* Maven

## Development vs Production

### Development Mode

During development, JTE runs in development mode, which:
- Reloads templates on every request
- Provides detailed error messages
- Doesn't require precompilation

```properties
# application.properties
spring.application.name=jte-production
gg.jte.development-mode=true
```

### Production Mode

In production, JTE should:
- Use precompiled templates
- Disable development features
- Enable template caching

```properties
# application-prod.properties
gg.jte.developmentMode=false
gg.jte.usePrecompiledTemplates=true
logging.level.org.springframework.web=DEBUG
logging.level.gg.jte=DEBUG
```

## Building for Production

### Step 1: Precompiling Templates

Before building your production JAR, you need to precompile your JTE templates. This process:
- Converts templates to Java classes
- Improves runtime performance
- Reduces startup time
- Ensures template validity at build time

The precompiled templates will be generated in the `jte-classes` directory, as seen in this project's structure with `JteindexGenerated.java`.

### Step 2: Building the JAR

When building the JAR, ensure:
1. Templates are precompiled
2. Production properties are active
3. Precompiled classes are included in the build

## Installation

To install the project, simply clone the repository and run the following command:


```bash
mvn clean 
# First, precompile templates
mvn compile
# Then build with production profile
mvn package -Pprod
```
## Running the Application

To run the application, execute the following command:

```bash
java -jar -Dspring.profiles.active=prod ./target/spring-boot-jte-production-1.0.0.jar
``` 
## Accessing the Application

The application can be accessed at http://localhost:8080 

----
