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
# How to avoid it
- prevent one service/dependency use all user thread pool (e.g. in Tomcat)
- lower/cut load and fail fast (avoid queueing)
- give dependency time to recover
- bulkhead,command,isolation

---

# How it works
<img src="https://raw.githubusercontent.com/wiki/Netflix/Hystrix/images/hystrix-command-flow-chart.png" />

----
# Keypoints
- rxjava
- https://github.com/Netflix/Hystrix/wiki
---
# Demo Time
- dashboard
- config
- code

```
//Falback
go get -u github.com/rakyll/hey

/d/Go/src/bin/hey.exe -n 1000 -q 10 http://localhost:8080/api/fallback


//Batching
cd /d/Courses/hystrix_lightning_talk/
go run batch.go

```
---