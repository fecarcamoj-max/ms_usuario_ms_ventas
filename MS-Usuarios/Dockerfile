### Proceso de compilación de APP Java.
# BUILD - IMAGEN INICIAL
FROM maven:3.9.9-eclipse-temurin-21 AS builder

#Nos posicionamos en el directorio principal de la imagen/app /desde donde se genera el compilado.
#carpeta raíz llamada app. - crear directorio app
WORKDIR /app

# Desde la repo original, tomamos pom y lo llevamos a la raíz del proyecto .
COPY pom.xml .

# Correr dependencias offline / sin depender de internet.
RUN mvn dependency:go-offline

# Tomo la carpeta src y me la llevo al contenedor
COPY src ./src

### Pruebas unitarias.
### Si hay error en los despliegues, notificar.

#Se limpia la compilación anterior, y se ejecuta la compulación saltandose las pruebas unitarias.
RUN mvn -B clean package -DskipTests

######## FIN proceso compilación
######## Después de haber compilado, hay que ejecutar.
### Nos preocupamos del despliegue de la app

# Imagen desde donde se ejecutará el compilador anterior.
FROM eclipse-temurin:21-jre

# Nos posicionamos en app donde estará la compilación
WORKDIR /app

# Tomamos los *.jar y nos llevamos /app de eclipse21jre el archivo app.jar
COPY --from=builder /app/target/*.jar app.jar

# Se expone el puerto de la máquina que usará la app java.
EXPOSE 8181

# Se ejecuta la aplicación java.
ENTRYPOINT ["java", "-jar", "app.jar"]
