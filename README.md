# parking-lot-reservation-portal
A smart parking facility has multiple floors, each containing multiple parking slots. Customers can reserve a slot for a specific period of time. The system must prevent double bookings and calculate the parking fee based on duration.

Setup Instructions:
- Java 17 
- Maven 
- MySQL V8
- Spring Boot
- Spring Tool Suite IDE
- Hibernate
  
Dependencies:
- spring-data-jpa
- validation
- spring-web
- Lombok
- mysql-connector-java version-8.0.33

Run instruction:
- Create a MySQL database :
      parking
- The application will start at:
      http://localhost:8080
- Example endpoints:
      - POST /reserve → Create a new reservation
        - {
          "slotId": 1,
          "customerName": "John Doe",
          "startTime": "2025-08-22T10:00:00",
          "endTime": "2025-08-22T12:00:00"
        }
      - GET /reserve/{id} → Get reservation details
      - GET /availability → Check available slots for a given time range :
           /availability?startTime=2025-08-22T10:00:00&endTime=2025-08-22T12:00:00

