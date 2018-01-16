#Generate REST doc with JSONDoc
It's quite easy to use!
Just follow steps in [official guide](http://jsondoc.org/how-to-spring-boot.html)  
1. add maven dependency:
```xml
<dependency>
        <groupId>org.jsondoc</groupId>
        <artifactId>spring-boot-starter-jsondoc</artifactId>
        <version>1.2.19</version>
</dependency>
```
2. add spring boot config:
```yaml
# mandatory configuration
jsondoc.version=1.0
#The base path of your API?
#my project runs on localhost:8099, and configs like 'localhost:8080','localhost:8099/doc'
#seem won't work
#好像只能配实际的项目地址?
jsondoc.basePath=http://localhost:8080 
jsondoc.packages[0]=com.example.controller
jsondoc.packages[1]=com.example.model
# optional configuration
jsondoc.playgroundEnabled=true
jsondoc.displayMethodAs=URI
```
3. add @EnableJSONDoc in configuration class
4. show doc in your web app
add dependency:
```xml
<dependency>
        <groupId>org.jsondoc</groupId>
        <artifactId>jsondoc-ui-webjar</artifactId>
        <version>1.2.19</version>
</dependency>
```
go to http://localhost:8080/jsondoc-ui.html, insert http://localhost:8080/jsondoc
,and get the documentation.
in this project, need input 'localhost:8099'.

===  
but i can't generate an output, maven plugin install failed