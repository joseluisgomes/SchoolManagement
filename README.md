# SchoolManagement
Login-based school management web application built with Spring framework, Boot, Security, Html and Postgresql.

## Description
The core, the yolk of this app is security. I thought it would be more interesting and funnier exploring this theme with a connection to a database.
<br />The database (**school**) was created with _Postgresql_ and it contains 2 registered students (standard approach).

![database1](https://user-images.githubusercontent.com/70901488/132352770-eb85218e-6e5e-45de-9355-d39fa2531fa6.png)
![database2](https://user-images.githubusercontent.com/70901488/132352992-e3b9ff69-ab19-41ec-b3a7-88fa6f7507af.png)
<br />As the name refers this app represents, illustrates a school's management system, whose members can be filtered or splited in 3 categories : **STUDENT**, **ADMIN** and **ADMIN_TRAINEE**.
<br />
<br />The **ADMIN** category is equivalent to a school's director and the **ADMIN_TRAINEE** represents a student who performs functions related to an administration of a school.
<br />Which category owns his rights, authorizations or permissions associated. For the **STUDENT** category, I did not assign any 
permissions.
<br />
<br /> The logic of the this app is as follows:
* the **ADMIN** can _consult_ the list of students and each student registered on the database; Can _add_, _delete_ and _update_ the of the students.
* the **ADMIN_TRAINEEE** can only consult the list of students and consult them individually.

<p align="center">
  <img src ="https://user-images.githubusercontent.com/70901488/132359307-a7f1f01c-2008-4346-8f78-fa8aea20bf2d.png" width=70% height=70%> 
</p>
<p float="left">
  <img src="https://user-images.githubusercontent.com/70901488/132362993-7c37b218-a782-4392-a9bb-fe5e6555bb85.png" width=30%/>
  <img src="https://user-images.githubusercontent.com/70901488/132363215-7b72b6b0-6afe-4661-95cf-318b047b91a8.png" width=39%/> 
  <img src="https://user-images.githubusercontent.com/70901488/132363626-6a8f0d82-0387-438c-9d3d-2a1507f1b94e.png" width=30%/>
</p>

<br /> Throughout the project, I studied and applied several forms of authentication, which implied the mold and the mutation of the code.
<br /> The forms of authentication used on the project were the following: 
* **Form-Based** Authentication
* **Basic** Authentication
* **JWT**
 
