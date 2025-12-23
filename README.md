 Account Interest Scheduler – Spring Boot:

This project is a Spring Boot–based banking module that manages account creation and automatically applies monthly interest using a scheduled job.
The interest is applied only on the account creation date of each user and only once per month, similar to real-world banking systems.

 Features:

Create bank accounts using REST API

Automatically track account creation date

Apply monthly interest on the user’s creation date

Prevent duplicate interest application in the same month

Background scheduler using Spring Task Scheduler (XML-based)

Uses Spring Data JPA Auditing for automatic timestamps

MySQL database integration
