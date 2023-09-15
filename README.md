# OpenAPI Contract First  Example Project

This is a project containing an OpenAPI specification according to which API classes are automatically generated during each compilation to help you to create your own Rest service simpler. It demonstrates Contract First approach.

## Installation

Check [Gradle](https://gradle.org/) is installed and configured

Clone the source locally:
```
$ git clone https://github.com/MorkovkAs/openapi-example-toys-autogen/
```
Build and run project:
```
$ cd openapi-example-toys-autogen/
$ ./gradlew build bootRun
```
Go to [localhost](http://localhost:8080/swagger-ui/index.html) page to see Swagger UI with Toys shop OpenAPI specification. Methods createToy, getToyById and deleteToyById have custom realizations. Others haven't. So http code 501 (NOT_IMPLEMENTED) will return.

## Details
Generated classes are located in `build/generated/openapi/src`.

To use generated code you should create your custom controller which implements a generated one. See [ToysController](src/main/kotlin/ru/morkovka/openapi/test/controller/ToysController.kt) class.

## Thanks!
Any questions or problems give me a shout on email avklimakov@gmail.com

## License
Copyright 2023 Anton Klimakov\
Licensed under the Apache License, Version 2.0