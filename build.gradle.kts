plugins {
    id("java")
}

group = "org.itsscellammarelamonaca"
version = "1.0"

repositories {
    mavenCentral()
}




dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    testImplementation("junit:junit:4.13.2")
    testImplementation("net.jqwik:jqwik:1.7.3")
}

tasks.test {
    useJUnitPlatform {
        includeEngines("jqwik")
    }
}

