# JSP Web Application Project

This is a simple JavaServer Pages (JSP) web application project for educational purposes. It includes functionalities such as user authentication, user management, and a basic dashboard.

## Project Structure

The project is organized into several packages, each serving a specific purpose:

### `connection`

This package contains the `SingleConnectionBanco` class, which manages the database connection using JDBC. It follows the Singleton pattern to ensure a single database connection throughout the application.

### `dao`

The `dao` package includes two classes, `DAOLoginRepository` and `DAOUsuarioRepository`. These classes handle data access operations related to user authentication and user management, respectively.

### `filter`

The `filter` package contains the `FilterAutenticacao` class, which is a servlet filter responsible for authenticating users. It intercepts requests to the `/principal/*` URL pattern, ensuring that only authenticated users can access certain pages.

### `model`

The `model` package defines the `ModelLogin` class, representing a user's login information. This class implements the `Serializable` interface.

### `servlets`

The `servlets` package includes two servlet classes, `ServletLogin` and `ServletUsuarioController`. 

- `ServletLogin` handles user login functionality, validating user credentials and redirecting to the appropriate page.
  
- `ServletUsuarioController` manages user-related operations, such as displaying user information on the front end.

### `webapp`

The `webapp` directory contains the web application's resources, including JSP files, CSS styles, and JavaScript scripts.

## Database Setup

The database used in this project is PostgreSQL, and the SQL script to create the necessary database and tables is provided in the project. The database name is `curso-jsp`, and a sample user (`admin`) with password (`admin`) is created for initial testing.

```sql
-- Database: curso-jsp

CREATE DATABASE "curso-jsp"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'pt_BR.UTF-8'
    LC_CTYPE = 'pt_BR.UTF-8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- Table: public.model_login

CREATE TABLE IF NOT EXISTS public.model_login
(
    login character varying(200) NOT NULL,
    senha character varying(200) NOT NULL,
    id integer NOT NULL DEFAULT nextval('model_login_id_seq'::regclass),
    nome character varying(255) NOT NULL,
    email character varying(255) NOT NULL,
    CONSTRAINT model_login_pkey PRIMARY KEY (id),
    CONSTRAINT login_unique UNIQUE (login)
);

## Running the Application

- Ensure that you have a PostgreSQL database server installed and running.

- Execute the provided SQL script to create the curso-jsp database and tables.

- Deploy the project to a servlet container such as Apache Tomcat.

- Access the application through a web browser using the appropriate URL.

## Additional Notes

- The project uses Bootstrap for styling and jQuery for JavaScript functionality. These libraries are included via CDN links.

- The application structure follows a basic MVC (Model-View-Controller) pattern.

- User authentication is implemented using session management, and user credentials are stored in the database.

- Feel free to explore and modify the code to suit your learning needs. If you have any questions or encounter issues, please refer to the provided code comments or seek assistance in relevant programming forums.



