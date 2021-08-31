-- 내 스키마
DROP SCHEMA IF EXISTS MY_SCHEMA;

-- 내 스키마
CREATE SCHEMA MY_SCHEMA;

-- 학생
CREATE TABLE MY_SCHEMA.student (
	std_id   INTEGER     NOT NULL COMMENT '학번', -- 학번
	std_name VARCHAR(50) NOT NULL COMMENT '성명', -- 성명
	kor      INTEGER     NULL     COMMENT '국어', -- 국어
	eng      INTEGER     NULL     COMMENT '영어', -- 영어
	math     INTEGER     NULL     COMMENT '수학' -- 수학
)
COMMENT '학생';

-- 학생
ALTER TABLE MY_SCHEMA.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			std_id -- 학번
		);

-- 점수
CREATE TABLE MY_SCHEMA.score (
	total_score INTEGER NULL COMMENT '총점', -- 총점
	avg_score   FLOAT   NULL COMMENT '평균', -- 평균
	std_id      INTEGER NULL COMMENT '학번' -- 학번
)
COMMENT '점수';

-- 점수
ALTER TABLE MY_SCHEMA.score
	ADD CONSTRAINT FK_student_TO_score -- 학생 -> 점수
		FOREIGN KEY (
			std_id -- 학번
		)
		REFERENCES MY_SCHEMA.student ( -- 학생
			std_id -- 학번
		);
		
	
grant all privileges 
on student_mgn.* 
to 'user_student_mgn'@'localhost' identified by '1234';