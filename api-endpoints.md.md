## End points

### Order Controller

###### `GET /orders`

- Returns all created orders

###### `GET /orders/{orderId}`

- Returns a specific order whose id is `orderId`

###### `GET /customers/{customerId}/orders`

- Returns the orders created by the customer whose id is `customerId`

###### `GET /customers/{customerId}/orders/{orderId}`

- Returns a specific order whose id is `orderId` and the customer who ordered it has id `customerId`
- Ensures that this order is for this customer

###### `POST /customers/{customerId}/orders`

- Creates a new ***named*** order for a customer whose id is `customerId`
- **Request body:**
  
  ```json
  {
    "name": name
  }
  ```
- Returns an object which represent the newly created order
- **Response body**
  
  ```json
  {
    "name": name,
    "customer": {
        "id": id,
        "name": name,
        "email": email,
        "phoneNumber": phoneNumber,
        "password": password
    },
    "totalPrice": 0,
    "state": "CREATED"
  }
  ```

###### `PUT /customers/{customerId}/orders/{orderId}`

- Updates the information of a specific order
- **Request body:**
  
  ```json
  {
    "name": newName,
    "totalPrice": newTotalPrice,
    "state": newState
  }
  ```
- Returns the order object after update
- **Response body:**
  
  ```json
  {
    "name": newName,
    "customer": {
        "id": id,
        "name": name,
        "email": email,
        "phoneNumber": phoneNumber,
        "password": password
    },
    "totalPrice": newTotalPrice,
    "state": newState
  }
  ```
  
  ### Customer Controller

##### `GET /customers

- Returns all customers

##### `GET /customers/{customerId}`

- Returns a specific customer whose id is `customerId`

##### `POST /customers`

- Creates a new customer with the information given in the request body.
- **Request body:**
  
  ```json
  {
    "name": name,
    "email": email,
    "phoneNumber": phoneNumber,
    "password": password
  }
  ```
- Returns an object which represents the new customer and his id
- **Response body:**
  
  ```json
  {
    "id": id,
    "name": name,
    "email": email,
    "phoneNumber": phoneNumber,
    "password": password
  }
  ```

##### `PUT /customers/{customerId}`

- Updates the information of a specific customer whose id is `customerId`
- **Request body:**
  
  ```json
  {
    "name": newName,
    "email": newEmail,
    "phoneNumber": newPhoneNumber,
    "password": newPassword
  }
  ```
- Returns the customer object after the update
- **Response body:**
  
  ```json
  {
    "id": id,
    "name": newName,
    "email": newEmail,
    "phoneNumber": newPhoneNumber,
    "password": newPassword
  }
  ```

### Vendor Controller
