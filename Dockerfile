# Use an official Java 17 image
FROM eclipse-temurin:17-jdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the project files into the container
COPY . .

# Grant execution permissions to the Maven wrapper
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Create a new, smaller image to run the application
FROM eclipse-temurin:17-jre AS runtime

WORKDIR /app

# Copy the built JAR file from the previous step
COPY --from=build /app/target/eventar-0.0.1-SNAPSHOT.jar app.jar

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
