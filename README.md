# URLShrinker

The URLShrinker is a Java software which turns URL hyperlinks, like "https://translate.google.com.br/#en/pt/crops", into a pattern like "http://urlShrinker.com.br/{number}".

Its main part is a web application server that can be tested whether by command line utility or by a web application client.

## Requirements
- JDK 1.8 or later
- Maven 3 or later
- Git
- Curl

If you're using Eclipse or one of its spin-offs, you must install lombok plugin for correctly code compiling. You may install such plugin using the documentation at [Project Lombok](https://projectlombok.org/setup/eclipse).

## Installation

The installation procedure below was tested upon a Ubuntu Linux desktop, version 17.10.

Just after operating system has been installed, the prerequisites software must be installed too. On a Terminal window, run the below command line in order to do it.

`sudo apt install git curl default-jdk maven`


Use Git utility for getting URLShrinker project:

`git clone http://github.com/juliermeGaviao/urlShrinker`


Build URLShrinker with following command lines:

`cd urlShrinker`

`mvn install`


## Runing Server 

The web application server will be initiated with this command line:

`cd server`

`mvn spring-boot:run`


A message like the below one indicates that server's up and running, waiting for requests.

`Started UrlShrinkerServerApplication in x.xxx seconds (JVM running for )`


## Runing JSF Client 

The JSF web application client will be initiated with this command line:

`cd ../jsfClient`

`mvn spring-boot:run`


A message like the below one indicates that JSF client application is up and running, waiting for requests.

`Started UrlShrinkerJSFClientApplication in x.xxx seconds (JVM running for )`


## Runing AngularJS Client 

The AngularJS web application client will be initiated with this command line:

`cd ../angularJSClient`

`mvn spring-boot:run`


A message like the below one indicates that AngularJS client application is up and running, waiting for requests.

`Started UrlShrinkerAngularJSApplication in x.xxx seconds (JVM running for )`


## Runing VueJS Client 

The VueJS web application client will be initiated with this command line:

`cd ../vueClient`

`mvn spring-boot:run`


A message like the below one indicates that AngularJS client application is up and running, waiting for requests.

`Started UrlShrinkerVueClientApplication in x.xxx seconds (JVM running for )`


## Command Line Endpoints Testing 

A little set of users and URLs was built into URLShrink during its startup. Using curl utility command line at the Terminal window, all project endpoints can be tested.

#### GET /urls/:id

It returns URL statistics pointed at the parameter out.

`curl -w '\n' http://localhost:8080/urls/1`

produces:

`{"id":1,"hits":3,"url":"http://www.google.com.br","shortUrl":"http://urlShrinker.com.br/1518453446632"}`

#### POST /users/:userid/urls

This endpoint add a new URL to a specific user which identifier is passed through parameter named "userId".

`curl -w '\n' -X POST -d '["http://www.terra.com.br"]' -H "Content-Type: application/json" http://localhost:8080/users/3/urls`

gets:

`[{"id":1,"hits":1,"url":"http://www.google.com.br","shortUrl":"http://urlShrinker.com.br/1518588988040"},{"id":3,"hits":1,"url":"http://www.terra.com.br","shortUrl":"http://urlShrinker.com.br/1518588998847"}]`

#### GET /stats

It gets overall system statistics.

`curl -w '\n' http://localhost:8080/stats`

produces:

`{"hits":5,"urlCount":2,"topUrls":[{"id":1,"hits":3,"url":"http://www.google.com.br","shortUrl":"http://urlShrinker.com.br/1518453446632"},{"id":2,"hits":2,"url":"http://www.amazon.com","shortUrl":"http://urlShrinker.com.br/15184534466321"}]}`

#### GET /users/:userId/stats

It gets urls statistics for a specific user specified by parameter "userId".

`curl -w '\n' http://localhost:8080/users/2/stats`

produces:

`[{"id":1,"hits":1,"url":"http://www.google.com.br","shortUrl":"http://urlShrinker.com.br/1518453446632"},{"id":2,"hits":1,"url":"http://www.amazon.com","shortUrl":"http://urlShrinker.com.br/15184534466321"}]`

#### GET /stats/:id

It returns URL statistics for an URL specified at the parameter "id".

`curl -w '\n' http://localhost:8080/urls/2`

gets:

`{"id":2,"hits":2,"url":"http://www.amazon.com","shortUrl":"http://urlShrinker.com.br/15184534466321"}`

#### DELETE /urls/:id

It removes an URL. That one whose identifier is equal to the "id" parameter value.

`curl -w '\n' -X DELETE http://localhost:8080/urls/2`

gets as result:

`Url successfully deleted!`

#### POST /users/:username

It creates a new user with name of the parameter "username".

`curl -w '\n' -X POST http://localhost:8080/users/Kate`

gets:

`{"id":4,"userName":"Kate","userUrls":[]}`

#### DELETE /user/:userId

It removes an user with identifier of the parameter "userId".

`curl -w '\n' -X DELETE http://localhost:8080/user/4`

returns:

`User successfully deleted!`


## Web Browser Client Testing (JSF)

Alternatively, the URLShrinker server can be tested through a Web Browser. At the favorite Web Browser, hit the following URL:

`http://localhost:9090/urlShrinkerJSF/index.xhtml`

## Web Browser Client Testing (AngularJS)

Other way of testing the URLShrinker server is hitting the following URL, which is developed in AngularJS:

`http://localhost:7070/urlShrinkerAngularJS/home`

## Web Browser Client Testing (VueJS)

The newest way of testing the URLShrinker server is hitting the following URL, which is developed in VueJS:

`localhost:6060/urlShrinkerVue/`
