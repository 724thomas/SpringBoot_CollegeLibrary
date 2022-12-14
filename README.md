# SpringBoot_CollegeLibrary



<h3>Aim:</h3>
대학교에서 쓰는 책 대여 서비스 SpringBoot에서 구현<br>
<br>
<br>
<h3>Hypothesis:</h3>
회원가입, 로그인 가능<br>
로그인 후, 책 검색, 대여, 반납<br>
로그인 후, 포인트 충전, 출금<br>
관리자 모드로 로그인 가능<br>
<br>
<br>
<h3>Method:</h3>
유저는 회원가입/로그인을 할 수 있다.<br>
유저는 여러개의 책 주문목록을 갖고있다.<br>
주문목록을 현재 대여중인 책들, 대여했던 책들 순으로 가져온다.<br>
책을 빌리려면 그 책의 값만큼 충전을 해야하고, 반납할때 초과된 반납기일에 따른 금액을 제외하고 돌려받는다 (1일 10%)<br>
책을 빌릴때 빌릴 수 있는 수량을 확인한다.<br>
포인트 충전, 포인트 출금(반환), 내역확인이 가능하다.<br>
관리자 모드에서 새로운 책 추가, 기존 책 폐기, 책의 내역 확인 할 수 있다.<br>
(관리자 이메일 admin@admin / 비밀번호 : admin)<br>
<br>
<br>
<h3>Installation:</h3>
DBeaver에 collegelibaray DB 생성 후, <br>
프로젝트 안에 있는 SqlCreateTableCommands.sql , SqlExampleDataInsertion 실행.<br>
<br>
<br>
<h3>Progress Notes:</h3>
[221202]<br>
회원가입, 로그인 구현<br>
[221205]<br>
로그아웃, Ajax를 사용한 책 검색 기능 구현<br>
[221206]<br>
검색한 책의 상세정보 확인, 학생 책 대여, 대여내역 확인 기능 구현<br>
[221207]<br>
학생 총 대여내역과, 현재 대여내역을 분리.<br>
로그인시, 도서관 이용법 팝업창 제작<br>
[221208]<br>
팝업창(로그인 동안 안보이기 체크기능) 구현<br>
포인트 충전하기 Kakao API를 이용한 구현 (from 전상수 강사님)<br>
학생 충전 후, Student, Transaction, PaymentInfo db 업데이트<br>
변수, 함수 네이밍 수정<br>
포인트 출금 기능 구현<br>
다른 컴퓨터에서 사용가능한 SQL문 작성<br>
[221209]<br>
카카오 로그인 기능 구현<br>
로그인 후, 학생 현재 포인트 보이기<br>
[221211]<br>
책 반납, 연체료 구현<br>
연체료 Table 생성<br>
간단한 HashMap을 제외한 나머지는 DTO와 Entity로 변경<br>
함수, 변수 이름 변경<br>
에러 트래킹용 println 추가<br>


[221212]<br>
Readme 파일 생성(틀만 잡기)<br>
내부 로직 변경<br>
관리자-학생 대여내역, 포인트내역 조회<br>
관리자-책 대여중 내역, 대여내역<br>
카카오 로그인 기능 수<br>
[221213]<br>
첫 카카오 로그인 후, 회원가입 구현<br>
각 페이지 뒤로가기 버튼 추가<br>
연체료가 발생했을때 LatefeeTable에 db가 들어가도록 수정<br>
[221214]<br>
관리자 - 책관리 - 수량 관리 (추가, 제거)<br>
관리자 - 학생 상세 - 현재 포인트 추가<br>
관리자 - 책 추가 기능<br>
[221215]<br>
관리자 - 현재 대여, 반납, 연체중 책 목록<br>

<br>
<br>
#Todo<br>
2차 로그인 인증<br>
통계관리<br>
Maybe CSS?<br>


<br>
<br>
<h3>Bibliography:</h3>
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
