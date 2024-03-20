# fastcampus-tdd-starter

안녕하세요.
유진호 입니다.

## 예제 코드 프로젝트 구조 설명
예제 코드는 아래의 2개의 경로에 나눠져 있습니다.
- main/java/com.fastcamp.tddstarter
- test/java/com.fastcamp.tddstarter

Chapter 기준으로 패키지를 생성하여 예제 코드를 나눠 놓았습니다.<br />
코드를 확인하실 때 Chapter 별로 main과 test 둘 다 확인해주세요!<br />

## Chapter별 코드 설명
1. Chapter#1
- TDD 기반으로 패스워드 강함 수준을 측정하는 코드 작성
- Success 키워드가 붙은 클래스 파일은 완성본 입니다.
- 예제 코드 출처: 최범균 저자님의 "테스트 주도 개발 시작하기"
- source path: [src/test/java/com/fastcamp/tddstarter/ch01](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/tree/17e780ab255a6219a727c0d39d751474dffb39e0/src/test/java/com/fastcamp/tddstarter/ch01)
2. Chapter#2
- JUnit 기반의 Test Code 예제 코드
- source path: [src/test/java/com/fastcamp/tddstarter/ch02](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/tree/4cba5d8efbf59111ce816067abe683e7c8ae3ad1/src/test/java/com/fastcamp/tddstarter/ch02)
3. Chapter#3
- Chaos Monkey For Spring Boot를 이용한 운영 테스트를 위해서 생성한 Jmeter용 jmx 파일
- source path: [src/test/java/com/fastcamp/tddstarter/ch03](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/tree/4cba5d8efbf59111ce816067abe683e7c8ae3ad1/src/test/java/com/fastcamp/tddstarter/ch03)
4. Chapter#4
- Controller, Repository Layer 테스트를 위한 Controller-Service-Repository 구조를 가지는 전형적인 Spring 코드 구조
- 공연 정보를 조회하고 공연을 예약하는 서비스를 제공
- JUnit5와 @SpringBootTest, @DataJpaTest 심화 과정 Test Code
- source path: [src/test/java/com/fastcamp/tddstarter/ch04](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/tree/4cba5d8efbf59111ce816067abe683e7c8ae3ad1/src/test/java/com/fastcamp/tddstarter/ch04)
5. Docker-compose
- 실전과 같은 테스트 코드를 위해 DB(MySQL8)를 docker-compose.yml 통해서 제공
- DockerDeskTop 설치 후, 실행
- 설정 파일 경로
  - Docker-compose: [docker-compose.yml](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/blob/4cba5d8efbf59111ce816067abe683e7c8ae3ad1/docker-compose.yml)
  - DB 스키마 설정 정보:[src/main/resources/initdb](https://github.com/jinho-yoo-jack/fastcampus-tdd-starter/tree/4cba5d8efbf59111ce816067abe683e7c8ae3ad1/src/main/resources/initdb)
