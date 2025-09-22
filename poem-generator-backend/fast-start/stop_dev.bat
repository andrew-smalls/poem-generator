@echo off
echo Stopping Redis...
docker compose down

echo Stopping Docker service...
net stop com.docker.service

echo Stopping Postgres service...
net stop postgresql-x64-16

echo Done!
pause