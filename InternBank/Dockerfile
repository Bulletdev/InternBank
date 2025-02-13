# Usa uma imagem base do OpenJDK Zulu 17
FROM azul/zulu-openjdk:17

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR gerado pelo Maven para dentro do container
COPY target/InternBank-0.0.1-SNAPSHOT.jar app.jar

# Define as variáveis de ambiente para conexão com o SQL Server
ENV SPRING_DATASOURCE_URL=jdbc:sqlserver://internbank.database.windows.net:1433;database=internbank;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
ENV SPRING_DATASOURCE_USERNAME=loirena
ENV SPRING_DATASOURCE_PASSWORD=${SPRING_DATASOURCE_PASSWORD}
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

# Expõe a porta 8082 para comunicação com o frontend Angular
EXPOSE 8082

# Comando para rodar a aplicação
CMD ["java", "-jar", "app.jar"]
