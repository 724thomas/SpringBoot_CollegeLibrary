# SpringBoot_CollegeLibrary



Aim:<br>
대학교에서 쓰는 책 대여 서비스 SpringBoot에서 구현<br>
<br>
<br>
Hypothesis:<br>
회원가입, 로그인 가능<br>
로그인 후, 책 검색, 대여, 반납<br>
로그인 후, 포인트 충전, 출금<br>
관리자 모드로 로그인 가능<br>
<br>
<br>
Method:<br>
유저는 회원가입/로그인을 할 수 있다.<br>
유저는 여러개의 책 주문목록을 갖고있다.<br>
주문목록을 현재 대여중인 책들, 대여했던 책들 순으로 가져온다.<br>
책을 빌리려면 그 책의 값만큼 충전을 해야하고, 반납할때 초과된 반납기일에 따른 금액을 제외하고 돌려받는다 (1일 10%)<br>
책을 빌릴때 빌릴 수 있는 수량을 확인한다.<br>
포인트 충전, 포인트 출금(반환), 내역확인이 가능하다.<br>
관리자 모드에서 새로운 책 추가, 기존 책 폐기, 책의 내역 확인 할 수 있다.<br>
<br>
<br>
Installation:<br>
DBeaver에 collegelibaray DB 생성 후, <br>
프로젝트 안에 있는 SqlCreateTableCommands.sql , SqlExampleDataInsertion 실행.<br>
<br>
<br>
Progress Notes:<br>
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
<br>
<br>
Bibliography:<br>
[Java]<br>
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
