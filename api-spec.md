### Api Spec

#### Create Player
Request :
- Method : POST
- Endpoint : `/api/players`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "id" : "string, unique",
  "name" : "string",
  "region" : "string",
  "team" : "string",
  "age" : "int"
}
```
- Response :
```json
{
  "code" : "number",
  "message" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "region" : "string",
    "team" : "string",
    "age" : "int",
    "createdAt" : "date",
    "updateAt" : "date"
  }
}
```

#### Get Player
Request :
- Method : GET
- Endpoint : `/api/players/{id_player}`
- Header :
    - Accept : application/json
- Response :
```json
{
  "code" : "number",
  "message" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "region" : "string",
    "team" : "string",
    "age" : "int",
    "createdAt" : "date",
    "updateAt" : "date"
  }
}
```

#### Update Player
Request :
- Method : PUT
- Endpoint : `/api/players/{id_player}`
- Header :
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "name" : "string",
  "region" : "string",
  "team" : "string",
  "age" : "int"
}
```
- Response :
```json
{
  "code" : "number",
  "message" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "region" : "string",
    "team" : "string",
    "age" : "int",
    "createdAt" : "date",
    "updateAt" : "date"
  }
}
```

#### Delete Player
Request :
- Method : PUT
- Endpoint : `/api/players/{id_player}`
- Header :
    - Accept : application/json
- Response :
```json
{
  "code" : "number",
  "message" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "region" : "string",
    "team" : "string",
    "age" : "int",
    "createdAt" : "date",
    "updateAt" : "date"
  }
}
```

#### List Player
Request :
- Method : GET
- Endpoint : `/api/players`
- Header :
    - Accept : application/json
- Query Param :
    - size : number
    - page : number
- Response :
```json
{
  "code" : "number",
  "message" : "string",
  "data" : [
    {
      "id" : "string, unique",
       "name" : "string",
       "region" : "string",
       "team" : "string",
       "age" : "int",
       "createdAt" : "date",
       "updateAt" : "date"
     }
  ]
}
```