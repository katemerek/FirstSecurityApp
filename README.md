# First Security App With SpringSecurity
## Description
This app is for registration a new person authentication (name+password) and authorization. 
All new users are given the user role, the admin is assigned manually and has access to the admin page. 

### Steps to run the application
- Import this project as a Maven project.
- Run the [sql script] (src/main/resources/script.sql) in the database to create person table.
- Add a new person to table Person from POST request. if necessary, assign the admin role manually in the table person.
- Pass authentication, which will redirect you to the page "Hello" in case of successful authentication.

Due to the presence of views in the project, you can test the API in your browser.
The app will start running at <http://localhost:8080/api/v1>.
### Rest APIs
 GET /hello

 GET /admin
 
 GET /auth/login

 GET /auth/registration

 POST /auth/registration

 POST test test test
