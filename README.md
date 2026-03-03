# ByteBites – Full-Stack Food Ordering Platform

ByteBites is a complete **food ordering and restaurant management system** that I built to demonstrate my full-stack development skills.

This project shows my ability to design and connect:
- a modern **React frontend** for customers, restaurant admins, and super-admin users,
- a secure **Spring Boot backend** with role-based APIs,
- and a scalable data model for real-world ordering workflows.

---

## 🚀 Project Overview

ByteBites simulates a real production-style food delivery ecosystem with:
- Customer-facing food discovery and ordering,
- Restaurant-side menu/order/event management,
- Super-admin controls for platform-level operations,
- Authentication, payments, notifications, and profile management.

This repository contains:
- `frontend-react/` → React + Redux application
- `backend-springboot/` → Spring Boot REST API

---

## 🧠 Skills Demonstrated Through This Project

### 1) Full-Stack Architecture
- Built and maintained both frontend and backend layers.
- Designed clean separation between UI, routing, API logic, service logic, and persistence.

### 2) Frontend Engineering (React)
- Developed modular UI components with route-based page architecture.
- Implemented role-aware flows for customers/admin/super-admin users.
- Integrated Redux state management and async API actions.
- Used modern UI tooling including MUI, Formik, Yup, and Tailwind.

### 3) Backend Engineering (Spring Boot)
- Designed RESTful APIs with dedicated controllers and services.
- Implemented secure auth flow with JWT and Spring Security.
- Built domain-driven models for users, restaurants, orders, cart, reviews, and notifications.
- Integrated payments and email capabilities for real business workflows.

### 4) Database & Domain Modeling
- Created relational entities and repository layers for core food-ordering operations.
- Modeled relationships among customers, restaurants, menu items, cart items, orders, and payments.

### 5) Product Thinking & Real-World Features
- Implemented user journeys from sign-up/login to checkout/payment success.
- Added admin tooling for menu, category, ingredients, and order operations.
- Included super-admin capabilities to support platform-level governance.

---

## ✅ Key Features Delivered

### Customer Features
- User authentication and profile/account flows
- Browse restaurants and menus
- Add to cart and place orders
- Checkout and payment-success flow
- Search and favorites-style customer experience components

### Restaurant Admin Features
- Create/manage restaurant
- Manage menu items and categories
- Manage ingredients and events
- View and process restaurant orders

### Super Admin Features
- Platform-level dashboard and restaurant/customer visibility
- Restaurant request handling and management workflows

### Backend Platform Features
- JWT-based security and protected APIs
- Role-aware authorization behavior
- Order, cart, review, notification, and payment service modules
- Password reset support and email integration

---

## 🛠️ Tech Stack

### Frontend
- React 18
- Redux + Redux Thunk
- React Router
- Material UI (MUI)
- Formik + Yup
- Axios
- Tailwind CSS

### Backend
- Java 17
- Spring Boot 3
- Spring Web, Spring Security, Spring Data JPA, Validation
- JWT (jjwt)
- MySQL connector
- Stripe Java SDK
- Spring Mail

---

## 📂 Repository Structure

```text
bytebites/
├── frontend-react/      # React client application
├── backend-springboot/  # Spring Boot REST API
└── README.md            # Project overview and skill showcase
```

---

## ▶️ How to Run

### Frontend
```bash
cd frontend-react
npm install
npm start
```

### Backend
```bash
cd backend-springboot
./mvnw spring-boot:run
```

> Configure your environment variables / application properties (DB, JWT, Stripe, Mail) before running in a real environment.

---

## 📌 Why This Project Is Important

ByteBites highlights my ability to:
- ship end-to-end product features,
- work across UI, API, data, and security layers,
- structure a scalable codebase with multiple user roles,
- and build software that is both technically complete and business-oriented.

If you're reviewing my profile (HR, hiring manager, or technical interviewer), this project reflects practical development experience across the full software lifecycle.
