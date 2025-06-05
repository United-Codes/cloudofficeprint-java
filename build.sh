#!/usr/bin/env bash
set -e


# 0) Ensure we’re running inside the directory/folder where this script lives
cd "$(dirname "$0")"

echo "------------------------------------------------------------"
echo " cloudofficeprint-java: Build Script"
echo "------------------------------------------------------------"
echo
# 1) Check Java version
java -version
#echo

# 2) Clean the Gradle project
echo "[2] Cleaning previous build artifacts (./gradlew clean)..."
./gradlew clean
echo "Clean complete."
echo

# 3) Compile, run tests, and build everything
echo "[3] Running 'gradlew build' (compile + tests + create JAR)..."
./gradlew build
echo " Build complete. (includes tests, classes, and default JAR in build/libs/)"
echo

# 4) ProduceJAR (if not already produced by 'build')
echo "[4] Producing JAR via 'gradlew jar'..."
./gradlew jar
echo "JAR generated at 'build/libs/' (look for cloudofficeprint-<version>.jar)."
echo

# 5) Generate Javadoc
echo "[5] Generating Javadoc via 'gradlew javadoc'..."
./gradlew javadoc
echo "Javadoc generated at 'build/docs/javadoc/'."
echo

echo "------------------------------------------------------------"
echo " All steps completed !"
echo "• JAR is in:    build/libs/"
echo "• Javadoc is in: build/docs/javadoc/"
echo "------------------------------------------------------------"
