#!/bin/bash

appRunning=1

while [ $appRunning == 1 ]; do
    echo "Compiling..."
    #Complile
    javac $(find . -name '*.java') -d bin

    if [ $? -ne 0 ]
    then
        echo "ERROR: Compile failed!"
        exit 1
    else
        #Run
        java -cp bin Main
        exit
    fi
done