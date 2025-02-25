Project Structure
src/
├── main/
│   ├── java/
│   │   └── com/example/freemarkercrud/
│   │       ├── model/            # Entity classes
│   │       ├── dto/              # DTO classes
│   │       ├── mapper/           # Mappers using @Mapper (MapStruct)
│   │       ├── selector/         # Selector for filtering
│   │       ├── repository/       # Repository for DB operations
│   │       ├── service/          # Business logic services
│   │       └── controller/       # Controllers for request handling
│   ├── resources/
│       └── templates/            # FreeMarker templates
└── build.gradle
