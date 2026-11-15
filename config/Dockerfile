FROM eclipse-temurin:25-jdk

WORKDIR /app

# Copia tutto il progetto dentro il contenitore
COPY . .

# Diamo i permessi per eseguire il file mvnw
RUN chmod +x mvnw

# ATTENZIONE QUI: Usiamo ./mvnw invece di mvn !
ENTRYPOINT ["./mvnw", "spring-boot:run"]
