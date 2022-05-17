# elk-demo
#### Presequisite
* Jdk-1.8
* Maven-3.6+

#### 1. Clone the Repository
```bash
git clone https://github.com/ssmtariq/elk-demo.git
cd elk-demo/
```

#### 2. Build the Application
```bash
mvn clean package
```
#### 3. Start the Application
```bash
java -jar target/elk-demo-0.0.1-SNAPSHOT.jar
```
#### 4. Get Employee endpoint
```bash
http://{host}:8081/getEmployee/1
```