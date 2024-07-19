# Study Materials Management System

A comprehensive web-based application designed to streamline the management of study materials and notes. This project leverages the power of JSP, Servlet, JDBC, and MySQL to provide a robust backend while using Bootstrap and custom CSS to create a responsive and visually appealing user interface.

## Features

- **User Registration and Login**: Secure user authentication to ensure that only registered users can access the system.
- **Upload Study Materials**: Users can upload various study materials, including documents, PDFs, and presentations.
- **View and Download Study Materials**: A well-organized interface to browse, search, and download study materials.
- **User Dashboard**: A central hub for users to manage their uploaded materials and navigate the system.
- **Search Functionality**: Quickly find specific study materials using the search box.
- **Attractive UI**: A visually appealing design with background images, quotes, and a user-friendly layout.

## Technologies Used

- **Java (JSP, Servlet)**: Core backend logic for handling requests and responses.
- **JDBC**: Database connectivity for interacting with MySQL.
- **MySQL**: Relational database for storing user and material data.
- **HTML, CSS, Bootstrap**: Front-end technologies for responsive and attractive web design.


## Setup Instructions

1. **Clone the Repository**
    ```bash
    git clone  https://github.com/Jaykumar0710/NotesMedia-Study-Material.git
    ```

2. **Import the Project in Eclipse**
    - Open Eclipse IDE.
    - File -> Import -> Existing Maven Projects -> Browse to the project directory -> Finish.

3. **Configure MySQL Database**
    - Create a database named `studymaterialsdb` in MySQL.
    - Execute the following SQL script to create the required tables:

    ```sql
    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(255) NOT NULL,
        password VARCHAR(255) NOT NULL,
        email VARCHAR(255) NOT NULL
    );

    CREATE TABLE materials (
        id INT AUTO_INCREMENT PRIMARY KEY,
        title VARCHAR(255) NOT NULL,
        description TEXT NOT NULL,
        filename VARCHAR(255) NOT NULL,
        upload_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );
    ```

4. **Update Database Configuration**
    - Update the database connection details in the `MaterialDao.java`, `RegisterServlet.java`, and `LoginServlet.java` files.

    ```java
    // Example
    String jdbcURL = "jdbc:mysql://localhost:3306//NotesMedia-Study-Material";
    String jdbcUsername = "root";
    String jdbcPassword = "JaY@0710";
    ```

5. **Build and Deploy the Project**
    - Right-click the project in Eclipse -> Run As -> Run on Server -> Choose your server (e.g., Tomcat) -> Finish.

6. **Access the Application**
    - Open your web browser and go to `http://localhost:8080//NotesMedia-Study-Material/`

## Usage

1. **Register a New User**
    - Click on the "Register" button on the home page.
    - Fill in the registration form and submit.

2. **Login**
    - Click on the "Login" button on the home page.
    - Enter your username and password to login.

3. **Upload Materials**
    - Once logged in, click on the "Upload Material" button on the dashboard.
    - Fill in the details and upload the file.

4. **View and Download Materials**
    - Go to the "View Materials" page to see the list of uploaded materials.
    - Click on the "Download" link to download the material.

5. **Search Functionality**
    - Use the search box on the materials page to filter and find specific study materials.

## Additional Details

### User-Friendly Interface
The application features an intuitive and clean interface designed to provide a seamless user experience. The use of background images and quotes adds a touch of elegance and inspiration, making the study environment more engaging.

### Robust Backend
The backend is built using Java Servlets and JSP, ensuring a strong and scalable foundation. The use of JDBC for database connectivity ensures that the application can handle multiple users and large datasets efficiently.

### Responsive Design
The application is designed to be fully responsive, making it accessible on various devices, including desktops, tablets, and smartphones. Bootstrap is used extensively to ensure that the application looks great on all screen sizes.

### Security Features
The application includes basic security features to protect user data. Passwords are hashed before being stored in the database, and user sessions are managed securely to prevent unauthorized access.


