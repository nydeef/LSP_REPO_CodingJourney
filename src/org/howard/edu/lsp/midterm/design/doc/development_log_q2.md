# Development Log — Question 2

## Work Completed

- Reviewed the provided `CourseRegistration` class and its `registerStudent()` method.
- Identified design problems involving public fields, multiple responsibilities, direct file-writing dependencies, embedded tuition rules, notification limitations, and logging.
- Proposed CRC cards that separate registration coordination, tuition calculation, persistence, notification delivery, and logging.
- Documented the reasons for using separate classes and abstractions.

## AI Assistance

OpenAI ChatGPT was used during development to help analyze the provided Java class, identify object-oriented design concerns, propose class responsibilities and collaborators, and draft documentation about the design rationale. The proposed design should be checked against the assignment instructions and revised as needed to reflect my own understanding.

AI conversation: [Add the actual shareable URL for this conversation if required by the assignment.](https://chatgpt.com/share/6adfded3-4e2c-83ea-8d92-72a7691cad51)

## Online Resources

- OpenAI ChatGPT: https://chatgpt.com/
- Oracle Java Documentation: https://docs.oracle.com/en/java/

## Design Validation

The proposed design preserves the original tuition rules: tuition is calculated at $750 per credit hour, and a 10% discount is applied when credit hours are 12 or greater. It also accounts for the original class's use of file output, confirmation messaging, and timestamp logging.

## Reflection

## Reflection

The most important design problems in the original `CourseRegistration` class were that it handled too many responsibilities in one place and used public fields that could be accessed or changed directly. The class calculated tuition, applied discounts, printed registration confirmations, saved registration information to a file, simulated email notifications, and logged registration dates. Keeping all these responsibilities together made the code harder to maintain, test, and modify.

I learned that these responsibilities should be separated into different classes so each class has one main purpose. The `RegistrationService` coordinates the registration process, while the `TuitionCalculator` calculates tuition based on credit hours and applies the 10% discount for students taking 12 or more credit hours. The repository classes handle saving and retrieving registration information, and the notification classes handle sending registration confirmations. Separating these responsibilities makes it easier to change one part of the system without affecting everything else.

Applying object-oriented design principles also showed me the importance of encapsulation and abstraction. Instead of using public fields, the design can protect registration data through private fields and controlled access. Abstraction allows the system to use different storage methods or notification implementations without changing the main registration process. I also learned that separating responsibilities makes individual classes easier to test and helps prevent the code from becoming overly complicated as the system grows. Overall, this project helped me understand that good object-oriented design involves organizing code around clear responsibilities rather than placing every operation inside a single class.