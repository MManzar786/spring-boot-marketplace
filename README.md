# Java and Angular Based Ecommerce Project Readme (Backend)
This is an ecommerce project that allows users to browse products,search products,filter by  add them to their cart, and place orders..

## Table of Contents
1.  <a href="#l1">Introduction</a>
2.  <a href="#l2">How to Run</a>
3.  <a href="#l3">Design Patterns</a>
4.  <a href="#l4">Why these Design Patterns?</a>
5.  <a href="#l5">Api Endpoints</a>
6.  <a href="#l6">Conclusion</a>
7.  <a href="#l7">License</a>

## <h2 id="l1">Introduction</h2>
This is an ecommerce project that provides features such as displaying products on the home page, adding products to the cart, viewing the cart, and placing an order through checkout.Project is implemented using: 
<li>Spring Boot for backend development</li>
<li>JPA repository for database access</li>
<li>Maven for project management</li>

## <h2 id="l2">How to Run</h2>
To run this project, you'll need to have Java and Maven installed. Then, follow these steps:

<li>Clone the repository: git clone https://github.com/MManzar786/spring-boot-marketplace.git</li>
<li>Navigate to the project directory: cd spring-boot-marketplace</li>
<li>Build the project: mvn package</li>
<li>Run the project: java -jar target/spring-boot-marketplace-1.0.0.jar</li>
<li>Open your web browser and go to http://localhost:8080 to view the application</li>

## <h2 id="l3">Design Patterns</h2>
<h3>Model-View-Controller (MVC):</h3>
The MVC pattern is used to separate the application's concerns into three distinct components: the model, the view, and the controller. In this project, the controller layer handles incoming requests, the service layer contains business logic, the repository layer communicates with the database, and the entity layer defines the data model.

<h3>Repository Pattern:</h3>
The repository pattern is used to abstract away the database implementation from the rest of the application. In this project, the repository layer uses JPA to access the database and provides methods for creating, reading, updating, and deleting entities.

## <h2 id="l4">Why These Patterns Were Used</h2>
<li>The MVC pattern was chosen for its clear separation of concerns, which makes it easier to maintain and scale the application.</li>
<li>By separating concerns, MVC applications are easier to update over time.</li>
<li>Respository pattern was used becasue it separates the concerns of data access and business logic, making the code more modular</li>
<li>The repository pattern was chosen because it makes easier to add new data sources and data access logic.</li>


## <h2 id="l5">Conclusion:</h2>
This ecommerce project uses the Model-View-Controller (MVC) design pattern to provide a clear separation of concerns between different components of the application. The project has four layers: controller layer, service layer, repository layer, and entity layer. The stack used for implementation is Spring Boot with JPA repository and Maven. The project provides features such as displaying products on the home page, adding products to the cart, viewing the cart, and placing an order through checkout.

## <h2 id="l6">License:</h2>
This project is licensed under the MIT License - see the LICENSE file for details.
