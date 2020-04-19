plugins {
    java
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.glassfish.jersey.core", "jersey-client", properties["version.jersey"].toString())
    implementation("org.glassfish.jersey.core", "jersey-server", properties["version.jersey"].toString())
    implementation("org.glassfish.jersey.containers", "jersey-container-jdk-http", properties["version.jersey"].toString())
    implementation("org.glassfish.jersey.containers", "jersey-container-servlet-core", properties["version.jersey"].toString())
    implementation("org.glassfish.jersey.inject", "jersey-hk2", properties["version.jersey"].toString())
    implementation("org.glassfish.jersey.media", "jersey-media-moxy", properties["version.jersey"].toString())

    implementation("javax.servlet", "javax.servlet-api", properties["version.servlet"].toString())
    implementation("javax.xml.bind", "jaxb-api", properties["version.jaxb"].toString())
    implementation("javax.activation", "activation", properties["version.activation"].toString())

    implementation("com.netflix.hystrix", "hystrix-core", properties["version.hystrix"].toString())
    implementation("com.netflix.hystrix", "hystrix-metrics-event-stream", properties["version.hystrix"].toString())
    implementation("com.netflix.hystrix", "hystrix-metrics-event-stream-jaxrs", properties["version.hystrix"].toString())

    implementation("org.slf4j", "slf4j-simple", properties["version.slf4j"].toString())
}

configure<ApplicationPluginConvention> {
    mainClassName = "io.lucasvalenteds.jaxrs.hystrix.Main"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
