drop table if exists authors;
create table authors(	id long not null auto_increment,
						firstname varchar(32) not null,
						lastname varchar(32) not null,
                        primary key(id));
drop table if exists books;
create table books (
  id    long not null auto_increment,
  title varchar(255) not null,
  code varchar(40) not null,
  primary key (id)
);
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
						    phaseName varchar(32) not null,
						    phaseDec varchar(32) not null,
						    phaseLeaderid varchar(32) not null,
						    teamSize varchar(32) not null,
						    priority varchar(32) not null,
						    dueDate varchar(32) not null,
						    processType varchar(32) not null,
						    projectid varchar(32) not null,
						    complete varchar(32) not null,
                            primary key(id));