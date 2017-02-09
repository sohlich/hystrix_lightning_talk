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

---
# Demo Time
- dashboard
- config
- code

```
boom -c 1 -n 1000 -q 10 http://localhost:8080/api/weather/current
```
---
# Stack

```
java.lang.RuntimeException: Cannot handle request
	at cz.edhouse.sohlich.api.WeatherEndpoint.getWeather(WeatherEndpoint.java:36) ~[classes/:na]
	at sun.reflect.GeneratedMethodAccessor77.invoke(Unknown Source) ~[na:na]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_74]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_74]
	at com.netflix.hystrix.contrib.javanica.command.MethodExecutionAction.execute(MethodExecutionAction.java:116) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.contrib.javanica.command.MethodExecutionAction.executeWithArgs(MethodExecutionAction.java:93) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.contrib.javanica.command.MethodExecutionAction.execute(MethodExecutionAction.java:78) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.contrib.javanica.command.GenericCommand$1.execute(GenericCommand.java:48) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.contrib.javanica.command.AbstractHystrixCommand.process(AbstractHystrixCommand.java:145) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.contrib.javanica.command.GenericCommand.run(GenericCommand.java:45) [hystrix-javanica-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.HystrixCommand$2.call(HystrixCommand.java:302) [hystrix-core-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.HystrixCommand$2.call(HystrixCommand.java:298) [hystrix-core-1.5.9.jar:1.5.9]
	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:46) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:35) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) [rxjava-1.1.10.jar:1.1.10]
	at rx.Observable.unsafeSubscribe(Observable.java:10211) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:51) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:35) [rxjava-1.1.10.jar:1.1.10]
	at rx.Observable.unsafeSubscribe(Observable.java:10211) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30) [rxjava-1.1.10.jar:1.1.10]
	at rx.Observable.unsafeSubscribe(Observable.java:10211) [rxjava-1.1.10.jar:1.1.10]
	at rx.internal.operators.OperatorSubscribeOn$1.call(OperatorSubscribeOn.java:94) [rxjava-1.1.10.jar:1.1.10]
	at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction$1.call(HystrixContexSchedulerAction.java:56) [hystrix-core-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction$1.call(HystrixContexSchedulerAction.java:47) [hystrix-core-1.5.9.jar:1.5.9]
	at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction.call(HystrixContexSchedulerAction.java:69) [hystrix-core-1.5.9.jar:1.5.9]
	at rx.internal.schedulers.ScheduledAction.run(ScheduledAction.java:55) [rxjava-1.1.10.jar:1.1.10]
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511) [na:1.8.0_74]
	at java.util.concurrent.FutureTask.run(FutureTask.java:266) [na:1.8.0_74]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_74]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_74]
	at java.lang.Thread.run(Thread.java:745) [na:1.8.0_74]
    ```