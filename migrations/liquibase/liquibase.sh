 #!/bin/bash

java -jar liquibase.jar \
    --driver=com.mysql.jdbc.Driver \
     --classpath=./mysql-connector-java-5.1.38-bin.jar \
     --changeLogFile=../../src/main/resources/liquibase/db-changeLog.xml \
     --url="jdbc:mysql://192.168.33.14:3306/stream" \
     --username=stream \
     --password=stre4m \
     update