@echo off
echo Checking if Docker is running...

docker info >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Docker is not running, starting Docker Desktop...
    start "" "C:\Program Files\Docker\Docker\Docker Desktop.exe"

    echo Waiting for Docker to start...
    :waitloop
    docker info >nul 2>&1
    if %ERRORLEVEL% NEQ 0 (
        echo Still waiting...
        timeout /t 5 >nul
        goto waitloop
    )
)

echo Starting Redis via Docker Compose...
docker ps -a --format "{{.Names}}" | findstr /i "local-redis" >nul
if %ERRORLEVEL% EQU 0 (
    echo Container already exists, starting it...
    docker start local-redis
) else (
    echo Container not found, creating it...
    docker compose up -d
)