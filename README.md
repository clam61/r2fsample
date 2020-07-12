# ASSIGNMENT SPECIFICATIONS

Email from Chi Hoang:
---------------------
Specs:
1. Finished product in an apk file that another android device can open and run.
2. Program the app using JAVA
3. Save the codes in Github so anyone can view

What the app does:
1. After open the app, a screen with 2 fields and 1 button appear
2. User types in login email in 1st field
3. User types in a password in 2nd field
4. User presses the button to enter registration information
5. Hard code a master email address and password so that when a user enters these correct parameters, a new screen appears that says "YOU'RE IN"
6. If a user enters a wrong email or password, the welcome screen refreshes so the user can start over
7. If the user presses the registration button, a new screen appears to show fields for the user to enter his full name, address, phone number, and email.  After he fills in all the information and presses the "DONE" button, the screen jumps back to the start up page.
8. If he presses the registration button again then he would see the information he entered last.

---------------------

Sample app showing some basic functionality and MVVM.  Production app would most likely include Dependency Injection with something like Dagger.  LiveData is good for communication between the View and ViewModel; we don't have anything significant in the data layer here, but in production we would use most likely use Flow to implement the data layer. 
