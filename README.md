<p align = "center">
  <img src = "ReadmeResources/GAME.gif" width = "1920" height = "500" alt="LogoInsert"> 
</p>

# CRISIS COMPASS - Disaster Preparation Assistant

## Table of Contents
-  [1. Program Overview](#proj-over)
-  [2. Implementation of OOP Principles](#oop)
-  [3. Sustainable Development Goal Integration](#sdg)
-  [4. How to Run](#run) 
-  [5. Contributor](#contrib) 

## <a id="proj-over"> 📖 Overview of the Program </a> <br>

Crisis Compass is a feature-rich, console-based application designed to equip users with essential tools for effective disaster management. It offers a seamless and intuitive interface paired with robust functionalities, including emergency inventory management, detailed disaster tips for all scenarios (before, during, after, and emergency situations), help request handling, and real-time disaster tracking through government resources.  

Developed using object-oriented programming (OOP) principles, Crisis Compass ensures modularity, scalability, and maintainability. This comprehensive solution enhances community resilience and disaster preparedness, providing users with reliable support for both readiness and response efforts in times of crisis.  
<br><br>

## 🎯 Main Features

1. **Disaster Inventory Management** <br><br>
   - Allows users to manage an emergency inventory for disaster preparedness. <br>
   - Displays all available inventory items and categorizes them for specific disaster types. <br>
   - Highlights missing essential items and provides related tips. <br><br>

2. **Comprehensive Disaster Tips**<br><br>
   - Provides actionable tips for various disasters, categorized into: <br>
     - Before the disaster. <br>
     - During the disaster. <br>
     - After the disaster. <br>
     - Emergency situations. <br>
   - Tips are dynamically sourced and displayed based on disaster type and category. <br><br>

3. **Help Request Handling** <br><br>
   - Enables users to create, view, and manage help requests. <br>
   - Tracks the status of help requests (e.g., PENDING, IN_PROGRESS, RESOLVED). <br>
   - Allows retrieval of user-specific help request history. <br><br>

4. **Disaster Tracking** <br><br>
   - Provides real-time disaster tracking through links to authoritative government websites (e.g.,PAGASA, PHIVOLCS). <br>
   - Includes a user-friendly guide on how to utilize these resources effectively. <br><br>

 
## <a id = "oop"> 📈 Implementation of OOP Principles </a><br>

**OOP PRINCIPLES**<br>

### 1. Encapsulation  
Encapsulation is implemented by organizing data and behavior into well-defined classes.  
- Classes like `User`, `HelpRequest`, and `InventoryItem` encapsulate their fields (e.g., `username`, `description`, `itemId`) and provide controlled access through getters and setters.  
- UI classes, such as `HelpRequestUI` and `InventoryUI`, use structured methods like `displayHelpRequestMenu()` and `displayInventoryMenu()` to interact with these data classes. This ensures that users interact only with high-level functionalities while the internal logic remains hidden.  

### 2. Abstraction  
Abstraction is achieved by separating implementation details from their usage.  
- The `Disaster` abstract class defines common methods (`getName()`, `fetchTipsByCategory()`) and attributes shared across disaster types, while disaster-specific subclasses (e.g., `Flood`, `Earthquake`) implement unique behavior.  
- UI classes (`MainMenu`, `TrackDisasterUI`, etc.) abstract database interactions and underlying logic, offering users a simple interface for disaster management functionalities.  

### 3. Inheritance  
Inheritance is employed in the `disasters` package.  
- The `Disaster` abstract class serves as a parent class for specific disaster types such as `Flood`, `Drought`, and `Earthquake`, etc.  
- These subclasses inherit shared attributes like `name` and `description` while enabling disaster-specific implementations, ensuring code reusability and simplifying the addition of new disaster types.  

### 4. Polymorphism  
Polymorphism allows methods to behave differently depending on the object type.  
- The `fetchTipsByCategory()` method dynamically retrieves disaster-specific tips based on whether it is called by an instance of `Flood`, `Typhoon`, or another subclass.  
- The system supports consistent workflows while enabling disaster-specific behavior through the use of `Disaster` subclasses.  

This effective integration of OOP principles ensures that **Crisis Compass** is modular, maintainable, and scalable.
<br><br>

## <a id = "sdg"> 🌍 Sustainable Development Goal Integration </a><br>

### **SDG 11: Sustainable Cities and Communities**  
The **Crisis Compass** project contributes to building more resilient and sustainable communities by equipping individuals with essential tools for disaster preparedness and mitigation.  
- **Disaster Tracking** and **Inventory Management** functionalities enable users to respond effectively to crises, promoting safer environments.  
- By fostering community preparedness, the project directly supports the creation of resilient cities and communities, reducing the risks of disasters and enhancing recovery capabilities.  

### **SDG 13: Climate Action**  
This project actively contributes to combating climate change by addressing the growing challenges posed by climate-related disasters.  
- **Real-time Disaster Tracking** and **Comprehensive Disaster Tips** help users stay informed and prepared for climate-related hazards such as floods, droughts, and typhoons.  
- The project encourages adaptive and proactive climate action by providing users with practical disaster preparedness tips and solutions, ensuring enhanced resilience to climate impacts.
<br><br>


## <span style="color: black;" id="run">📥 How to Run</span>

### Prerequisites

1. **Java Development Kit (JDK)**
   - Install [JDK 17 or higher](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **MySQL Database Server**
   - Install [MySQL Server 8 or higher](https://dev.mysql.com/downloads/mysql/).

3. **Dependencies**
   - Ensure the following JAR files are included in the `lib` folder of the project:
     - `mysql-connector-j-9.0.0.jar` (for MySQL connectivity)
     - `jbcrypt-0.4.jar` (for password hashing and security)

### Steps to Run

#### 1. Clone the Repository
Clone the Crisis Compass project from GitHub:
```bash
git clone https://github.com/Paul-Raimiel-Gonda/CRISIS-COMPASS.git
```

#### 2. Database Setup
1. Open the `init.sql` file in the project directory and execute it in your MySQL environment to initialize the database.
2. Update the `DatabaseConnection` class with your database credentials:
   ```properties
   db.url=jdbc:mysql://localhost:3306/your_database
   db.user=your_username
   db.password=your_password
   ```

#### 3. Open the Project in IntelliJ IDEA
1. Open IntelliJ IDEA and load the project directory.
2. Navigate to `src/main/java` and locate the `MainApp.java` file.
3. Run the program by clicking the "Run" button or pressing `Shift + F10`.

#### 4. Build and Run via Maven (OPTIONAL)
1. Navigate to the project directory in your terminal.
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the program:
   ```bash
   mvn exec:java -Dexec.mainClass="CrisisCompassCLIver"

   ```

---

## 📂 Project Structure

```plaintext

DIRECTORY

├── lib                                   # Required libraries
│   ├── jbcrypt-0.4.jar
│   ├── mysql-connector-j-9.0.0.jar
│
├── db
│   ├── init.sql                          # init file for database
│
├── src                                   # Source code directory
│   ├── database                          # Contains database connection logic
│   │   └── DatabaseConnection.java
│   ├── disasters                         # Contains disaster classes (abstract class and specific types)
│   │   ├── Disaster.java
│   │   ├── Drought.java
│   │   ├── Earthquake.java
│   │   ├── Flood.java
│   │   ├── Typhoon.java
│   │   └── VolcanicEruption.java
│   ├── models                            # Contains models representing database entities    
│   │   ├── DisasterTip.java
│   │   ├── HelpRequest.java
│   │   ├── InventoryItem.java
│   │   ├── PredefinedInventoryItem.java
│   │   └── User.java
│   ├── services                          # Contains logic and service classes
│   │   ├── DisasterTipService.java
│   │   ├── HelpRequestService.java
│   │   ├── InventoryService.java
│   │   └── UserService.java
│   ├── ui                                # User interface classes for console-based interactions
│   │   ├── DisasterTipUI
│   │   ├── HelpRequestUI.java
│   │   ├── InventoryUI.java
│   │   ├── MainMenu.java
│   │   ├── TrackDisasterUI.java
│   │   └── UserUI.java
│   └── utils                             # Utility classes
│   │   ├── ExceptionHandlingUtil.java
│   │   ├── InputValidationUtil.java
│   │   ├── PasswordUtil.java
│   │   └── 
│   ├── CrisisCompassCLIVer.java          #DRIVER FILE
_____
```
- **`lib`**: Contains external JAR dependencies required by the application (e.g., MySQL connector for database interaction and bcrypt for password hashing).
- **`db`**: Includes the `init.sql` script to set up the database schema and initial data.
- **`src`**: Main source directory for the project.
  - **`database`**: Manages database connections.
  - **`disasters`**: Includes an abstract `Disaster` class and specific disaster types like `Flood` and `Earthquake`.
  - **`models`**: Represents database entities such as users, disaster tips, and inventory items.
  - **`services`**: Contains service classes for core business logic and operations like managing help requests or inventory.
  - **`ui`**: Manages user interactions, providing a console-based interface for the application.
  - **`utils`**: Helper classes for utility functions, including exception handling, input validation, and password hashing.
  - **`CrisisCompassCLIver.java`**: The main driver file to start the application.

##  <a id = "contrib"> 👷‍ Contributor </a> <br>

| Name | Role | E-mail | 
| --- | --- | --- | 
| <a href = "[https://github.com/T>](https://github.com/Paul-Raimiel-Gonda)">Gonda, Paul Raimiel C. </a>| Developer | raigonda0987@gmail.com | 

<br>

- Courses:
  - Courses: CS 211: Object Oriented Programming | IT 211: Database Management System
- Course Facilitators:
  - Ms. Fatima Marie P. Agdon | Mr. Owen Patrick Falculan

