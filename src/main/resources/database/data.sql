-- code_group
INSERT INTO code_group VALUES('gender', '성별코드', '성별을 표시');
INSERT INTO code_group VALUES('visit', '방문상태코드', '환자방문의 상태(방문중, 종료, 취소)');
INSERT INTO code_group VALUES('department', '진료과목코드', '진료과목(안과, 내과 등)');
INSERT INTO code_group VALUES('treat_type', '진료유형코드', '진료의 유형(약처방, 검사 등)');

-- code
INSERT INTO code VALUES('M', 'gender', '남');
INSERT INTO code VALUES('F', 'gender', '여');
INSERT INTO code VALUES('1', 'visit', '방문중');
INSERT INTO code VALUES('2', 'visit', '종료');
INSERT INTO code VALUES('3', 'visit', '취소');
INSERT INTO code VALUES('01', 'department', '내과');
INSERT INTO code VALUES('02', 'department', '안과');
INSERT INTO code VALUES('D', 'treat_type', '약처방');
INSERT INTO code VALUES('T', 'treat_type', '검사');

-- hospital
INSERT INTO hospital VALUES(default, '홍두깨', '202401111', '한마음병원' );
INSERT INTO hospital VALUES(default, '아무개', '202401112', '예쁜치과');