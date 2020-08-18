Calculator Java Task with basic operations: add, subtract, multiply.

Based on Factory design pattern to provide easy integration with other systems.

Task implemented on Java Spring Boot 2.2.7 with help of Intellij IDEA.
and jUnit tests cover the different positive and negative scenarios.

Logic implemented with Api endpoints controller.

Queries and 2 input parameters:

1. to make 'Add' operation:
http://localhost:8081/api/add?first=2&second=3

2. to make 'Subtract' operation:
http://localhost:8081/api/subtract?first=2&second=3

3. to make 'Multiply' operation:
http://localhost:8081/api/multiply?first=2&second=3


to start application with console:
java -jar -Dserver.port=8081 target/calculator-0.0.1-SNAPSHOT.jar
