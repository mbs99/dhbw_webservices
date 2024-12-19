FROM debian as build
RUN useradd -m graal
USER graal
WORKDIR /home/graal
ADD pom.xml .
ADD src src
RUN curl -s "https://get.sdkman.io" | bash
RUN ls -lisa
RUN ". .sdkman/bin/sdkman-init.sh" && sdk use java 21-graalce
RUN mvn -Pnative native:compile -DskipTests
