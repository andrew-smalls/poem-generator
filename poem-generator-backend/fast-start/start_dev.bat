@echo off

echo Changing directory to project root...
cd /d "C:\Users\andre\IdeaProjects\itec2023\poem-generator-backend\fast-start\"

echo === Starting Development Environment ===

:: Start Postgres service
call start_postgres.bat

:: Start Redis
call start_redis.bat

:: Open IntelliJ
call start_intellij.bat

echo === All components started! ===
pause
