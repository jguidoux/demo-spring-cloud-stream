# Launch the app

to launche rabbitmq and the app in only one command
``` ./gradlew bootRun```

launch only server dependencies (rabbitmq and elk tasks).
``` ./gradlew depComposeUp```
go to http://localhost:15672 to see the rabbitmq web ui.
go to http://localhost:5601 to see the kubana web ui.
- login : guest
- password : guest

To stop servers.
``` ./gradlew depComposeDown```


To launch the complete servers ( dependencies + the app )
``` ./gradlew myAppComposeUp ```

To stop them :
``` ./gradlew myAppComposeDown ```




# doc :
https://github.com/avast/gradle-docker-compose-plugin
https://docs.spring.io/spring-cloud-stream/docs/Brooklyn.M1/reference/htmlsingle/