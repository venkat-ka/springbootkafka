In EmailNotification folder application properties

**Error in console and similar to this**
] Connection to node -2 (host.docker.internal/192.168.1.103:9094) could not be established. Broker may not be available.
[2m2024-11-26T13:15:41.033+05:30[0;39m [33m WARN[0;39m [35m16968[0;39m [2m---[0;39m [2m[EmailNotificationService]
[Consumer clientId=consumer-product-created-events-8, groupId=product-created-events] Bootstrap broker host.docker.internal:9094 (id: -2 rack: null) disconnected

**Fix**
spring.kafka.consumer.bootstrap-servers=127.0.0.1:9092,127.0.0.1:9094

**full application properties file in EmailNotification service**

server.port=0
spring.application.name=EmailNotificationService
spring.kafka.consumer.bootstrap-servers=127.0.0.1:9092,127.0.0.1:9094
#spring.kafka.consumer.key-deserializer = org.apache.kafka.common.serialization.StringDeserializer
#spring.kafka.consumer.value-deserializer= org.springframework.kafka.support.serializer.JsonDeserializer
#spring.kafka.consumer.group-id=product-created-events

consumer.group-id=product-created-events
spring.kafka.consumer.properties.spring.json.trusted.packages=com.springkafka.core
spring.devtools.remote.restart.enabled=false

spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

**In ProductMicroservice**
spring.application.name=ProductMicroservice
server.port=6666
spring.kafka.bootstrap-servers=0.0.0.00:9092,0.0.0.00:9094
spring.kafka.producer.bootstrap-servers=host.docker.internal:9092,host.docker.internal:9094
#spring.kafka.producer.bootstrap.servers=host.docker.internal:9092,host.docker.internal:9094
spring.kafka.producer.key-serializer=org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer=org.springframework.kafka.support.serializer.JsonSerializer
spring.kafka.producer.acks=all

#spring.kafka.producer.retries=3
spring.kafka.producer.properties.linger.ms=12000
spring.kafka.producer.properties.request.timeout.ms=3000
spring.kafka.producer.properties.enalbe.idempotence=true
spring.kafka.producer.properties.max.in.flight.request.per.connection=5


**optional steps**
 netsh advfirewall firewall add rule name="Allow from 192.168.1.103" dir=in action=allow protocol=ANY remoteip=192.168.1.103


