@echo off
echo === Starting Development Environment ===

:: Start Postgres service
call start_postgres.bat

:: Start Redis
call start_redis.bat

:: Open IntelliJ
call start_intellij.bat

echo === All components started! ===
pause
