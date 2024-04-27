FROM bellsoft/liberica-openjdk-alpine:21

#set up working directory
WORKDIR /home/selenium-docker
#copy file
ADD target/docker-resources .

#Run the tests
ENTRYPOINT  java -cp "libs/*" \
                    -Dbrowser=${BROWSER} \
                    -Dselenium_grid_enable=true \
                    -DhubUrl=${GRID_URL} \
                     org.testng.TestNG \
                     test-suits/vendors-portal.xml