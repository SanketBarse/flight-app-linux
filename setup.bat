@echo off

echo Running 'mvn clean'...
mvn clean
if errorlevel 1 (
    echo Error: 'mvn clean' failed.
    pause
    exit /b 1
)

echo Running 'mvn package -DskipTests'...
mvn package -DskipTests
if errorlevel 1 (
    echo Error: 'mvn package -DskipTests' failed.
    pause
    exit /b 1
)

echo Running 'docker-compose up'...
docker-compose up
if errorlevel 1 (
    echo Error: 'docker-compose up' failed.
    pause
    exit /b 1
)

echo Running 'docker-compose down'...
docker-compose down
if errorlevel 1 (
    echo Error: 'docker-compose down' failed.
    pause
    exit /b 1
)

echo All commands executed successfully.
pause
exit /b 0
