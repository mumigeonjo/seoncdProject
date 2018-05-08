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

-- �̹��� ���, �̹��� �󼼰�� �÷� product�� �߰�
alter table product add(p_image varchar2(100), p_detail_image varchar2(100));
--not null ���������� �̹��� �߰� �Ŀ�

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
insert into member values ('admin', 'admin', 'admin', '07040090075', '��⵵ ������ �д籸 ���� ����Ǳ��� 670�� �������̽� B�� 8��', '1');

insert into member values ('junyeong', '1234', 'Junyeong', '01012345678', '����', '0');

--product table sample data
insert into product values('P001S','GO��������Ʈ','100000','S', sysdate, '100');
insert into product values('P001M','GO��������Ʈ',100000,'M', sysdate, 100, null, null);
insert into product values('P001L','GO��������Ʈ','100000','L', sysdate, '100');

--notice table sample data
insert into notice values(notice_seq.nextval, '5�� ���� ����!', '����� Ÿ�� ���� 5��, �� ǰ�� 20% ����! �̹� �� 20�Ϻ���!', sysdate);

--qa table sample data
insert into qa values(qa_seq.nextval, 'junyeong', '1', '�̰� �㸮 ����������?', '�㸮', sysdate);

--qa_reply sample data
insert into qa_reply values(qa_reply_seq.nextval, '1', sysdate, '�����ܰ����� ��õ�ϴ� �����Դϴ�.');

--order_detail sample data
insert into order_detail values(order_detail_seq.nextval, 'P001M', 'junyeong', '1', sysdate, '1', '����', '01012345678');

--review sample data
insert into review values(review_seq.nextval, 'P001M', 'junyeong', sysdate, 'ô�߰� �����ϳ׿�', null, '9');


--cascade test ����
insert into qa values(qa_seq.nextval, 'junyeong', '2', 'ȯ�� ���������ΰ���?', 'ȯ��', sysdate);
insert into qa_reply values(qa_reply_seq.nextval, '2', sysdate, '7�� �̳��� Q&A�� ��û�Ͻø� �˴ϴ�.');

delete from qa where b_indexno='2';
select * from qa;
select * from qa_reply;
select * from review;
select * from member;
select * from product;