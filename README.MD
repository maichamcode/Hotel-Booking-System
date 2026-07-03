# Hotel Booking System

A Hotel Booking System built with Java Spring Boot and Microservice Architecture.

## Tech Stack

- Java 21
- Spring Boot
- Spring Cloud
- Docker
- PostgreSQL
- Redis
- Kafka

## Architecture

- API Gateway
- Discovery Service
- Config Server
- Auth Service
- Hotel Service
- Room Service
- Booking Service
- Payment Service
- Notification Service

## Project Phases

- ✅ Phase 1: Infrastructure
    - Setup docker
    - Design system
    - Design API
    - Setup common
    - Setup env (local, docker,...)
- ✅ Phase 2: user-service
    - findAll
    - findById
    - findByEmail
    - findByPhone
    - findByName
    - Goals for find:
      -  Xem chi tiết một user: dùng ID.
      -  Đăng nhập: dùng email.
      -  Tìm kiếm danh sách: dùng name, email, hoặc một keyword tổng hợp.
      -  Số điện thoại: dùng khi nghiệp vụ cần xác thực hoặc tra cứu. 
    - create
    - update
    - delete
- ⏳ Phase 3: Hotel Service
  -  
- ⏳ Phase 4: Booking
- ⏳ Phase 5: Payment

## Run

```bash
docker compose up --build -d
```