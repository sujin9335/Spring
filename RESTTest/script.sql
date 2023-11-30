select * from tabs;

select * from tblAddress;



select count(*) from tblAddress;
select * from tblAddress;
insert into tblAddress (seq, name, age, gender, address, regdate)
 			values(seqAddress.nextVal, '수리', 25, 'm', '스울', default);
update tblAddress set 
 			name='수진',
 			age=22,
 			gender='m'
 			address='강남구'
 				where seq=4;