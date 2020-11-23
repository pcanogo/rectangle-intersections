# Rectangle 

## Prerequisites
* [Maven]: Tool for building, managing and testing Java proyects.

### Run Tests
To execute all tests simply run within the base directoy the following command:
```sh
$ mvn verify
```
You can run a specific test file with:
```sh
$ mvn test -Dtest={Test File}#{Method}
```
and to run a certain test within specific file:
```sh
$ mvn test -Dtest={Test File}
```
All tests are found within `/src/test/java/com/pablo/intersections/`. Available tests files are:
  - IntersecterTest.java
  - IntersectionsComputerTest.java
  - IntersectRectangleTest.java
  - PointTest.java
  - RectangleFactoryTest.java
  - RectangleTest.java
  - RectUtils.java
  - RegisterTest.java
 
### Build 
Since this proyect uses [Gson], you can build an uber-jar containing all dependencies with:
```sh
$ mvn clean compile assembly:single
```
this builds a Jar file in a `/target/` directory named `rectangle-intersections-1.0.0.jar-with-dependencies.jar`

### Run
In order for the program to run it requires a path to a json file as an argument. Some example files are provided in the root directory. If you use any of those files simply provide the name of the file as an argument ex:`rects.json`.  

To run the application execute:
```sh
$ java -cp <Path to Jar> com.pablo.intersections.Main rects.json
```


[Maven]: <https://maven.apache.org/install.html.>
[Gson]: <https://github.com/google/gson.>
