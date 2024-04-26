
--MQL
SELECT MEMBER_CODE
    FROM MEMBER
    WHERE ID= 'ID1' AND PASSWORD = 'PWD'
;

DESC MEMBER;

--CODE => TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')로 할 예정 // 년 - 분 - 일 - 월 - 초 - 시간 --- 시퀸스
SELECT TO_CHAR(SYSDATE,'YYMIDDMMSSHH24---')||USER_CODE_SEQUENCE.nextval FROM DUAL; 

INSERT INTO MEMBER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval,'ID16','PWD',01012345690,'ID16@NAVER.COM');


SELECT * FROM MEMBER;

SELECT COUNT(*) FROM MEMBER WHERE ID='687';

commit;

SELECT 'ASDF@naver,com'||'' FROM DUAL;

DESC MEMBER;


SELECT ID , PASSWORD, PHONE , EMAIL FROM MEMBER WHERE MEMBER_CODE=20240412;

UPDATE MEMBER SET PASSWORD = 'PWD2' , PHONE = '01001010101' , EMAIL = '변경@성공'  WHERE member_code = '20240414';

SELECT MEMBER_CODE FROM MEMBER WHERE ID='ID1' AND PASSWORD='PWD';

SELECT * FROM MEMBER;

UPDATE MEMBER SET PHONE='123456789012345' WHERE MEMBER_CODE =24051904261514;

DESC RESTORANT_OWNER;
SELECT * FROM MEMBER;
SELECT * FROM RESTORANT_OWNER;
INSERT INTO RESTORANT_OWNER VALUES (TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval , 20240412); 
SELECT OWNER_CODE FROM RESTORANT_OWNER WHERE MEMBER_CODE = 24232204171111;
DELETE FROM RESTORANT_OWNER WHERE MEMBER_CODE = '24262204171211';

DESC RESTORANT;
INSERT INTO RESTORANT (RESTORANT_CODE,OWNER_CODE,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_KIND) 
    VALUES (20240414,20240411,'ASDF',0103145,013465,'ASDF@SADF','ASDF','ASDF','AS');
    
SELECT RESTORANT_CODE,OWNER_CODE,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_KIND FROM RESTORANT;

DESC RESTORANT;
SELECT * FROM RESTORANT;


SELECT RESTORANT_CODE, RESTORANT_NAME , RESTORANT_LOCAL , RESTORANT_KIND FROM RESTORANT WHERE OWNER_CODE = 24182304331112;

SELECT * FROM RESTORANT_OWNER;

SELECT * FROM RESTORANT;

SELECT RESTORANT_NAME, RESTORANT_PHONE, RESTORANT_SUB_PHONE, RESTORANT_EMAIL, RESTORANT_LOCAL, RESTORANT_MESSAGE 
    FROM RESTORANT WHERE RESTORANT_CODE = 24222304131115;
    
UPDATE RESTORANT SET RESTORANT_NAME = 'NAME' , RESTORANT_PHONE = 01010 , RESTORANT_SUB_PHONE = 01011, RESTORANT_EMAIL = 'EMAIL' , RESTORANT_LOCAL = 'LOCAL' , RESTORANT_MESSAGE = 'MESSAGE'
    WHERE RESTORANT_CODE = 20240412;
--DELETE FROM RESTORANT_OWNER WHERE MEMBER_CODE = '24262204171211';

DELETE  FROM RESTORANT WHERE RESTORANT_CODE = 24232304021116;

DESC RESTORANT_INFO;
SELECT * FROM RESTORANT;

SELECT * FROM RESTORANT_INFO;
INSERT INTO RESTORANT_INFO VALUES (24262604501238 , 'Y' , 'Y' ,'Y' ,'Y' , 'Y');

DESC RESTORANT;

SELECT *
    FROM RESTORANT JOIN RESTORANT_INFO USING (RESTORANT_CODE);

INSERT INTO A1
(SELECT *
    FROM RESTORANT JOIN RESTORANT_INFO USING (RESTORANT_CODE)) A1
                                                        VALUES (12345678913256,20240411,'ASDFFDSA',01568432135,453879254,'ASDF@@ASDFASDFSADFSAFDSADF','SADFSADFSASDFSADFSADF','SADFSADFSADFASDFASDF','KO','Y','Y','Y','Y','Y');
    
--INSERT INTO RESTORANT (RESTORANT_CODE,OWNER_CODE,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_KIND) \r\n"
--				+ "    VALUES ( TO_CHAR(SYSDATE,'YYMIDDMMSSHH24')||USER_CODE_SEQUENCE.nextval , ? , ? , ? , ? , ? , ? , ? , ? )";    
INSERT INTO (SELECT *
    FROM RESTORANT JOIN RESTORANT_INFO USING (RESTORANT_CODE))(RESTORANT_CODE,OWNER_CODE,RESTORANT_NAME,RESTORANT_PHONE,RESTORANT_SUB_PHONE,RESTORANT_EMAIL,RESTORANT_LOCAL,RESTORANT_MESSAGE,RESTORANT_KIND,PLACE_ALONE,PLACE_GROUP,SIT_FLOOR,SIT_CHAIR,STANDING)
                                                        VALUES (12345678913256,20240411,'ASDFFDSA',01568432135,453879254,'ASDF@@ASDFASDFSADFSAFDSADF','SADFSADFSASDFSADFSADF','SADFSADFSADFASDFASDF','KO','Y','Y','Y','Y','Y');
