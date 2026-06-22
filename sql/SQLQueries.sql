select * from scott.emp;

Select count(distinct DEPTNO) from scott.emp;

select count(*) from scott.emp;

select round(avg(sal)) from scott.emp;

select * from scott.emp where sal >= (select round(avg(sal)) from scott.emp);

select deptno, round(avg(sal)) as avg_sal from scott.emp group by deptno order by avg_sal;

select * from scott.emp a where sal >= (select round(avg(sal)) from scott.emp b where b.deptno = a.deptno);

--No. of employees grouped by deptno ordered by deptno desc ------->
select count(*) from scott.emp group by deptno order by deptno desc;


-- which dept has maximum emloyees ------->
select max(deptno) from scott.emp group by deptno order by count(*) desc;

select deptno, count(*) e from scott.emp group by deptno order by e desc;

-- WHICH DEPT HAS MAX SALARY EXPENSE:
select deptno, sum(sal) s from scott.emp group by deptno order by s desc fetch first 1 row only;


-- FOR EACH DEPT, LIST MAX SALARY AND MIN SALARY:
select deptno, max(sal), min(sal) from scott.emp group by deptno order by deptno;



--------------------------------------  JOINS  ----------------------------------------

select * from scott.dept;

select empno, ename, e.deptno, dname from scott.emp e, scott.dept d where e.deptno = d.deptno;

select empno, ename, e.deptno, dname from scott.emp e inner join scott.dept d on e.deptno = d.deptno;

select empno, ename, d.deptno, dname from scott.emp e right join scott.dept d on e.deptno = d.deptno;

---- For each employee, list out their empno, their name, name of their respective manager along with manager's empno,

select e.empno, e.ename, m.empno as mempno , m.ename as mname from scott.emp e left join scott.emp m on e.mgr = m.empno; 

---- skip level mgr nam, skip level mgr empno.

select e.empno, e.ename, m.ename, m.empno, s.ename, s.empno from scott.emp e 
left join scott.emp m on e.mgr = m.empno 
left join scott.emp s on m.mgr = s.empno 
order by 1;




---------------------------------- HR QUERIES -------------------------------------

select * from hr.countries;
select * from hr.departments;
select * from hr.employees;
select * from hr.jobs;
select * from hr.JOB_HISTORY;
select * from hr.LOCATIONS;
select * from hr.regions;

select e.employee_id, e.first_name, e.last_name, m.first_name as mgr_first, m.last_name as mgr_last, m.employee_id as mgr_id from hr.employees e join hr.employees m on e.EMPLOYEE_ID = m.EMPLOYEE_ID;


select c.country_name,l.city,d.DEPARTMENT_NAME,e.employee_id,e.first_name,e.last_name,
m.first_name mgr_first,m.last_name mgr_last,m.employee_id mgr_id
from hr.countries c left join hr.locations l
on c.country_id=l.country_id
left join hr.departments d
on l.location_id=d.location_id
full join hr.employees e
on d.department_id=e.department_id
left join hr.employees m
on e.manager_id=m.employee_id
order by e.employee_id;



------------------------------------ TRANSACTION ------------------------------------
create table salesman(
    salesman_id int not null,
    salesman_name varchar2(20),
    salesman_city varchar2(20),
    commission int
)

-- Insert one row
INSERT INTO salesman VALUES(5001, 'James Hoog', 'New York', 15);
INSERT INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13);

-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- View data from all columns
SELECT * FROM salesman;

savepoint sp1;
delete from salesman where salesmain_id = 5005;

------- saving after first delete-5005
savepoint sp2;
delete from salesman where salesman_id = 5002;


------- saving after second delete-5002
savepoint sp3;
rollback to sp2;

select count(*) as Num_Of_Salesman from salesman;