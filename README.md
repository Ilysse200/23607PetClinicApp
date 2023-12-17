Pet Clinic Management System

Project Description

The Pet Clinic Management System is a Java-based web application developed using Spring Boot, MySQL, and Thymeleaf. It is designed to streamline the operations of a veterinary clinic, focusing on managing information related to pets, their owners, appointments, and veterinarians. The application is a single-user system where all CRUD operations are handled by the administrator.

Project Requirements

The project aims to achieve the following:

Pet Management: CRUD operations for pets.
Owner Management: Manage information about pet owners.
Appointment Scheduling: Schedule appointments for pets with veterinarians.
Veterinarian Information: Maintain details of veterinarians.
User-friendly Interface: Provide an intuitive interface for efficient administration.

Project Plan

Scope:
The project's scope covers the development of a fully functional pet clinic management system.

Timeline:
Start Date: [Enter Start Date]
End Date: [Enter End Date]

Resources:

The project was developed using the following technologies:

Programming Language: Java
Framework: Spring Boot
Front-end: Thymeleaf
Database: MySQL
Source Code
The source code for the project is available in the src directory. It includes:

Main Application Code
Configuration Files
Thymeleaf Templates
MySQL Database Schema
Database Schema
Entity-Relationship Diagram (ERD)
Database Schema

Tables:
Pet:

petId (PK)
petName
petBreed
petArrivalDate
petType
ownerId (FK)
PetOwner:

ownerId (PK)
ownerFirstName
ownerLastName
ownerTelephoneNumber
ownerCity

Appointment:

appointmentId (PK)
appointmentDate
appointmentReason
petId (FK)
veterinarianId (FK)

Veterinarian:

veterinarianId (PK)
vetFirstName
vetLastName
vetSpecialty

User Documentation
How to Use Pet Management:

To add a new pet, click on "Add Pet" and fill in the required details.
To update or delete a pet, use the "Update" and "Delete" buttons.


*Owner Management:

Navigate to the "Owners" section to manage pet owners.
Add, update, or delete owner records.

*Appointment Scheduling:

Go to the "Appointments" section to schedule new appointments.
View and manage existing appointments.

*Veterinarian Information

Access the "Veterinarians" section to manage veterinarian details.
Login Credentials
As a single-user application, there is no login required. The administrator has full access to all features.

Technical Documentation
Architecture
The application follows the MVC (Model-View-Controller) architecture, with Spring Boot handling the back-end logic.

Implementation Details
Programming Language: Java
Framework: Spring Boot
Front-end: Thymeleaf
Database: MySQL
Dependencies: Spring Boot Starter Web, Spring Boot Starter Data JPA, Thymeleaf, MySQL Connector