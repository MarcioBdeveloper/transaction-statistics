# Transaction statistics

## 📌 Project Overview
This project is a API Rest that receive transactions and return statistic this transaction. This project is lab of learn about design pattern.

## 📌 Technologies Used
- **Java Version:** 21
- **Libraries:**
    - `spring-boot`
    - `jackson-databind`
    - `spring-boot-starter-test`
  
- **Build Tool:** Maven

## Design patterns
- `Notification pattern`: (Based DDD) See into class Notification.java
- `Self validation pattern`: (Based DDD) See into class TransactionRequest.java

---

## 🚀 Build and Run the Project

### 🔧 Running with Java (Locally)
1. Open your **command-line terminal**.
2. Navigate to the project directory: Example - cd /Enviroment/youworkspace/transaction-statistics
3. Execute the command: **mvn clean package**
4. Execute the command: **java -jar target/app-0.1.jar**
5. Execute curl the terminal: - `curl --location 'localhost:8080/transaction' \
   --header 'Content-Type: application/json' \
   --data '{
   "value":"90",
   "dateTime":"2025-07-13T15:40:00Z"
   }'`