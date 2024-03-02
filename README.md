#CQRS DESIGN PATTERN WITH SPRING BOOT AND APACHE KAFKA FOR EVENTS



##Overview

 Segregation is an English term which means, an action or state of setting someone or something apart 
from others. 
The initials, CQRS, stands for Command & Query Responsibility Segregation.  Here we see that we are 
separating, (segregating) the reads and writes operations and making them persist to different 
databases for that matter. 

When it comes to the CQRS design pattern, it addresses various issues as far as APIs are concerned. 
- First of all, we have a situation where we have our application like an social media app. In such 
app the actual activity for posting can be minimal but just scrolling through numerous pictures like on 
instagram is done very much. In such as a scenario when optimizing the application, it is best to kinda
separate both the read and write operations.
- By separation of the reads and the writes it is easier to scale.
- Separation of concerns and plenty other dozens of reasons.

With the implementation of the whole architecture, I have put to use the apache kafka, and obviously the 
zookeeper and mysql server which have been spun up by docker-compose.
😎 kevin Ameda Kisevu 😎
