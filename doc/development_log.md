# Development Log — Question 1

## Work Completed

- Implemented the `Book` class with ISBN, title, author, and availability fields.
- Implemented borrowing and returning operations with state validation.
- Implemented the `Library` class to add books, find books, search by author, retrieve available books, sort books by ISBN, and track borrowed books.
- Added duplicate ISBN validation and a maximum borrowing limit of three books.
- Used the instructor-provided `Driver.java` to verify the implementation.
- Ran the verification driver successfully: 44 tests passed and 0 tests failed.

## AI Assistance

OpenAI ChatGPT was used as an assistance resource during development. It helped explain the class responsibilities, provide implementation examples for `Book.java` and `Library.java`, and explain how to add and run the instructor-provided verification driver in IntelliJ IDEA. The generated code was added to the project and tested using the instructor-provided driver.

## Online Resources

- OpenAI ChatGPT: https://chatgpt.com/
- Java documentation: https://docs.oracle.com/en/java/

## Testing

The instructor-provided `Driver.java` was executed in IntelliJ IDEA. The output reported 44 passed tests and 0 failed tests, with a functional score of 25.00 out of 25.

## Reflection

The testing process helped verify the expected behavior of book availability, duplicate ISBN rejection, author searches, ISBN sorting, borrowing limits, and invalid borrowing and returning operations. Separating book-level state management from library-level collection management helped keep the implementation organized.

https://chatgpt.com/share/6adfda0c-1064-83ea-80aa-1ce81889ed04