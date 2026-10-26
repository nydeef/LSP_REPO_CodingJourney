# Design Rationale

## Separation of Responsibilities

The proposed design separates registration coordination, tuition calculation, persistence, and notification delivery. This improves cohesion because each class focuses on a clear responsibility.

## Encapsulation

Student, course, and registration information should be protected through private fields and controlled methods. This prevents unrelated classes from changing internal state without validation.

## Abstraction and Extensibility

The `RegistrationRepository` abstraction separates registration logic from the storage implementation. A file-based repository or database-backed repository can be selected without requiring the registration coordinator to depend on a specific storage technology.

Similarly, the `NotificationService` abstraction separates registration logic from notification delivery. Email and SMS implementations can provide different delivery methods through a shared interface.

## Testability

Separating tuition calculation into `TuitionCalculator` makes tuition rules easier to test independently. Repository and notification abstractions also make it easier to substitute test implementations when testing registration behavior.

## Conclusion

The design reduces coupling, improves cohesion, strengthens encapsulation, and supports future extensions. Each component can evolve independently when its responsibilities or implementation requirements change.