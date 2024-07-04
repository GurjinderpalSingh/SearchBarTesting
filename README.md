# SearchBar Project

## Project Structure

### Maven Configuration
- **pom.xml**: Maven configuration file for managing dependencies and build configuration.

### page object classes at src/main/java/org.veeve.pages
- **Homepage.java**: Java page class containing locators and methods for homepage
- **SearchResults.java**: Java page class containing locators and methods for Search results.

### Cucumber Feature and Step Definitions
- **searchBar.feature**: Cucumber feature file describing the search bar test scenarios at src/test/resources/features
- **searchBarstepdef.java**: Java class containing step definitions for the search bar feature at src/test/java/org.veeva.stepdefination
- **Hooks.java**: Java class containing  set up and tearing down methods at src/test/java/org.veeva.stepdefination

### Test Runner
- **TestRunner.java**: Java class for executing Cucumber tests.

## Instructions to Run

## Using an IDE

You can also use an Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse to run and manage the project.

1. **Import the project**:
    - Open your IDE (IntelliJ IDEA, Eclipse, etc.).
    - Import the project as a Maven project.

2. **Build the project**:
    - Let the IDE download the necessary dependencies and build the project.

3. **Run tests**:
    - Navigate to the `TestRunner.java` file.
    - Right-click on the file and select the option to run the tests.

## or

1. **Clone the repository**:
    ```sh
    git clone <repository_url>
    cd SearchBar
    ```

2. **Install dependencies**:
    Make sure you have Maven installed.

    ```sh
    mvn clean install
    ```

3. **Run the tests**:
    Execute the following command to run the Cucumber tests:

    ```sh
    mvn test
    ```

4. **View test results**:
    After running the tests, you can find the test results in the `target/cucumber-reports.html` file.
    you might need to rename file as .html to open as webpage.
   Also, the report is published to cucumber cloud and you can find the url for report in the output once test are executed.


## Additional Information

- Ensure that you have Java Development Kit (JDK) installed.
