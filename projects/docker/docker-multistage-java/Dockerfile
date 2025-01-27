FROM debian as builder
RUN apt-get update
RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN apt-get install -y curl zip gcc zlib1g-dev
RUN curl -s "https://get.sdkman.io" | bash
RUN chmod +x /root/.sdkman/bin/sdkman-init.sh
RUN source /root/.sdkman/bin/sdkman-init.sh && sdk install java 24.1.1.r23-nik
RUN source /root/.sdkman/bin/sdkman-init.sh && sdk install maven 3.9.6
RUN mkdir /app
WORKDIR /app
ADD pom.xml .
ADD src src
RUN source /root/.sdkman/bin/sdkman-init.sh && mvn -Pnative native:compile
FROM alpine
RUN apk update
RUN apk add gcompat
COPY --from=builder /app/target/demo /app/demo
RUN chmod +x /app/demo
CMD ["/app/demo"]
