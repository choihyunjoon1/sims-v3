include Envfile
include ~/.gradle/gradle.properties

VARS:=$(shell sed -ne 's/ *\#.*$$//; /./ s/=.*$$// p' Envfile )
$(foreach v,$(VARS),$(eval $(shell echo export $(v)="$($(v))")))

dockerBuild:
		docker build . -t ${APPLICATION_NAME} --build-arg PRIVATE_MAVEN_USER=${privateMavenUser} --build-arg PRIVATE_MAVEN_TOKEN=${privateMavenToken}

dockerRun:
		docker run --rm -p ${HOST_PORT}:${SERVER_PORT} -t ${APPLICATION_NAME}

build:
		./gradlew build

clean:
		./gradlew clean

run:
		./gradlew bootRun

cloudRun:
		./gradlew bootRun --args="--spring.profiles.active=${AWS_REGION}"

tests:
		./gradlew clean test --stacktrace

assemble:
		./gradlew clean assemble
