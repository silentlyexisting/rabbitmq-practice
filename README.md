# rabbitmq-practice

## Description:

Created for educational purposes.

RabbitMQ project with configured Producer and Consumer using Spring Boot and Restful API.

Producer receives the json from the client and sends it to the Consumer, which prepares and adds it to the database.

## Run application with Docker compose
```
git clone https://github.com/silentlyexisting/rabbitmq-practice
cd rabbitmq-practice
docker-compose up
```

## Configuration:

Producer application available at `7000` port, Consumer application at `7001` port.

RabbitMQ `exchanges`, `queues` and `routing-keys` configurations in each `application.yml`:
```yaml
rabbitmq:
  exchanges:
    topic-exchange: internal.topic.exchange
  queues:
    queue: consumer.queue
  routing-keys:
    key: consumer.routing-key
```

## POST: 7000/api/v1/students
```json
{
    "firstName": "Michael",   
    "lastName": "Reed",
    "city": "Chicago",
    "college": {
       "name": "University of Chicago",
       "grade": 3,
       "attendance": 75,
       "subjects": [
         "English",
         "Geometry",
         "Physics",
         "World History"
       ]
     }
}
```

## GET: 7001/api/v1/students or GET: 7001/api/v1/students/{id}
