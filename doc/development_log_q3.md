# Question 3 Development Log

## External Resources Used

### ChatGPT

ChatGPT was used to help understand and implement inheritance, method overriding, and polymorphism for the employee pay calculation assignment.

The assistance included:
- Creating an abstract `Employee` superclass with shared employee data.
- Implementing `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor` subclasses.
- Overriding `calculatePay()` in each subclass to implement its specific pay rules.
- Understanding the full-time overtime calculation and the contractor's 15% premium.
- Checking the implementation against the provided Driver's expected test results.

The implementation was run against the provided Driver and produced `RESULT: 12 PASSED, 0 FAILED`.

**Conversation transcript:** Include the complete ChatGPT conversation transcript as required by the assignment. If a shareable conversation link is available, include it here as well.

## Design Summary

The refactoring replaces conditional logic that checks an employee type with an inheritance hierarchy. The abstract `Employee` class stores shared information and declares `calculatePay()`. Each subclass overrides that method with its own pay calculation.

This design uses inheritance to share common fields and polymorphism to let each employee type calculate its pay through the same method signature.

## Testing

The provided Driver was run without modification. All 12 functional tests passed.

https://chatgpt.com/share/6adfe258-0e24-83e8-9414-b4b889a47c56