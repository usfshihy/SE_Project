drop table if exists inspectors;
create table inspectors(	id long not null auto_increment,
						    majord varchar(32) not null,
						    minord varchar(32) not null,
						    pdsize varchar(32) not null,
						    pdtime varchar(32) not null,
						    pdrate varchar(32) not null,
						    estyield varchar(32) not null,
                            primary key(id));
drop table if exists defects;
create table defects(	id long not null auto_increment,
						    inspectorid varchar(32) not null,
						    inspectorname varchar(32) not null,
						    defectdesc varchar(32) not null,
						    projectid varchar(32) not null,
						    phaseid varchar(32) not null,
						    jobid varchar(32) not null,
						    priority varchar(32) not null,
						    issuedate varchar(32) not null,
						    fixed varchar(32) not null,
                            primary key(id));
drop table if exists phases;
create table phases(	id long not null auto_increment,
						    phasename varchar(32) not null,
						    phasedesc varchar(32) not null,
						    phaseleaderid varchar(32) not null,
						    teamsize varchar(32) not null,
						    priority varchar(32) not null,
						    duedate varchar(32) not null,
						    processtype varchar(32) not null,
						    projectid varchar(32) not null,
						    complete varchar(32) not null,
                            primary key(id));
drop table if exists jobs;
create table jobs(	id long not null auto_increment,
						    jobname varchar(32) not null,
						    jobdesc varchar(32) not null,
						    assignedworkerid varchar(32) not null,
						    priority varchar(32) not null,
						    duedate varchar(32) not null,
						    phaseid varchar(32) not null,
						    complete varchar(32) not null,
                            primary key(id));

drop table if exists members;
create table members(	id long not null auto_increment,
						    firstname varchar(32) not null,
						    lastname varchar(32) not null,
						    company varchar(32) not null,
						    branch varchar(32) not null,
						    address varchar(32) not null,
						    companyposition varchar(32) not null,
						    dateofbirth varchar(32) not null,
						    dateofjoiningcompany varchar(32) not null,
                            primary key(id));
drop table if exists projects;
create table projects(	id long not null auto_increment,
						    name varchar(32) not null,
						    desc varchar(32) not null,
						    projectleaderid varchar(32) not null,
						    category varchar(32) not null,
						    company varchar(32) not null,
						    branch varchar(32) not null,
						    priority varchar(32) not null,
						    processtype varchar(32) not null,
						    duebydate varchar(32) not null,
						    iscomplete varchar(32) not null,
                            primary key(id));