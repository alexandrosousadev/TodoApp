# Use a imagem oficial do Java
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copia o código fonte do projeto para o container
COPY . /app

# Execute o build usando Gradle para gerar o JAR
RUN ./gradlew build

# Copia o arquivo JAR gerado pelo build para o container
COPY build/libs/*.jar /app/app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
