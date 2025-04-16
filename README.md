🗃️ MongoDB POJO Mapping Example (Java)
This project demonstrates how to use Plain Old Java Objects (POJOs) to interact with MongoDB in a Java application. It shows how to map Java classes directly to MongoDB documents for clean, type-safe, and object-oriented data handling.

 Tech Stack
Java

MongoDB

MongoDB Java Driver (or Spring Data MongoDB, if applicable)

Maven/Gradle

📦 Features
Basic POJO model class (Student)

Seamless mapping between Java objects and MongoDB documents

CRUD operations using MongoDB Java APIs

Easily extendable for real-world applications

📁 Sample Document Structure in MongoDB
json
Copy
Edit
{
  "_id": "123abc",
  "name": "Alice",
  "age": 30
}
🚀 Getting Started
Clone the repo:


git clone https://github.com/your-username/mongodb-pojo-example.git
Configure your MongoDB URI and database settings in the code.

Run the project:


mvn clean install
java -jar target/your-app.jar
🤓 Why POJO?
POJOs offer a simple and clean way to handle data in Java, enabling:

Better readability

Type safety

Easy unit testing

Smooth integration with frameworks like Spring Data MongoDB

