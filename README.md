\# JWT Auth Assignment



Full stack authentication project using Spring Boot, JWT, role-based access control, and React TypeScript.



\## Features



\- User registration

\- User login

\- JWT authentication

\- USER and ADMIN roles

\- Role based API access

\- Swagger API documentation

\- React dashboard with role based content



\## Tech Stack



\*\*Backend\*\*



\- Java 17

\- Spring Boot

\- Spring Security

\- JWT

\- Spring Data JPA

\- MySQL

\- Lombok

\- Swagger/OpenAPI



\*\*Frontend\*\*



\- React

\- TypeScript

\- Vite

\- React Router

\- Axios

\- React Hook Form



\## Folder Structure



```text

JWT-Auth-Assignment

├── Backend

│   └── AuthaAsignmentApplication

├── frontend

├── screenshot

└── README.md

```



\## Backend Setup



Go to backend folder:



```bash

cd Backend/AuthaAsignmentApplication

```



Create MySQL database:



```sql

CREATE DATABASE Auth\_assignment\_db;

```



Create local config file:



```text

src/main/resources/application.properties

```



Use `application-example.properties` as reference.



Run backend:



```bash

mvn spring-boot:run

```



Backend URL:



```text

http://localhost:8080

```



\## Frontend Setup



Go to frontend folder:



```bash

cd frontend

```



Install dependencies:



```bash

npm install

```



Run frontend:



```bash

npm run dev

```



Frontend URL:



```text

http://localhost:5173

```



\## API Endpoints



| Method | Endpoint | Access |

|---|---|---|

| POST | `/api/auth/register` | Public |

| POST | `/api/auth/login` | Public |

| GET | `/api/public` | Public |

| GET | `/api/user` | USER, ADMIN |

| GET | `/api/admin` | ADMIN |



\## Swagger



```text

http://localhost:8080/swagger-ui/index.html

```



\## Screenshots



\### Swagger



!\[Swagger](screenshot/swagger.png)



\### Register Page



!\[Register](screenshot/register.png)



\### Login API



!\[Login](screenshot/login.png)



\### Admin Dashboard



!\[Admin Dashboard](screenshot/admin-dashboard.png)



\### User API Test



!\[User API](screenshot/user-api-postman.png)



\### Admin API Test



!\[Admin API](screenshot/admin-api-postman.png)



\## Security Note



`application.properties` is not uploaded to GitHub. Use `application-example.properties` for sample configuration.



\## Author



Gaurav Mandage

