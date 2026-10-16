# Assignment 3 - TV Character REST API

## Description
This application is a Spring Boot RESTful Web Service that manages information about TV Characters. It connects to a remote Neon PostgreSQL database and is deployed on Render using a multi-stage Docker container.

## Entity Attributes: `TvCharacter`
- **id** (`Long`): Primary Key, auto-generated.
- **name** (`String`): Required, cannot be blank. Represents the character's name.
- **showName** (`String`): Required, cannot be blank. Represents the television series the character belongs to.
- **universe** (`String`): Optional. Represents the franchise or network universe (e.g., "HBO", "Marvel", "Cartoon Network").
- **role** (`String`): Optional. Role in the show (e.g., "Protagonist", "Antagonist", "Supporting").

---

## API Endpoints

| Method | Path | Description | Success Status |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/characters` | Retrieve all characters (supports optional filtering by `universe` or `name`) | `200 OK` |
| `GET` | `/api/characters/{id}` | Retrieve a specific character by ID | `200 OK` |
| `POST` | `/api/characters` | Create a new character | `201 Created` |
| `PUT` | `/api/characters/{id}` | Update an existing character by ID | `200 OK` |
| `DELETE` | `/api/characters/{id}` | Delete a character by ID | `204 No Content` |

---

## Example Request Bodies

### `POST /api/characters` (Create Character)
