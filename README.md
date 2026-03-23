# 📚 Carrefour Java Kata - Delivery Slot Reservation API

## 📖 Overview

This project is a backend REST API built with **Spring Boot (Java 21)** that allows customers to:

- Select a delivery method
- View available delivery time slots
- Reserve a time slot

Supported delivery methods:
- `DRIVE`
- `DELIVERY`
- `DELIVERY_TODAY`
- `DELIVERY_ASAP`

---

## 🚀 How to run the project

### Prerequisites
- Java 21
- Gradle

### Run the application

```bash
./gradlew bootRun
```
The application will start on:

```bash
http://localhost:8080
```

📡 API Endpoints
1. Get available time slots

```bash
GET /api/delivery/slots
```

Query parameters:

method (required): DeliveryMethod

date (required): yyyy-MM-dd

Example:
```bash
GET /api/delivery/slots?method=DRIVE&date=2026-03-25
```

2. Reserve a time slot
```bash
POST /api/delivery/reserve
```

Request body:

```bash
{
  "deliveryMethode": "DRIVE",
  "date": "2026-03-25",
  "startTime": "10:00:00",
  "endTime": "11:00:00"
}
```

Response example:

```bash
{
  "id": "dc3c7d69-76f7-4a45-91e0-89a6c7a02e7a",
  "deliveryMethode": "DRIVE",
  "timeSlot": {
    "date": "2026-03-25",
    "startTime": "10:00:00",
    "endTime": "11:00:00",
    "deliveryMethode": "DRIVE",
    "capacity": 5,
    "reserved": 1,
    "availble": true
  }
}
```

👨‍💻 Author

Java Backend Developer – Spring Boot / Kafka

