# QueryManagementSystem

The Query Management System(QMS) is an IT tool which assists the employees of an organisation to access the database in respect of all
the department’s of the organisation, and their e- mail addresses for seeking specific queries.

# GAIL
<img src="https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/GAIL-CROPPED.gif">
I worked as a trainee in GAIL in the summer of 2018. At this time I had completed my First year at  Bhagwan Parshuram Institute of Technology(Affiliated to I.P. University, Delhi)
<br><br>

I take this opportunity to express my profound gratitude and deep regards to my guide Ms. Priya Gupta, Sr. Manager(BIS) & Mansi Sharma, ET(BIS) , for their exemplary guidance, monitoring and constant encouragement throughout the period of this project. The experience of working under them shall carry me a long way of life on which I am about to embark.

I also take this opportunity to express a deep sense of gratitude to my mentor Mr. Rajeev Arora, DGM(BIS), for his cordial support, valuable information and guidance which helped me in completing this task through various stages.

I also take the opportunity to express my heartfelt thanks to Ms. Renu Taneja, SM(Training).

 I am obliged to be a part of GAIL family for the valuable information provided by various employees in their respective fields. I am grateful for their cooperation during the period of my assignment.


## Built With

* [Firebase](https://firebase.google.com/) - To Store and sync app data.
* [JAVA Mail API JAR files](https://stackoverflow.com/questions/2020088/sending-email-in-android-using-javamail-api-without-using-the-default-built-in-a) - To get the required JAR files

## Application Overview

![Overview](https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Overview.png)

I have set my read and write of firebase to NULL. You can easily integrate your firebase.

## Application Description

### First Activity

The application starts with a splash screen displaying applications logo and name
The splash screen is set for 2sec.

<img src = "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Splash_Screen.png" width = "200" height = "395">

### Second Activity 
* User gains access to the application by entering their email-id and password and pressing Login button
* The logo and name of the application is displayed on the top.
* The email-id and password for an employee is the one provided by the organisation.
* A beautiful cardView has been used for Login button.
* A clickable textView has been used to gain access to the authorised section of the app.

<img src = "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Login_Page.png" width = "200" height = "410">

### Third Activity

* On clicking the “For authorised personnel Only” an authentication page is shown requesting the correct passcode.
* The passcode is entered in the editText Passcode.
* Get Access button starts the next activity after checking the input password.
<img src="https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Auth_Login.png" width = "200" height = "410">

### Fourth Activity

* Here the user gains the access to make changes to the database.
* Three editText’s to enter department’s name, it’s email and it’s info are provided to enter a new entry.
* A button to add the new entry.
* The list of departments with their email-id is displayed below the button. Being connected to firebase the changes made to the database are seen instantly.
* On holding an entry from the list a dialog box pops up asking to either update the department entry or to delete it from the database.

<img src = "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Auth_data_list.png" width = "200" height = "410">  <img src = "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Changing_data.png" width = "200" height = "410">

### Fifth Activity 

* A minimalistic UI displaying the list of Department’s straight from firebase.
* A searchBar is implemented to search through the list by name or email. 

<img src= "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/list_of_dept.png" width = "200" height = "410"> <img src= "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Search.png" width = "200" height = "410">

### Sixth Activity 

* A text displaying which department you are in is at top.
* Below it is a clickable textView. On clicking it a dialog box is opened displaying the information about the department.
* Two editText in which user can enter the subject and body of the query.
* On pressing the “Ask Query” button the message is sent to the respected email-id of the department. Also a permanent text “Sent from QMS application” is sent with the body.

<img src= "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Composing_mail.png" width = "200" height = "410"> <img src= "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Dialog_pop_up.png" width = "200" height = "410"> <img src= "https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/send_mail.png" width = "200" height = "410">

This is the last activity and you the user has successfully either updated the firebase database from Fourth Actvity or has send his query by selecting the department in Fifth Activity.

## References

* Logo made with [App Logo](https://www.designevo.com/) Free Online Logo Maker
* [AndroidHive - Android RecyclerView adding Search Filter](https://www.androidhive.info/2017/11/android-recyclerview-with-search-filter-functionality/) This article helped me implement search in recyclerView
* [Android Email App Using Javamail API in Android Studio](https://www.simplifiedcoding.net/android-email-app-using-javamail-api-in-android-studio/)
* [Awesome Firebase](https://firebase.google.com/)
* [Youtube](youtube.com) Helped a lot.
* [StackOverflow](https://stackoverflow.com/) Cleared all my queries


## Conclusion

<img src="https://github.com/Zyro9922/QueryManagementSystem/blob/master/Screenshots/Trainee.jpeg" width= "350" height="266.666">

* The whole experience of working at GAIL India Ltd. was great. I had the best work experience as a trainee .
* This organisation has a superb work culture, great minds and very high quality of work. 
* I also had a great time with all the other trainees. 
* I was able to practically implement my knowledge of mobile application development.
* Along with a great experience of working with Android Studio
    * I also introduced myself to Google’s latest technology which is Firebase Realtime Database. 
    * Implemented RecyclerView and search functionality in it.
    * Implemented JAVA MAIL API
    * Worked with GitHub
    * Realised the importance of a good UI
    
