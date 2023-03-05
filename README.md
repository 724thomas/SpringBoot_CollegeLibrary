# :books: SpringBoot_CollegeLibrary
대학교의 온라인 도서관 서비스를 Spring Boot을 사용하여 구현해보자!


<br/><br/>



## :mortar_board: 프로젝트 목표 (Project Goals)
1. 지금까지 공부해왔던 것을 실제로 적용해보자!
2. 하나의 파트만이 아닌, 처음부터 끝까지, 모든 기능들을 경험해보고 구현해보자!
3. 실제 대학교 온라인 도서관 서비스들을 바탕으로 기능들을 제공해보자!
4. 개인적으로(호기심에) 공부했었던 기술들을 창의적으로 사용해보자!
5. 즐기자!!! :satisfied:


<br/><br/>


## :hammer: 기술 스택 (Technologies Used)
![Java](https://img.shields.io/badge/Java-007396?style=flat-round&logo=Java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat-round&logo=Spring%20Boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-round&logo=Thymeleaf&logoColor=white)

![JSoup](https://img.shields.io/badge/JSoup-E87333?style=flat-round)
![Kakao API](https://img.shields.io/badge/Kakao%20API-FEE500?style=flat-round&logo=Kakao&logoColor=black)
![OpenCV](https://img.shields.io/badge/OpenCV-5C3EE8?style=flat-round&logo=OpenCV&logoColor=white)
![JavaCV](https://img.shields.io/badge/JavaCV-990000?style=flat-round)
![VideoIO](https://img.shields.io/badge/VideoIO-FF6F52?style=flat-round)

![MyBatis](https://img.shields.io/badge/MyBatis-FF6F52?style=flat-round&logo=MyBatis&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?style=flat-round&logo=MariaDB&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-round&logo=MySQL&logoColor=white)


<br/><br/>


## :pushpin: API 기능명세서 (API Documentation)
![image](https://user-images.githubusercontent.com/113500771/222957357-3967f292-642e-47f6-8867-91d8094fb3a0.png)



<br/><br/>


## :floppy_disk: ER 다이어그램 (ER-Diagram with Cardinality Constraints)
![image](https://user-images.githubusercontent.com/113500771/222949303-976d1839-78ad-40c7-adf7-72b0eb9a20bd.png)


<br/><br/>


## :inbox_tray: 설치 (Installation)
1. 레포지토리를 클론합니다. 'git clone https://github.com/724thomas/SpringBoot_CollegeLibrary.git'
2. JDK 11이 설치되어 있는 Intellij(또는 다른 IDE)로 실행합니다.
3. MariaDB(또는 다른 DB)에 SpringBoot_CollegeLibrary/src/main/resources/SqlCreateTableCommands.sql에 맞춰 테이블을 생성합니다.


<br/><br/>


## :earth_asia: 사용 (Usage)
- 학생
1. 웹브라우저를 열고, "http://localhost:8080" 접속
2. 회원가입 / 카카오 이메일을 사용한 회원가입을 합니다.
3. 회원가입시 얼굴 인증을 위해 필요한 얼굴 사진을 찍습니다.
4. 찾고자 하는 책을 검색하여 대여 가능한 수량을 체크합니다.
5. 대여를 하려면 해당 책의 금액만큼의 포인트가 필요하므로, 포인트 충전 페이지로 갑니다.
6. KakaoPay를 사용하여 포인트 충전을 합니다.
7. 충전된 포인트로 책을 대여하고, 2주안에 반납을 합니다. 연체료는 하루에 10%입니다.
8. 반납시에, 연체료를 제외한 금액을 포인트로 다시 돌려받습니다.
9. 포인트를 출금할시에, 얼굴 확인을 하고, 일정시간동안 실패를 하게되면 자동 로그아웃이 됩니다.

- 관리자
1. 웹브라우저를 열고, "http://localhost:8080" 접속
2. admin@admin // admin 으로 로그인을합니다.
3. 새로운 책을 등록할 수 있습니다.
4. 책 검색으로 책에 대한 대여 현황, 연체료 기록 등 상세 정보를 조회할 수 있습니다.
4. 조회시 책의 추가/폐기 또는 비슷한 이유로 인한 수량 증가/감소 설정을 할 수 있습니다.
5. 학생을 조회하고, 학생에 대한 정보와 대여정보 등을 확인 할 수 있습니다.


<br/><br/>


## :unlock: 라이센스 (Licence)
This project is licensed under the MIT License.


<br/><br/>


## :bicyclist: Progress Notes
##### [221202]<br>
- 회원가입, 로그인 구현<br>
##### [221205]<br>
- 로그아웃, Ajax를 사용한 책 검색 기능 구현<br>
##### [221206]<br>
- 검색한 책의 상세정보 확인, 학생 책 대여, 대여내역 확인 기능 구현<br>
##### [221207]<br>
- 학생 총 대여내역과, 현재 대여내역을 분리.<br>
- 로그인시, 도서관 이용법 팝업창 제작<br>
##### [221208]<br>
- 팝업창(로그인 동안 안보이기 체크기능) 구현<br>
- 포인트 충전하기 Kakao API를 이용한 구현 (from 전상수 강사님)<br>
- 학생 충전 후, Student, Transaction, PaymentInfo db 업데이트<br>
- 변수, 함수 네이밍 수정<br>
- 포인트 출금 기능 구현<br>
- 다른 컴퓨터에서 사용가능한 SQL문 작성<br>
##### [221209]<br>
- 카카오 로그인 기능 구현<br>
- 로그인 후, 학생 현재 포인트 보이기<br>
##### [221211]<br>
- 책 반납, 연체료 구현<br>
- 연체료 Table 생성<br>
- 간단한 HashMap을 제외한 나머지는 DTO와 Entity로 변경<br>
- 함수, 변수 이름 변경<br>
- 에러 트래킹용 println 추가<br>
##### [221212]<br>
- Readme 파일 생성(틀만 잡기)<br>
- 내부 로직 변경<br>
- 관리자-학생 대여내역, 포인트내역 조회<br>
- 관리자-책 대여중 내역, 대여내역<br>
- 카카오 로그인 기능 수<br>
##### [221213]<br>
- 첫 카카오 로그인 후, 회원가입 구현<br>
- 각 페이지 뒤로가기 버튼 추가<br>
- 연체료가 발생했을때 LatefeeTable에 db가 들어가도록 수정<br>
##### [221214]<br>
- 관리자 - 책관리 - 수량 관리 (추가, 제거)<br>
- 관리자 - 학생 상세 - 현재 포인트 추가<br>
- 관리자 - 책 추가 기능<br>
##### [221215]<br>
- 관리자 - 현재 대여, 반납, 연체중 책 목록<br>
##### [221223]<br>
- 2차 인증 - OpenCv Face recognition<br>
- OpenCV를 Java로 구현하는데 힘들었다... 적용할 수 있는 오픈소스가 없고, 
- 소스코드를 가져와서 억지로 적용을 하려다보니, 원하는 결과가 나오지도 않아서 처음부터 공부를 했었다.<br>


<br/><br/>


## :relaxed: 프로젝트 회고(Reflection Report) 
기획단계가 중요하다는 것을 다시 한번 느꼈습니다.<br>
나름 계획적으로 db 스키마를 짰다고 생각을 헀지만, 그것만으로는 부족했었습니다.<br>
Domain Name, 변수들의 이름, 폴더의 구조와 중복메서드를 수정해야하는 일이 번번했고, <br>
결국 View단의 html을 변경해야하는 등, 작성하는 시간보다 리팩토링 하는 시간이 더 오래 걸렸습니다.<br>
지금은 혼자하지만 나중에 FrontEnd 개발자분들과 협업을 하게 되면 기획부분에 시간투자를 많이 해야할 것 같습니다.<br>
매번 프로젝트를 하면서 느낀거지만, 항상 리팩토링을 하게 되는걸 봤을때, 기획적인 부분에서 큰 그림을 그리지 못하고 있고, <br>
내가 필요한 기능들의 세부적인 것들을 놓치는것 같습니다.


<br/><br/>


## :globe_with_meridians: 참고자료(Bibliography)
[Java]<br>
[Spring] AOP 적용하기 (Annotation - Before, After, ...) (담크 2021.07.05)A<br>
https://darmk.tistory.com/entry/Spring-12-2-AOP-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0-Annotation-Before-After-AfterReturning-AfterThrowing<br>
Spring AOP @After, AfterReturning, @AfterThrowing 사용하기 (블로그 2018.11.10)<br>
https://deepweller.tistory.com/30<br>
HTML Input 타입 Number 알아보기 (WEBISFREE 2019.08.05)<br>
https://webisfree.com/2016-07-20/[html]-input-%ED%83%80%EC%9E%85-number-%EC%95%8C%EC%95%84%EB%B3%B4%EA%B8%B0<br>
Copying value from one input field to another input field (Steeve 2012.07.26)<br>
https://stackoverflow.com/questions/11662715/copying-value-from-one-input-field-to-another-input-field<br>
인터페이스를 활용한 Service 게층과 Repository계층에 대한 이해 (밀당하는It 2020.08.31)<br>
https://u-it.tistory.com/entry/Service%EA%B3%84%EC%B8%B5%EA%B3%BC-Repository%EA%B3%84%EC%B8%B5%EC%97%90-%EB%8C%80%ED%95%9C-%EC%9D%B4%ED%95%B4<br>
Disable editing default value of text input (halofourteen 2012.12.04)</br>
https://stackoverflow.com/questions/13701923/disable-editing-default-value-of-text-input<br>
[HTML] input box에 default 값 설정, <input value='노출 텍스트'> (임대리 개발일지 2019.04.09)<br>
https://server-engineer.tistory.com/635<br>
[Spring] 요청방식 (@RequestMapping, @GetMapping, @PostMapping) (dyunge_100 2022.04.19)<br>
https://velog.io/@dyunge_100/Spring-%EC%9A%94%EC%B2%AD-%EB%B0%A9%EC%8B%9DRequestMapping-GetMapping-PostMapping<br>
Annotations "not applicable to type" (Quarks 2013.08.07)<br>
https://stackoverflow.com/questions/18103586/annotations-not-applicable-to-type<br>
자바 extends, implements 차이 (hkoo9329 2019.12.15)<br>
https://velog.io/@hkoo9329/%EC%9E%90%EB%B0%94-extends-implements-%EC%B0%A8%EC%9D%B4<br>
html에서 DTO에 담긴 객체형식이 전송 가능할까요? (안준석 2021.06.18)<br>
https://www.inflearn.com/questions/233823/html%EC%97%90%EC%84%9C-dto%EC%97%90%EB%8B%B4%EA%B8%B4-%EA%B0%9D%EC%B2%B4%ED%98%95%EC%8B%9D%EC%9D%B4-%EC%A0%84%EC%86%A1%EA%B0%80%EB%8A%A5%ED%95%A0%EA%B9%8C%EC%9A%94<br>
dto를 model로 html에 보냈는대 value값을 인식하지 못합니다. (루이네스 2020.04.06)<br>
https://okky.kr/articles/707686<br>
MySQL 비교 연산자(8.x 기준) (yeon Biju 2020.03.18)<br>
https://webobj.tistory.com/85<br>
SQL not Equal to (!=) Operator for beginners (Database.Guide 2020.12.02)<br>
https://database.guide/sql-not-equal-to-operator-for-beginners-exclamation-equals-sign/<br>
Java controller to html if alert (Tom.C 2022.12.11)<br>
https://stackoverflow.com/questions/74759472/java-controller-to-html-if-alert?noredirect=1#comment131941588_74759472 <br>
Controller에서 자바스크립트 alert를 사용해보자 (Rojae 2020.11.04)<br>
https://redcoder.tistory.com/195 <br>
Face Recognition with JavaCV<br>
https://stackoverflow.com/questions/52691667/facerecognition-with-javacv (Hossein Golshani 2018.10.07)<br>
Computer Vision application (+web interface) for face detection and recognition from database (Kush 2012.03.27)<br>
https://stackoverflow.com/questions/9897601/computer-vision-applicationweb-interface-for-face-detection-and-recognition-f <br>
Facial Recognition in Java/Processing (TheCodeArtist 2013.09.02)<br>
https://stackoverflow.com/questions/9228732/facial-recognition-in-java-processing/9229054#9229054 <br>
Face Recognition + Attendence Project (Murtaza's workshop 2022.06.11)<br>
https://www.youtube.com/watch?v=sz25xxF_AVE&t=2038s<br>
How to send sms using jsp(동비나 2017.05.07)<br>
https://www.youtube.com/watch?v=3Mj0FgCz6g0&t=42s <br>
JSP lecture evaluation service development tutorial #9 (동빈나 2018.02.08)<br>
https://www.youtube.com/watch?v=e_XHILt7QUo&t=252s <br>
AI real time face recognition with Opencv.js (easycoding 2021.02.27)<br>
https://www.youtube.com/watch?v=S21jhMfjBdc<br>
Face API: How to train your app to identify people's faces by name (Ruth 2018.02.26)<br>
https://www.youtube.com/watch?v=WmzrKXWfa2o&t=1274s<br>
Introduction to Computer Vision - Processing Tutorial (TheCodingTrain 2015.07.24)<br>
https://www.youtube.com/watch?v=h8tk0hmWB44&t=1177s<br>
Realtime Face Detection in Java OpenCV(GUI) (Kraskros Tips 2022.08.03)<br>
https://www.youtube.com/watch?v=-5WMXkm-bEE&t=224s<br>
Face Detection Project For beginners (Code Heroku 2020.06.20)<br>
https://www.youtube.com/watch?v=PLKLsPDZ1t0&t=67s<br>
로그인 기능 구현하기 왕기초 (ft. 파이어베이스) (조코딩 2022.07.15)<br>
https://www.youtube.com/watch?v=tPqTE14DEUg<br>
