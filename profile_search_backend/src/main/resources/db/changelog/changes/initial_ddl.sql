create table skill_level_lkp (
	id SERIAL primary key,
  	level_name varchar(20) not null,
  	
  	constraint skill_level_unique_row unique (level_name)
);

create table skill_lkp (
	id SERIAL primary key,
  	skill_name varchar(20) not null,
  	
  	constraint skill_unique_row unique (skill_name)
);

create table gender_lkp (
	id SERIAL primary key,
  	gender_name varchar(20) not null,
  	
  	constraint gender_unique_row unique (gender_name)
);

create table employee (
	emp_code character varying not null,
	salutation character varying,
	first_name character varying,
	middle_name character varying,
	last_name character varying,
	gender integer references gender_lkp(id),
	mobile character varying,
	work_phone character varying,
	work_email character varying,
	skype_id character varying
	is_active boolean,
	creator_user_id character varying,
	create_ts timestamp not null default now(),
	last_modifier_user_id character varying,
	last_mod_ts timestamp not null default now(),

	constraint emp_pk primary key (employee_code)
);

create table employee_skill (
	id bigserial primary key,
	emp_id character varying references employee(employee_code),
	skill_id integer not null references skill(id),
	is_primary boolean not null,

	constraint employee_skill_unique_row unique(emp_id, skill_id)
); 
