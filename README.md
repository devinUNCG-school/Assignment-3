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

json
{
"name": "Walter White",
"showName": "Breaking Bad",
"universe": "AMC",
"role": "Protagonist"
}
### `PUT /api/characters/{id}` (Update Character)

json
{
"name": "Bryan Cranston / Walter White",
"showName": "Breaking Bad",
"universe": "AMC Network",
"role": "Antihero"
}

---

## Live Deployment
- **Deployment URL:** [https://assignment-3-35w2.onrender.com/api/characters](https://assignment-3-35w2.onrender.com/api/characters)

> **Cold Start Note:** Because this service is hosted on Render's free tier, the instance will automatically spin down after a period of inactivity. Initial requests after spin-down may take up to 50 seconds or more to respond while the service starts up.
