drop table review;
drop table qa_reply;
drop table qa;
drop table notice;
drop table order_detail;
drop table product;
drop table member;

commit

--create table
create table member(
    member_id varchar2(20) not null constraint mid_pk PRIMARY KEY,
    pwd varchar2(20) not null,
    mname varchar2(20) not null,
    phone varchar2(20) not null,
    addr varchar2(100) not null,
    ismgr int not null
);



create table product(
    p_code varchar2(20) not null constraint p_code_pk Primary key,
    p_name varchar2(20) not null,
    p_price int not null,
    p_size varchar2(20) not null,
    p_date date not null,
    p_ea int not null
);

-- 이미지 경로, 이미지 상세경로 컬럼 product에 추가
alter table product add(p_image varchar2(100), p_detail_image varchar2(100));
--not null 제약조건은 이미지 추가 후에

create table notice(
    n_indexno int not null constraint n_indexno_pk primary key,
    n_title varchar2(20) not null,
    n_content varchar2(1000) not null,
    n_date date not null
);
alter table notice modify (n_title varchar2(100));

create table order_detail(
    o_indexno int not null constraint o_indexno_pk primary key,
    p_code varchar2(20) not null constraint p_code_fk references product(p_code) on delete cascade,
    member_id varchar2(20) not null constraint mid_fk references member(member_id) on delete cascade,
    o_ea int not null,
    o_date date not null,
    o_status int not null,
    o_addr varchar2(100) not null,
    o_phone varchar2(20) not null
);
create table review(
    r_indexno int not null constraint rindex_pk primary key,
    p_code varchar2(20) not null constraint p_code_fk_r references product(p_code) on delete cascade,
    member_id varchar2(20) not null constraint mid_fk_r references member(member_id) on delete cascade,
    r_date date not null,
    r_content varchar2(200),
    r_photo varchar2(200),
    r_rate int not null
);

create table QA(
    b_indexno int not null constraint bindexno_pk primary key,
    member_id varchar2(20) not null constraint mid_fk_qa references member(member_id) on delete cascade,
    b_category int not null,
    b_content varchar2(1000) not null,
    b_title varchar2(100) not null,
    b_date date not null
);

create table qa_reply(
    q_indexno int not null constraint q_indexno_pk primary key,
    b_indexno int not null constraint b_indexno_fk references qa(b_indexno) on delete cascade,
    q_date date not null,
    q_content varchar2(1000) not null
);

--create sequence
create sequence order_detail_seq nocache;
create sequence qa_seq nocache;
create sequence qa_reply_seq nocache;
create sequence notice_seq nocache;
create sequence review_seq nocache;

--member table sample data
insert into member values ('admin', 'admin', 'admin', '07040090075', '경기도 성남시 분당구 삼평동 대왕판교로 670길 유스페이스 B동 8층', '1');

insert into member values ('junyeong', '1234', 'Junyeong', '01012345678', '서울', '0');

--product table sample data
insert into product values('P001S','GO에베레스트','100000','S', sysdate, '100');
insert into product values('P001M','GO에베레스트',100000,'M', sysdate, 100, null, null);
insert into product values('P001L','GO에베레스트','100000','L', sysdate, '100');

--notice table sample data
insert into notice values(notice_seq.nextval, '5월 할인 예고!', '비행기 타기 좋은 5월, 전 품목 20% 할인! 이번 달 20일부터!', sysdate);

--qa table sample data
insert into qa values(qa_seq.nextval, 'junyeong', '1', '이거 허리 괜찮은가요?', '허리', sysdate);

--qa_reply sample data
insert into qa_reply values(qa_reply_seq.nextval, '1', sysdate, '정형외과에서 추천하는 가방입니다.');

--order_detail sample data
insert into order_detail values(order_detail_seq.nextval, 'P001M', 'junyeong', '1', sysdate, '1', '서울', '01012345678');

--review sample data
insert into review values(review_seq.nextval, 'P001M', 'junyeong', sysdate, '척추가 좋아하네요', null, '9');


--cascade test 성공
insert into qa values(qa_seq.nextval, 'junyeong', '2', '환불 언제까지인가요?', '환불', sysdate);
insert into qa_reply values(qa_reply_seq.nextval, '2', sysdate, '7일 이내로 Q&A에 신청하시면 됩니다.');

delete from qa where b_indexno='2';
select * from qa;
select * from qa_reply;
select * from review;
select * from member;
select * from product;