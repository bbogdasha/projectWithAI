# Documentation: Country Information Application

The Country Information Application is a Java-based web application developed using Java 17 and Spring Boot 3.1.0. It utilizes the capabilities of ChatGPT 3.5 for development and assistance in the development process.

### Overview

The application serves as a consumer of a public API **https://restcountries.com/v3.1/all** that provides JSON data about various countries. This API offers a wide range of information, including country names, population, currencies, languages, and more. The application exposes a single controller method, **'getCountries'**, which accepts four optional parameters: **'name'**, **'population'**, **'order'**, and **'size'**.

Example of a country in the received JSON format:
```json
{
  "name": {
    "common": "United States of America",
    "official": "United States of America",
    "nativeName": {
      "eng": {
        "official": "United States of America",
        "common": "United States of America"
      }
    }
  },
  "population": 331002651,
  "area": 9629091,
  "capital": [
    "Washington, D.C."
  ],
  "languages": {
    "eng": "English"
  },
  "currencies": {
    "USD": {
      "name": "United States dollar",
      "symbol": "$"
    }
  },
  ...
}

```

### Controller and Service Functionality

The **'getCountries'** method of the controller acts as the entry point for retrieving country information. Depending on the provided parameters, the method internally invokes different service methods to perform the desired operations. The available service methods are as follows:

1. **'getCountriesByName'**: Retrieves a list of countries based on the specified name parameter.
    <br><br>
2. **'getCountriesByPopulation'**: Filters the list of countries by the specified parameter using the formula (country.population < N * 1000000)
   <br><br>
3. **'sortCountriesByOrder'**: Sorts the countries in ascending or descending order based on the name field.
   <br><br>
4. **'limitCountries'**: Limits the number of countries returned based on the size parameter.

### Validation and Unit Testing

The application incorporates exception handling through an **'ExceptionHandler'** component. It captures and handles any errors or exceptions that may occur during the execution of the application, providing appropriate error messages to the client.

Each service method includes validation checks to ensure the provided input parameters are valid. If an invalid parameter is detected, a **'CountriesParameterValidateException'** is thrown with an accompanying error message.

The application also includes unit tests implemented using JUnit. These tests cover various scenarios and verify the correctness of the individual components, such as the service methods, validation logic, and exception handling.

---

### Deployment Steps

To deploy the Country Information Application, follow these steps:

1. Extract the application archive to a desired location on your computer.

2. Open the chosen development environment (IntelliJ IDEA, Eclipse, etc.) and import the extracted project as an existing Maven project.

3. Allow the development environment to resolve the project's dependencies and configure the project structure.

4. Once the project is successfully imported, navigate to the terminal window within the development environment.

5. Run the following command to build and run the application. This command compiles the source code, resolves dependencies, and starts the application using Spring Boot.
```shell
mvn spring-boot:run
```

7. Wait for the application to start successfully. Once it is up and running, you should see a message indicating that the application has started and is listening for incoming requests.

7. Open a web browser and access the application using the provided URL. By default, the application runs on http://localhost:8080/countries.

8. You can now interact with the Country Information Application through the available endpoints, providing the appropriate parameters to retrieve the desired country information.

### Running Tests

To run the application's tests, follow these additional steps:

1. Ensure that the application is not currently running.

2. Open the terminal window within the development environment.

3. Run the following command to execute the tests. This command compiles the source code, executes the tests, and generates the test report:
```shell
mvn clean package
```
4. Wait for the tests to complete. The test results will be displayed in the terminal, indicating the number of tests executed and their status (passing or failing).

---

### Information API Examples

The Country Information API provides various endpoints to retrieve information about countries. This documentation presents 10 examples demonstrating the usage of the controller's methods. Each example includes the request endpoint and the corresponding response.

##### Example 1: Get All Countries (No Parameters)

***Request***

* Endpoint: **/countries**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 2: Get Countries by Name

***Request***

* Endpoint: **/countries?name=usa**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 3: Get Countries by Population

***Request***

* Endpoint: **/countries?pop=100**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 4: Sort Countries in Ascending Order

***Request***

* Endpoint: **/countries?order=asc**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 5: Sorting Countries in Descending Order

***Request***

* Endpoint: **/countries?order=desc**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 6: Limit Countries by Size

***Request***

* Endpoint: **/countries?size=2**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 7: Get Countries by Name and Sort in Ascending Order

***Request***

* Endpoint: **/countries?name=st&order=asc**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 8: Get Countries by Population and Sort in Descending Order

***Request***

* Endpoint: **/countries?pop=5&order=desc**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 9: Get Countries by Name, Sort in Descending Order and Limit size

***Request***

* Endpoint: **/countries?name=st&order=desc&size=5**
* Method: GET

***Response***

* Status Code: 200 (OK)
* Body: JSON

---

##### Example 10: Any validation error

***Request***

* Endpoint: **/countries?name=123**
* Method: GET

***Response***

* Status Code: 400 (BAD_REQUEST)
* Body: JSON