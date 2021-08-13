#!/bin/bash

echo "Performing a clean build"
cd industrial-ref-service
./gradlew clean build -x test
cd ..
cd gateway
./gradlew clean build -x test
cd ..

echo "Building the UAA"
cd uaa
docker build --tag gateway-demo-uaa .
cd ..

echo "Building the Service"
cd industrial-ref-service
docker build --tag gateway-demo-industrial-ref-service .
cd ..

echo "Building the Gateway"
cd gateway
docker build --tag gateway-demo-gateway .
cd ..


