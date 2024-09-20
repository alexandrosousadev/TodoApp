# Use a imagem oficial do Java (escolha a versão necessária para o seu projeto)
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho no container
WORKDIR /app

# Copia o arquivo JAR gerado pelo build para o container
COPY target/seu-jar-file.jar /app/app.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
