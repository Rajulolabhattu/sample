# Sample Java Web Application

This is a simple Java web application that demonstrates:

1. Maven-based project structure and build
2. MVC architecture (Model-View-Controller)
3. JUnit testing with the JUnit 5 framework
4. WAR file packaging for Tomcat deployment

## Project Structure

- `src/main/java` - Java source code
- `src/main/webapp` - Web resources (JSPs, web.xml, etc.)
- `src/test/java` - Test source code
- `pom.xml` - Maven build configuration

## Building the Project

To build the project, run:

```bash
mvn clean package
```

This will:
1. Compile the Java source code
2. Run the JUnit tests
3. Package the application as a WAR file at `target/sample-webapp.war`

## Running the Tests

To run just the tests:

```bash
mvn test
```

## Deploying to Tomcat

After building the WAR file, you can deploy it to Tomcat by:

1. Copying `target/sample-webapp.war` to Tomcat's `webapps` directory
2. Starting Tomcat if it's not already running

Once deployed, you can access the application at:
`http://localhost:8080/sample-webapp/`

## Features

- Create personalized greeting messages
- View a list of all greetings
- View details of individual greetings
- Delete unwanted greetings

## Technology Stack

- Java 11
- Servlet API 4.0
- JSP and JSTL
- JUnit 5 for testing
- Maven for building
- Bootstrap 5 for styling