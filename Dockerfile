FROM bellsoft/liberica-openjdk-alpine:21


RUN apk add curl jq

#set up working directory
WORKDIR /home/selenium-docker
#copy file
ADD target/docker-resources .
ADD runner.sh runner.sh

# #Run the tests
ENTRYPOINT sh runner.sh
#ENTRYPOINT java -cp "l3ibs/*" \
#               -Dbrowser=${BROWSER} \
#               -Dselenium_grid_enable=true \
#               -Dselenium_grid_hub_host=${HUB_HOST} \
#               org.testng.TestNG \
#               test-suits/flight-app-suite.xml