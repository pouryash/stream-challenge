# stream Challenge

stream test project to work with Spring framework and Bulk data processing.

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)



## Getting Started

Instructions for setting up the project locally.

### Prerequisites

 - install and run cassandra in localhost:9042
 - run /stream-challenge/externalconfig/sql/DDL.sql in cassandra to create KEYSPACE
 - install and run kafka in localhost:9092


### Installation

- cd stream-challenge
- ./mvnw clean package
- ./mvnw spring-boot:run


