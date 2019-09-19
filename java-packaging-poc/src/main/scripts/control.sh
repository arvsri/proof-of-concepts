#!/bin/bash

echo "Executing the tests ........."
java -cp data/:lib/*:module/* com.arvindsrivastava.poc.TestMain
