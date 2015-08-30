## Final Assessment
This is designed to run with Android Studio with
[Unit Testing support](https://sites.google.com/a/android.com/tools/tech-docs/unit-testing-support) enabled in Android Studio's Gradle settings.


### Importing
Import the project into Android Studio by selecting `Import Project` and selecting the project's `build.gradle`. When prompted, you can pick the default gradle wrapper.


### Running Tests
To run the test, open Android Studio's [Build Variants](https://sites.google.com/a/android.com/tools/tech-docs/unit-testing-support/qSxL68MPv5.png) pane and change the option `Test Artifact` to `Unit Tests`. You can then right click on `Unit1AndroidAssessmentTests` and run the tests.

Your run configuration should look like this:

> ![](static/run.configuration.png)


### Specs

#### 1. Pace Calculator

Create a Fragment using the provided layout `fragment_pace_calculator.xml`. Implement the following logic for the pace calculator:

* The user will input data for two of the three variables, distance, time, and pace. When the user presses "Calculate", the third variable will be calculated and filled in.
* If the user specifies data for zero, one, or all of the variables, do nothing.
* If the user specifies invalid data for any of the variables, do nothing.

#### 2. Roster

Create a list of students using a custom list adapter and the list of students provided in `ListActivity.java`. Each list item should use the provided layout `listitem_member.xml`. Implement the following functionality:

* The list should be sorted alphabetically.
* The upper right button toggles between "Last, First" and "First Last" (e.g. "Ravenclaw, Rowena" and "Rowena Ravenclaw"). The sort should reflect the current name display, meaning it should be sorted by last name in "Last, First" mode and by first name in "First Last" mode.
* The left button toggles the background color for each list item. When colors are shown, the background color should be the color specified for the student's house in `colors.xml`.
* Each of these should be stored as a preference, so that they are saved between runs of the app.

#### 3. Library System

* Create a SQLite database to hold the data in the two JSON files in `data/`. (Hint: look at book id 14 for a list of all the fields for a book.)
* Provide the implementations for the function stubs in `LibraryActivity.java`.
* When the user provides the parameter in the input box (either a name or an ISBN) and presses a button, call the corresponding function and show the results in the TextView. The format is specified below.

> <img src="static/library_memberinfo.png" width="400" />
> <img src="static/library_bookinfo.png" width="400" />
> <img src="static/library_checkedout.png" width="400" />
