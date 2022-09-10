# MovieBook (Backend part)
This is the back-end repository for the web application MovieBook! 

The website is a movie log book for users to search and browse movie information, like and track the movies they've watched, and saved movies they want to watch later. Users could get access to the full and real movie library from IMDb including the TOP 250 popular movie list, movie description, director and cast imforamtion, film posters and stills, and the real rating information by millions of reviewers on IMDb! 

## Features covered by the project
## Frontend:
- Components
- Mobile responsiveness

## Backend:
- User registration and login
- API calls
- Integration with database
- Classes and objects

## Full-stack:
- Linking together a frontend framework with a backend framework (Spring Boot with React/TypeScript)

## Time Use
15 hours

## Video Demo

## How to Use
1. Clone the repository in your local

2. Run Docker   
```docker run -p 63306:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysql_movie -d mysql```   
(If need to install: https://docs.docker.com/desktop/install/mac-install/)

3. Login MySQL    
```mysql -h 127.0.0.1 -P 63306 -u root -p123456```

4. Create movie database   
```create database movie;```

5. Open the project and Run ```MovieSearchApplication```
