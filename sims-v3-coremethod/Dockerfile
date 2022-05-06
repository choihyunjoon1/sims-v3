# application
FROM stpolarian/alpine-jdk-jre8
MAINTAINER danny@spoonradio.co

ENV APPLICATION_NAME=${APPLICATION_NAME:-NO-NAME} \
    SERVER_PORT=${SERVER_PORT:-8080} \
    CONFIG_SERVER_URL=${CONFIG_SERVER_URL:-http://config.server.url} \
    ACTIVE_PROFILE=${ACTIVE_PROFILE:-} \
    AWS_REGION=${AWS_REGION:-} \
    JAVA_INIT_MEM_RATIO=${JAVA_INIT_MEM_RATIO:-50}

ADD build/libs/*.jar /deployments/app.jar

EXPOSE ${SERVER_PORT:-8080}
