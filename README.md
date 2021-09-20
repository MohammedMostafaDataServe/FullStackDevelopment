# I have developed backend application with Spring Boot 2.5.4 & Java 11 & SQLite3 and frontend application with Angular 12

# Please follow these steps to boot up the project:

1- Clone my repository or download it az zip file from this url:
  https://github.com/MohammedMostafaDataServe/FullStackDevelopment

2- Ensure that docker installed on your machine

3- Run backend application:

 a) Open your terminal and point to backend application folder in directory you put it: ../\Jumia-Backend\JumiaService
 b) Run these 2 commands:
  > docker build -t jumia-backend .  (Hint: there are space dot at the end this is part of command)  
  > docker run -p 8080:8080 jumia-backend
 
 Now backend application is running you can test it by hitting this url on your browser: 
  http://localhost:8080/jumia-api/customers
  
 If reponded with json data and http status ok so backend application running well
 
 4- Run frontend application:
 
  a) Open your terminal and point to frontend application folder in directory you put it: ../\Jumia-Frontend
  b) Run these 2 commands:
   > docker build -t jumia-frontend .  (Hint: there are space dot at the end this is part of command)  
   > docker run -p 4200:80 jumia-frontend
   
   Now frontend application is running you cant test it by hitting this url on your browser: 
     http://localhost:4200/
     
   This page should render list of customers and phone numbers....
     
    Finished Thanks
 
