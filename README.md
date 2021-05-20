# GFCPlanMeds

## Link to Youtube Demonstration of the App
https://youtu.be/MXiVuf7Jfj8

---
## Brief description of the application and the motivation behind it
The initial idea is that it should be an app that can help people manage their medicine (the elderly as the main priority).
Based on witnessing how challenging it can be for the elderly to keep track of all the different medicine they need to take, the dosage and at what time it should be taken. It has come to my awareness that it would be a great asset to have an application, which can keep track of the daily management of the medicine that a specific person should take each day. It can be confusing if they have to handle multiple different kinds of medicine, as well as remembering, which kinds to take at what time, if they do not have a system they can rely on. By creating this application, it will do just that.
The application should be user-friendly so that most elderly would be able to use it themselves. Furthermore, it will be possible to set up alarms through the app, so the user can be reminded of when to take the medicine. As well as having a system, where the user preferably would be able to scan the barcode of the medicine packages, by the use of the camera and thereby extract the information by finding the medicine. This information could be used to store the doctor’s notes, such as how many pills the user needs to take, when it should be taken etc. as well as being able to easily reorder the medicine when needed. Moreover, it might also be very relevant for the user to have a direct number to their doctor’s office, in case they have questions or are experiencing side effects from the medicine.

---
## A list of MoSCoW prioritized requirements
(The lines that are crossed out have been delievered in the current version of the app.)

### Must have:
-	The User must be able to input their information into the application.
-	~~The App must store the user information.~~
-	~~The User must be able to log in~~ or create a user.
-	~~The App must be able to store information about the medicine, such as the dosage, when it should be taken and how often.~~
-	The User must be able to set an alarm for when to take the medicine (Almost implemented completely)

### Should have:
-	~~The App should have a direct link/number/email to the user’s doctor’s office, to make it easier to reorder or report any side effects.~~
-	~~The App should have an overview of what kinds of medicine to take, when and what dosage.~~
-	The User should be able to scan a medicines barcode through the camera and store the information about it.
-	~~The App should send out a message confirming the time of the set alarm.~~
-	The App should push a message to the user (in advance) when a medicine runs out.

### Could have:
-	The App could have a history of all the previously “outdated” medicine taken by the user.
-	The App could have the possibility to be able to store extra notes from the doctor.
-	The App could have a system that keeps track of how much is left in each medicine package. In addition, if the user by accident forgets to take the medicine, it could store this information as well.
-	The App could have more detailed information about the medicine, such as the specific ingredients it contains.

### Will not have:
-	The App will not store or show information about more than one user at a time.
-	The App and thereby the User will not be able to receive confirmation from the doctor by the use of email service.
-	The App will not redirect the user to other applications such as ‘MitHelbred’ where the user can schedule a time at the doctors.
-	The App will not contain other information about the user such as blood pressure, insulin levels etc.
-	The App will not notify the doctor in case the user either forgets to take the medicine or forgets to reorder it.
-	The App will not be offering the usage of NEM-ID to log in.

---
## Documentation

The focus has been on creating an application that would be able to store information about the user, the user’s medicine, storing and previewing, as well as having direct contact to the user’s doctor. On the Information view, it is possible to retrieve the information gathered about the signed in user, who’s information is stored in Firebase Cloud Firestore. At the specific moment, it is not possible for user’s to create a profile. This would obviously be one of the requirements that should be fulfilled on the next version of the app. 
The alarm functionality has been implemented, however, it is not currently working properly due to unknown reasons in the current version of the application, for demonstration purposes, dummy data have been used, to prove the functionality.

The app has not implemented the possibility of scanning a barcode using a camera. This should be implemented in a later version. The app’s database should have all the different kinds of medicine that exist in the world listed, in order for the user to choose between them.
The current version does not have a possibility of selecting, which medicines have expired. This could be done by adding a button to each specific medicine, to delete it from the current user’s medicine list. 

Furthermore, the medicine view does not have extra space for the doctor to add extra notes. However, this could be done by having a connection directly to the doctor’s system, so that it retrieves the notes from the doctor. This version of the app does not have the possibility of tracking how much medicine is left in the package; therefore, it cannot push a message when the medicine runs out as well.

In the later development of the application there is a desire to connect it to Nem-Id for better usability. This would also optimize the process of retrieving the specific information about each user. Regarding the medicine view, the desired effect would be that the app would take the information about which medicine the specific user needs, as well as which ingredients it contains, directly from the doctor’s input in their system.
