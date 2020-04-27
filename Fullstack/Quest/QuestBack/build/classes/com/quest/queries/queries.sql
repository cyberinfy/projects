create table questadmin (
                         employeeid number primary key,
                         password varchar2(20)
                        );
                        
create table questusers (
                         employeeid number primary key,
                         name varchar2(20) not null,
                         lg varchar2(10)
                        );
                        
         
create table questcategories (
                              categoryname varchar2(20) primary key     
                             );



create table questuserstatistics (
                                    employeeid number REFERENCES questusers(employeeid),
                                    questions number default 0,
                                    solutions number default 0
                                 );

CREATE SEQUENCE get_question_id
                      START WITH 1
                      INCREMENT BY 1
                      CACHE 100;
                         
  
create table questquestions (
                                questionid number primary key,
                                questiondescription clob not null,
                                categoryname references questcategories(categoryname),
                                screenshot blob,
                                employeeid number references questusers(employeeid)
                            );
                            
                            
CREATE SEQUENCE get_solution_id
                      START WITH 1
                      INCREMENT BY 1
                      CACHE 100;

create table questsolutions (
                                questionid number references questquestions(questionid),
                                solutionid number primary key,
                                solutiondescription clob not null,
                                employeeid number references questusers(employeeid)
                            );

                            
create table questsolutionlikes (
                                    solutionid number references questsolutions(solutionid),
                                    employeeid number references questusers(employeeid)
                                );
                            
                            
create table questsolutiondislikes (
                                    solutionid number references questsolutions(solutionid),
                                    employeeid number references questusers(employeeid)
                                );
