#  testing

실행 
```bash
cd 2018-public-education/

cd course
mvn spring-boot:run -Dserver.port=8087

(다른 창 하나 더 열기)
cd calendar/
mvn spring-boot:run -Dserver.port=8088


```




호스트 추가
```bash
sudo vi /etc/hosts

(아래 추가)
127.0.0.1       calendar
127.0.0.1       education-kafka-zookeeper
127.0.0.1       education-kafka

(저장)
```

테스트
```bash
http http://localhost:8087/courses title="MSA 과정" minEnrollment=10 maxEnrollment=100 duration=3 unitPrice=100
http http://localhost:8087/clazzes instructorName="장진영" title="test" course="http://localhost:8080/courses/1"

http localhost:8088/schedules  # 기대값: 강사 장진영의 스케쥴이 하나 추가되어야 함.
```


#  관련스크립트 모음:

Helm 설치:
https://workflowy.com/s/helm/Hp7x4R4woJOpzMlA

Kafka 설치:
https://workflowy.com/s/running-kafka/nUnfGc7vMrkoyZSZ

강의 중 스크립트:
https://workflowy.com/s/msa/27a0ioMCzlpV04Ib