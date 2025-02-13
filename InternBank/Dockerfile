FROM maven:3.8.4-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM mcr.microsoft.com/mssql/server:2019-latest
ENV SA_PASSWORD=loirena
ENV ACCEPT_EULA=Y
COPY --from=build /usr/src/app/target/seu-projeto.jar /usr/app/seu-projeto.jar

COPY ../init.sql /usr/app/init.sql

CMD /bin/bash -c "/opt/mssql/bin/sqlservr & sleep 30 && /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P $SA_PASSWORD -d master -i /usr/app/init.sql && tail -f /dev/null"
