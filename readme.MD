# Hystrix
## Making the apps more resilient
---
# What is Hystrix
- library to help control interactions between systems
- adds latency and fault tolerance
- fail fast and provide time to recover
- monitoring,alerting

---
# Healthy dependencies
<img src="https://github.com/Netflix/Hystrix/wiki/images/soa-1-640.png"/>
source:https://github.com/Netflix/Hystrix/wiki

---
# Something went wrong
<img src="https://github.com/Netflix/Hystrix/wiki/images/soa-2-640.png" >
source:https://github.com/Netflix/Hystrix/wiki

---
# How to avoid
- prevent one service/dependency use all user thread pool (e.g. in Tomcat)
- shed load and fail fast (avoid queueing)
- give dependency time to recover

# Demo Time
