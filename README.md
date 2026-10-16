# Assignment 3 - Spring Boot REST API on Render

A Spring Boot application deployed on Render using a multi-stage Dockerfile and connected to a remote Neon PostgreSQL database.

## Live Service URL
- [Assignment-3 Live Service](https://assignment-3-35w2.onrender.com)

## Database Configuration
Connected via `SPRING_DATASOURCE_URL` to a Neon PostgreSQL database instance.

## API Endpoints
- `GET /api/characters` - Retrieve all characters (supports optional filtering by query parameters like `universe` or `name`).
