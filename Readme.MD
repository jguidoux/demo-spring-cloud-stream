# Launch the app

to launche rabbitmq and the app in only one command
``` gradle bootRun```

launch only rabbitmq.
``` gradle rabbitComposeUp```
go to http://localhost:15672 to see the web ui.
- login : guest
- password : guest

To stop rabbitmq.
``` gradle rabbitComposeDown```


doc :
https://github.com/avast/gradle-docker-compose-plugin
https://docs.spring.io/spring-cloud-stream/docs/Brooklyn.M1/reference/htmlsingle/