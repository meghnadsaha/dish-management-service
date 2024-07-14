
---

## Dish Management Service API Documentation

### Fetch List of Dishes

**Description**: API to fetch the list of dishes from the database.

**Endpoint**:
```http
GET curl --location --request POST 'http://localhost:8081/api/dishes'
```

**Response**:
```http

[
    {
        "dishId": 3,
        "dishName": "Rabdi",
        "imageUrl": "https://nosh-assignment.s3.ap-south-1.amazonaws.com/rabdi.jpg",
        "isPublished": false
    },
    {
        "dishId": 5,
        "dishName": "Alfredo Pasta",
        "imageUrl": "https://nosh-assignment.s3.ap-south-1.amazonaws.com/alfredo-pasta.jpg",
        "isPublished": false
    },
    {
        "dishId": 4,
        "dishName": "Chicken Biryani",
        "imageUrl": "https://nosh-assignment.s3.ap-south-1.amazonaws.com/chicken-biryani.jpg",
        "isPublished": false
    },
    {
        "dishId": 2,
        "dishName": "Paneer Tikka",
        "imageUrl": "https://nosh-assignment.s3.ap-south-1.amazonaws.com/paneer-tikka.jpg",
        "isPublished": false
    },
    {
        "dishId": 1,
        "dishName": "Jeera Rice",
        "imageUrl": "https://nosh-assignment.s3.ap-south-1.amazonaws.com/jeera-rice.jpg",
        "isPublished": true
    }
]


```


### Toggle isPublished Status of a Dish

**Description**: API to toggle the `isPublished` status of a dish.

**Endpoint**:
```http
PUT curl --location --request POST 'http://localhost:8081/api/dishes/{dishId}'
```

---

