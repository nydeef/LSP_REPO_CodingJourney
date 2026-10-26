# Course Registration — CRC Design

## 1. Registration

**Responsibilities**
- Coordinate the registration process.
- Validate registration requests.
- Coordinate tuition calculation, storage, and notifications.

**Collaborators**
- Student
- Course
- TuitionCalculator
- RegistrationRepository
- NotificationService

## 2. Student

**Responsibilities**
- Store student identification and relevant student information.
- Provide controlled access to student information.

**Collaborators**
- Registration

## 3. Course

**Responsibilities**
- Store course identification, title, and credit hours.
- Provide course information for registration and tuition calculations.

**Collaborators**
- Registration
- TuitionCalculator

## 4. TuitionCalculator

**Responsibilities**
- Calculate tuition based on registered credit hours.
- Apply the required discount when the student meets the credit-hour threshold.

**Collaborators**
- Registration
- Course

## 5. RegistrationRepository

**Responsibilities**
- Define operations for saving and retrieving registration information.

**Collaborators**
- Registration
- FileRegistrationRepository
- DatabaseRegistrationRepository

## 6. FileRegistrationRepository

**Responsibilities**
- Save and retrieve registration information using file storage.

**Collaborators**
- RegistrationRepository

## 7. DatabaseRegistrationRepository

**Responsibilities**
- Save and retrieve registration information using a database.

**Collaborators**
- RegistrationRepository

## 8. NotificationService

**Responsibilities**
- Define the operations needed to notify students about registration.

**Collaborators**
- Registration
- EmailNotificationService
- SmsNotificationService

## 9. EmailNotificationService

**Responsibilities**
- Send registration notifications through email.

**Collaborators**
- NotificationService

## 10. SmsNotificationService

**Responsibilities**
- Send registration notifications through text messages.

**Collaborators**
- NotificationService

## Design Summary

The design separates registration coordination from tuition calculations, persistence, and notifications. Repository and notification abstractions allow implementations to change without requiring the registration process to depend on a particular storage or delivery mechanism.