@echo off
setlocal

:: Spostati nella cartella config/windows per sicurezza, oppure usa il percorso relativo
cd /d "%~dp0"

:: Controlla se docker compose è disponibile (puntando al file un livello sopra con -f)
docker compose version >nul 2>&1
if %errorlevel% equ 0 (
    set "COMPOSE_CMD=docker compose -f ../compose.yml"
) else (
    docker-compose version >nul 2>&1
    if %errorlevel% equ 0 (
        set "COMPOSE_CMD=docker-compose -f ../compose.yml"
    ) else (
        echo Errore: Docker Compose non e' installato sul sistema.
        pause
        exit /b 1
    )
)

echo Avvio dell'ambiente in corso, attendere...
:: Avvia i container in background
%COMPOSE_CMD% up -d

echo.
echo Operazione completata! Il server è in ascolto sulla porta 8080...
pause >nul

:: Quando l'utente preme un tasto, ferma e rimuove i container
echo Arresto dei container in corso...
%COMPOSE_CMD% down
echo Ambiente arrestato.
