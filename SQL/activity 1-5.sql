create table salesman(
  salesman_id  int primary key,
  salesman_name varchar(20) not null,
  salesman_city  varchar(20),
  commission  int
);

describe salesman;


insert all
  into salesman values(6001,'vinay','Ongole',10)
  into salesman values(6002,'vinay kumar','B-Ongole',11)
  into salesman values(6003,'vinaya','Busarapalli',13)
  into salesman values(6004,'Vasavi','atk',15)
  into salesman values(6005,'Pavani','Vijayanagaram', 20)
  into salesman values(6006,'Sathwik','Vizag', 20)

select 1 from dual;
select * from salesman;

select salesman_id, salesman_city from salesman;

select * from salesman where salesman_city='Vizag';

select salesman_id, commission from salesman where salesman_name='Vasavi';
 alter table salesman add (grade int);

 update salesman set grade =100

 update salesman set grade =300 where salesman_name= 'Vasavi';

 update salesman set grade =80 where salesman_name= 'vinaya'

 update salesman set grade =300 where salesman_id= 6005