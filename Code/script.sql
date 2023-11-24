

-- Code > script.sql

create table tblCode(
    seq number primary key,
    subject varchar2(1000) not null,
    code varchar2(2000) not null,
    regdate date default sysdate not null,
    language varchar2(100) not null
    
);

insert into tblCode (seq, subject, code, regdate, language) values (seqCode.nextVal, 'code1', 'string', default, 'java');

create sequence seqCode;

commit;

select * from tblCode; 

