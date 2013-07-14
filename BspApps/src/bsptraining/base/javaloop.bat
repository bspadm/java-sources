@echo off
rem **********************************************
rem * Windows batch file for testing Choice.java *
rem **********************************************

:while

    rem Call java program "Choice": Loop (0) or end (9)
    java -jar "C:\NetBeans\Schulung\java-sources\BspApps\dist\BspApps.jar"

    rem Print error level (return code)
    echo %ERRORLEVEL%

    rem Close CMD Window on end
    rem IF "%ERRORLEVEL%"=="9" EXIT

    rem End loop on end
    IF "%ERRORLEVEL%"=="9" GOTO wend

    GOTO while

:wend
