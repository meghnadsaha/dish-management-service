
---

## Dish Management Service API Documentation

### Fetch List of Dishes

**Description**: API to fetch the list of dishes from the database.

**Endpoint**:
```http
GET curl --location --request POST 'http://localhost:8081/api/dishes'
```

### Toggle isPublished Status of a Dish

**Description**: API to toggle the `isPublished` status of a dish.

**Endpoint**:
```http
PUT curl --location --request POST 'http://localhost:8081/api/dishes/{dishId}'
```

---

