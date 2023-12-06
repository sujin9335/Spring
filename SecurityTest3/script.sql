
-- SecurityTest > script.sql

drop table tblRent;
drop table tblMember;

-- 회원 테이블
-- 암호 > 암호화 인코딩
create table tblMember (
    userid varchar2(50) not null primary key,
    userpw varchar2(100) not null, --최소 100바이트 이상
    username varchar2(100) not null,
    regdate date default sysdate not null,
    enabled char(1) default '1'
);

-- 권한(자격) 테이블 > ROLE_MEMBER, ROLE_ADMIN..
create table tblAuth (
    userid varchar2(50) not null,
    auth varchar2(50) not null,
    constraint fk_member_auth foreign key(userid) 
                                references tblMember(userid)
);








insert into tblMember (userid, userpw, username) 
values ('dog', '$2a$10$iodYcnf4FNqR9ZVKi832VeRQji3jzGx2BVWmS5OhCBhDn9QNCeFna', 
'강아지');

select * from tblMember;
delete from tblMember;
commit;










