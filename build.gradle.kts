plugins {
    id("java")
}

group = "br.com.iterasys"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.1.0")
    testImplementation("org.testng:testng:7.7.1") // Teste de unidade
    testImplementation("io.rest-assured:rest-assured:5.3.0") // Teste de API
    implementation("org.seleniumhq.selenium:selenium-java:4.13.0")
    implementation("io.cucumber:cucumber-java:7.11.0")
    implementation("io.cucumber:cucumber-testng:7.11.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.4.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.slf4j:slf4j-api:1.7.33")


}

tasks.test {
    useTestNG()
}