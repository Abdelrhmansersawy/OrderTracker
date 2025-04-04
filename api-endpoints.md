## End points

### Order Controller

###### `GET /orders`

- Returns all created orders

###### `GET /orders/{orderId}`

- Returns a specific order whose `id` is `orderId`

###### `GET /customers/{customerId}/orders`

- Returns the orders created by the customer whose `id` is `customerId`

###### `GET /customers/{customerId}/orders/{orderId}`

- Returns a specific order whose `id` is `orderId` and the customer who ordered it has `id` equals `customerId`
- Ensures that this order is for this customer

###### `POST /customers/{customerId}/orders`

- Creates a new ***named*** order for a customer whose `id` is `customerId`

- **Request body:**
  
  ```json
  {
    "name": name
  }
  ```

- Returns an object which represent the newly created order with its `id`

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

###### `PUT /customers/{customerId}/orders`

- Updates the information of a specific order

- The `id` of the order should be provided in the request body

- **Request body:**
  
  ```json
  {
    "id": id,
    "name": newName,
    "totalPrice": newTotalPrice,
    "state": newState
  }
  ```

- Returns the order object after update

- **Response body:**
  
  ```json
  {
    "id": id,
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

##### `GET /customers`

- Returns all customers

##### `GET /customers/{customerId}`

- Returns a specific customer whose `id` is `customerId`

##### `POST /customers`

- Creates a new customer with the information given in the request body

- **Request body:**
  
  ```json
  {
    "name": name,
    "email": email,
    "phoneNumber": phoneNumber,
    "password": password
  }
  ```

- Returns an object which represents the new customer and his `id`

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

##### `PUT /customers`

- Updates the information of a specific customer

- The `id` of the customer should be provided in the request body

- **Request body:**
  
  ```json
  {
    "id": id,
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

##### `PUT /customers/{customerId}/subscription`

- Manages the customer's subscription status for a notification type.

- The action can be either `subscribe` or `unsubscribe`.

- **Request parameters:**
  
  - `customerId` (path parameter) – The ID of the customer.
  - `action` (query parameter) – The action to perform (`subscribe` or `unsubscribe`).
  - `type` (query parameter) – The type of notification (`EMAIL`, `SMS`, `PUSH`).

- **Example Request:**
  
  ```
  PUT /customers/1/subscription?action=subscribe&type=EMAIL
  ```

- **Response:**
  
  - `200 OK` if the subscription status is updated.
  - `400 Bad Request` if the parameters are invalid.



##### `GET /customers/{customerId}/subscription`

- Retrieves a list of active notification subscriptions for a customer.

- **Request parameters:**
  
  - `customerId` (path parameter) – The ID of the customer.

- **Example Request:**
  
  ```
  GET /customers/1/subscription
  ```

- **Response body:**
  
  ```json
  [
    "EMAIL",
    "SMS"
  ]
  ```
  
  - Returns a list of notification types the customer is currently subscribed to.

---

### Vendor Controller

##### `GET /vendors`

- Returns all vendors

##### `GET /vendors/{vendorId}`

- Returns a specific vendor whose `id` is `vendorId`

##### `POST /vendors`

- Creates a new vendor with the information given in the request body

- **Request body:**
  
  ```json
  {
    "name": name,
    "phoneNumber": phoneNumber
  }
  ```

- Returns an object which represents the new vendor and his `id`

- **Response body:**
  
  ```json
  {
    "id": id,
    "name": name,
    "phoneNumber": phoneNumber
  }
  ```

##### `PUT /vendors`

- Updates the information of a specific vendor

- The `id` of the vendor should be provided in the request body

- **Request body:**
  
  ```json
  {
    "id": id,
    "name": newName,
    "phoneNumber": newPhoneNumber
  }
  ```

- Returns the vendor object after the update

- **Response body:**
  
  ```json
  {
    "id": id,
    "name": newName,
    "phoneNumber": newPhoneNumber
  }
  ```
