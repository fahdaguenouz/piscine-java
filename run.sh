#!/bin/bash

# Check if folder name is provided as an argument
if [ -z "$1" ]; then
    echo "Please provide the folder name containing the Java program."
    exit 1
fi

# Get the folder name from the first argument
PROGRAM_DIR="$1"

# Check if the folder exists
if [ ! -d "$PROGRAM_DIR" ]; then
    echo "Directory '$PROGRAM_DIR' does not exist."
    exit 1
fi

# Navigate to the program directory
cd "$PROGRAM_DIR" || exit

# Check if the directory contains Java files
if ! ls *.java &> /dev/null; then
    echo "No Java files found in the directory '$PROGRAM_DIR'."
    exit 1
fi

# Create the build directory if it doesn't exist
BUILD_DIR="build"
mkdir -p "$BUILD_DIR"

# Compile the Java files
echo "Compiling Java files in '$PROGRAM_DIR'..."
javac *.java -d "$BUILD_DIR"

# Check if the compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
    
    # Check if ExerciseRunner exists and run it
    if [ -f "$BUILD_DIR/ExerciseRunner.class" ]; then
        echo "Running ExerciseRunner..."
        java -cp "$BUILD_DIR" ExerciseRunner
    else
        echo "ExerciseRunner class not found in the build directory."
        exit 1
    fi
else
    echo "Compilation failed."
    exit 1
fi
