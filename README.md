### eureka   3001
### app01   3002
### config-center  3003
### sso  3004
### gateway  3005


Gradle 多项目构建

Spring Cloud 
Spring Boot 
学习

gradle :service-app01:clean && 
gradle :service-app01:build -Dprofile=prod -x test

gradle :service-app01:clean && 
gradle :service-app01:assemble -Dprofile=prod

assemble build 区别只编译源码不执行测试

-x test  忽略test