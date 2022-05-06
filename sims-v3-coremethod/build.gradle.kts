import io.polarian.gradle.extensions.getMavenRepository
import io.polarian.gradle.extensions.getPropertyOrDefault
import io.polarian.gradle.extensions.spoonDependency
import io.polarian.gradle.extensions.spoonTestDependency
import io.polarian.gradle.meta.MavenRepo.CONFLUENT

plugins {
    id("polarian-build-plugin") version "1.0.0"
}

group = "co.spoonradio.sims"

repositories {
    mavenCentral()
    getMavenRepository(CONFLUENT)

    maven(url = "https://build.shibboleth.net/nexus/content/repositories/releases/")
    maven(url = "https://repo.spring.io/libs-milestone")
}

polarian {
    jvm = JavaVersion.VERSION_1_8
    serialization = true
    noarg = listOf("software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean")

    spring {
        springBoot {
            version = project.getPropertyOrDefault("springVersion", "2.4.5")
        }
        springCloud {
            version = project.getPropertyOrDefault("springCloudVersion", "2020.0.2")
        }
    }

    aws {
        version = project.getPropertyOrDefault("awsSdkVersion", "2.16.58")
    }

    testcontainers {
        version = project.getPropertyOrDefault("testcontainersVersion", "1.15.2")
    }

    jooq {
        jooqGenerator = listOf("org.jooq:jooq-meta-extensions:3.14.8")

        database {
            name = "MySQLDatabase"
            packageName = "co.spoonradio.sims.repository.mysql"
            targetPath = "src/main/jooq/mysql"
            properties = mapOf("scripts" to "src/main/resources/db/mysql/V00__baseline.sql","defaultNameCase" to "lower")
        }

        database {
            name = "PostgresDatabase"
            packageName = "co.spoonradio.sims.repository.postgresql"
            targetPath = "src/main/jooq/postgresql"
            properties = mapOf("scripts" to "src/main/resources/db/postgresql/V00__baseline.sql", "defaultNameCase" to "lower")
        }

        database {
            name = "BillingDatabase"
            packageName = "co.spoonradio.sims.repository.billing"
            targetPath = "src/main/jooq/billing"
            properties = mapOf("scripts" to "src/main/resources/db/billing/V00__baseline.sql","defaultNameCase" to "lower")
        }

    }


    dependencies {
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.springframework.boot:spring-boot-starter-web"){
            exclude("org.springframework.boot:spring-boot-starter-tomcat")
        }
        implementation("org.springframework.boot:spring-boot-starter-undertow")
        implementation("org.springframework.boot:spring-boot-starter-aop")
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        implementation("org.springframework.boot:spring-boot-starter-validation")
        implementation("org.springframework.boot:spring-boot-starter-data-redis")
        implementation("org.springframework.boot:spring-boot-starter-jta-atomikos")
        implementation("org.hibernate:hibernate-core:5.6.3.Final")

        //implementation("org.hibernate.validator:hibernate-validator:6.1.2.Final")


        implementation("org.springframework:spring-jdbc:5.3.12")
        implementation("net.logstash.logback:logstash-logback-encoder")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
        implementation("com.zaxxer:HikariCP:4.0.3")
        implementation("org.jooq:jooq-meta-extensions:3.14.8")
        implementation("org.redisson:redisson:3.16.1")

        //SWAGGER
        implementation("io.springfox:springfox-swagger2:${property("swaggerVersion")}")
        implementation("io.springfox:springfox-swagger-ui:${property("swaggerVersion")}")

        //FEIGN
        implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
        implementation("io.github.openfeign:feign-okhttp:10.1.0")
        implementation("io.github.openfeign:feign-jackson:9.5.1")

        //AWS
//        implementation("org.springframework.cloud:spring-cloud-starter-aws")
//        compile("com.amazonaws:aws-java-sdk-ses")
        implementation( "software.amazon.awssdk:s3")
        implementation( "software.amazon.awssdk:ses")
        //test
        implementation("com.sun.xml.bind:jaxb-core:2.3.0.1")
        implementation("javax.xml.bind:jaxb-api:2.3.1")
        implementation("com.sun.xml.bind:jaxb-impl:2.3.1")

        //Security / OKTA
        //implementation("org.springframework.boot:spring-boot-starter-security")
        implementation("org.springframework.security.extensions:spring-security-saml-dsl:1.0.0.M3") //Maven 추가
        implementation("org.springframework.security.extensions:spring-security-saml2-core:1.0.10.RELEASE") //Maven 추가


        //JWT-JWK
        implementation("org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure")
        implementation("io.jsonwebtoken:jjwt:0.9.0")
        implementation("com.auth0:java-jwt:3.8.1")

        /*implementation("com.nimbusds:nimbus-jose-jwt:9.15.2")*/
        implementation("io.jsonwebtoken:jjwt-api:${property("jjwtVersion")}")
        implementation("io.jsonwebtoken:jjwt-impl:${property("jjwtVersion")}")
        implementation("io.jsonwebtoken:jjwt-jackson:${property("jjwtVersion")}")



        // Excel
        implementation("org.apache.poi:poi:5.1.0")
        implementation("org.apache.poi:poi-ooxml:5.1.0")

        implementation("co.spoonradio.arch:aws-credentials:1.0.0-RELEASE")
        implementation("co.spoonradio.arch:aws-credentials-spring-boot-autoconfigure:1.0.0-RELEASE")
        implementation("co.spoonradio.arch:aws-credentials-spring-boot-starter:1.0.0-RELEASE")

        spoonDependency("co.spoonradio.arch:spoonradio-common-framework:1.0.0-RELEASE")

        implementation("mysql:mysql-connector-java")
        implementation("org.postgresql:postgresql:42.3.1")

        /** 프로세스 처리 */
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }
    dependencyManagement {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-aws:2.2.1.RELEASE")
        }
    }
}
