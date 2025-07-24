# Transaction statistics

## 📌 Project Overview
This project is a API Rest that receive transactions and return statistic this transaction. This project is lab of learn about design pattern.

## 📌 Busines Rules
This Api receive transactions and calc quant, sum, average, min value and max value of transactions.

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

### 🔧 Running Java (Locally)
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

### 🔧 Running Java using Docker (Locally)
1. Open your **command-line terminal**.
2. Navigate to the project directory: Example - cd /Enviroment/youworkspace/transaction-statistics
3. Execute the command: **mvn clean package**
4. Execute the command for create an image docker: **docker buildx build -t transaction-statistics:v1 .**
5. Execute the command for running image: **docker run -it -p 8080:8080 transaction-statistics:v1**
5. Execute curl the terminal: - `curl --location 'localhost:8080/transaction' \
   --header 'Content-Type: application/json' \
   --data '{
   "value":"90",
   "dateTime":"2025-07-13T15:40:00Z"
   }'`

