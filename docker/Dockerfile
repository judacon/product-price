# Etapa de compilación
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

# Clonar el código fuente desde el repositorio Git
RUN apt-get update && apt-get install -y git
RUN git clone -b develop --single-branch https://github.com/judacon/product-price.git .

# Instalar dependencias y construir el proyecto
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:17-slim
WORKDIR /app

# Copiar el archivo JAR construido desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto en el que se ejecuta la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
