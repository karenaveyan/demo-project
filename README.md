# demo-project

The application has one POST endpoint which does some transformation on requestBody.

Items should be written in snake_case. The endpoint removes duplicates and transforms the items to camelCase.

Swagger URL: http://localhost:8080/swagger-ui.html#/

Request Sample:

        {
            "name": "Something",
            "items": [
                "hi",
                "hi",
                "hello_world",
                "hello_world",
                "word",
                "this_is_an_application"
            ]
        }

Response Sample:

        {
            "name": "Something",
            "items": [
                "hi",
                "helloWorld",
                "word",
                "thisIsAnApplication"
            ],
            "timeStamp": 1647273720392
        }
