# ChessTest Backend
#### _By JPN_
ChessTest requires last version of [Maven](https://maven.apache.org/) to run.

## Installation

Download code from [this repository](https://github.com/jpnicotra/ChessTestBackend.git) and start command line in this project directory

First of all you must install [ChessTest](https://github.com/jpnicotra/ChessTest.git) since it is a library dependency for this project.

Install maven dependencies
```sh
mvn clean install
```

## Deployment

```sh
deploy or install file  .\target\ChessTestBackend-0.0.1-SNAPSHOT.war in your local application server 
```

## Features

- This application will expose ChessTest funcionallity as REST Webservices.
- No security or CORS restrictions by now, since this is for researching purpose

## Tech

ChessTest uses a number of open source projects to work properly:

- [Wildfly] - version 21
- [JDK] - version 1.8



## License

MIT
