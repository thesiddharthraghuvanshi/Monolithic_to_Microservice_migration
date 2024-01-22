# Monolithic_to_Microservice_migration

1- Inside Monolithic folder we have our simple springBoot project performing some CRUD operations 
between"Player" entity & "Team entity".

  1.1- Team entity has "ManyToMany" relation with Player entity.
  
  1.2- We are using MySQL DB.


2- Inside Microservices folders we have 4 project:

  2.1- Player-Service, exposing services of players connecting to "players" DB.

  2.2- Team-Service, exposing services of teams connecting to "teams" DB.

  2.3- Service-Registry, to register both of our micro-services in order to search each other and communicate.

  2.4- Api-Gateway, to work on load balancing.

3- For detailed explanantion abou this migration, please visit the below blog :
https://medium.com/@thesiddharthraghuvanshi/converting-monolithic-application-to-micro-service-monolithic-to-micro-service-migration-cf88352a7092
