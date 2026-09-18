Library-Management
This Java project uses OOP to create a digital library where books are "living" objects. It features inheritance for item types, encapsulation to protect data, and a dynamic ArrayList for growth. The system handles borrowing and searching intuitively, mimicking a real-world library' turns. Concept: Object-Oriented Programming (OOP)

Abstract The Smart Library Management System is a console-based Java application designed to modernize the tracking and lending of library media. Unlike static databases, this system uses an object-oriented approach where each book is a "smart" entity capable of managing its own state and data.

Objectives To implement a dynamic inventory system using Java Collections.

To apply the four pillars of OOP: Encapsulation, Inheritance, Abstraction, and Polymorphism.

To create a user-friendly interface for searching and borrowing books.

System Architecture (OOP Implementation) 3.1 Abstraction We utilized an abstract class LibraryItem. This serves as a blueprint for all objects in the library. It defines the "what" (every item must have a title and ID) without strictly defining the "how," allowing for future expansion into magazines or DVDs.
3.2 Inheritance The Book class extends LibraryItem. This allows the Book to inherit universal properties (Title, ID, Availability) while adding its own specific data, such as the Author name.

3.3 Encapsulation Data integrity is maintained by making fields like isAvailable private or protected. Access to these variables is restricted through specific methods, ensuring that a book’s status cannot be changed by error or unauthorized functions.

3.4 Polymorphism The system uses method overriding for displayDetails(). While the library sees every entry as a generic "item," each object responds with its specific details (e.g., a Book displays its Author) when called.

Key Features Dynamic Storage: Uses ArrayList to allow the library collection to grow or shrink in real-time.
Intuitive Search: Implements case-insensitive string matching, making the system more "human" and forgiving of user typos.

State Management: The "Borrow" function updates the internal state of the object, ensuring real-time accuracy of inventory availability.

System Requirements Language: Java JDK 8 or higher.
Environment: Any IDE (IntelliJ, Eclipse, VS Code) or Command Line Interface.

Conclusion This project demonstrates how OOP principles can be used to solve real-world organizational problems. By treating data as interactive objects, the Smart Library Management System provides a scalable, maintainable, and robust framework for resource management.
