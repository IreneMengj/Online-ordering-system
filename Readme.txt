* Note that I am using Mac and IntelliJ, so this document primarily focuses on explaining the project setup in this environment.

Instructions on project files

In the project folder, you'll find "src" and "target" directories, plus important files like pom.xml, db_reggie.sql, and Readme.txt. There are also CICD configuration files.

In the "target" folder, there is DeliverEase-1.0-SNAPSHOT.jar for the whole project.

In the "src" folder of the project, there are two primary directories: "java" and "resources."

Under the "java" directory, you'll discover folders labeled "mapper," "entity," "service," and "controller."
These folders are predominantly utilized for retrieving frontend data, internal processing, and interfacing with the database.
The "Common" folder (within the "java" directory) contains shared code, including a global exception handler.
The "Filter" folder (within the "java" directory) is primarily employed for login checks to prevent unauthorized access to post-login functionalities.
The "Config" folder (within the "java" directory) is designated for configuring various aspects of the Spring Boot project.

Under the "resources" directory, you'll locate pages for both the mobile application and the system management backend.



Development environment construction

1. Install the following software:
    JDK8
    Redis
    Mysql
    Maven
    Intellij (recommended IDE）

2. Set up the database environment

    Locate the db_reggie.sql file within the reggie_take_out folder and proceed to import the SQL file using the Mac terminal,
    as illustrated below:

    1. Open the terminal application.
    2. Use the following command to log in to your MySQL database (if MySQL is already installed and configured):
       mysql -u your_username -p
       * Replace your_username with your MySQL username and press Enter.
    3. Enter your MySQL password and press Enter to log in to MySQL.
    4. Use the following command to create database first:
       CREATE DATABASE reggie;
    5. Exit the MySQL
    6. Use the following command to import db_reggie.sql:
        mysql -u your_username -p reggie < /path/to/db_reggie.sql
    * Replace your_username with your MySQL username, and /path/to/db_reggie.sql with the full path to the db_reggie.sql file.
    7. Enter your MySQL password and press Enter to start the import process.


3. Open the project in IntelliJ IDEA
    1. Set JDK version 8 in Project Structure.
    2. Configure Maven in IntelliJ IDEA by navigating to Preferences->
    Build, Execution, Deployment->Build Tools->Maven.
    3. Wait for Maven dependencies to download.
    4. Modify `application.yml` file:
        1. Modify the MySQL `username` and `password` in lines 11 and 12 of the `application.yml` file located in the `src/main/resources` folder with your MySQL username and password.
        2. According to your own needs, modify the Redis database number on line 15.



Two ways to run this project(Please choose one of them):

First, start redis in the backend. Use redis-server and redis-cli to start redis separately. Switch to your database defined in the application.yml.


1. Run DeliverEase-1.0-SNAPSHOT.jar under target/DeliverEase-1.0-SNAPSHOT.jar


2. Start DeliverEaseApplication.java under src/main/java/com/itheima/reggie

    1. System management background: localhost:8080/backend/index.html
        Login steps:
        Username & password displayed, click login.
        username: admin
        password: 123456

    2. Mobile application: localhost:8080/front/index.html
        Login steps:
        Enter phone: 18508295860
        Click Request code button
        Wait for the code to appear in the corresponding location
        Click login to proceed
    * Note: The mobile application interface is optimized for mobile devices.
    Please utilize developer tools to simulate a mobile browser on the computer for optimal viewing.
    * If there is "java.lang.NullPointerException: null" when using mobile application, please check Redis status.
    Always need to start Redis before this project

