create table T_USER
(
  id              VARCHAR2(32) not null,
  username        VARCHAR2(30) not null,
  password        VARCHAR2(32) not null,
  age             NUMBER(10) default 0,
  last_login_time DATE,
  create_time     DATE default SYSDATE not null
);

insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b516f873401519f88eb000000', 'QA-NEW110', '9C7D908AAFD496B2C15B3CABA96C535C', 10, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('C1A0C51F87D14A91BD33C359E1E3A84F', 'CTO-NEW', '4DEA78E60F15C4EC01BE27A57979C657', 25, to_date('17-12-2015 09:22:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519f873401519f88eb000002', 'PRO-NEW', 'F7EE482238E5C4669E44DA518A5CDF31', 25, to_date('17-12-2015 09:28:54', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b509f873401519f88eb000000', 'DELL-NEW', 'BB9E0EDBF964B5A188E455AA29E39AF2', 80, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519f873401219f88eb000000', 'admin', 'F6FDFFE48C908DEB0F4C3BD36C032E72', 88, to_date('17-12-2015 16:49:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('8871997B790C4DCD894291C040AA16E2', 'ABBY-LU', 'DCB0B78598EBE50C0E24F62A34EE42B9', 32, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('3F95878ECCFB4E89A55AC76A0EB95F77', 'HELLO ITS', '5102CFDDD0B8B435D3823AEFD3BEB250', 20, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4020ac8b519f873401519f88eb000000', 'WISERS-NEW', '5C5A0CDD3B082F0D08EC59C5C30A1E44', 28, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8c519f873401519f88eb000000', 'KEMLON', '4E83000D850FA05E05EA09F81328DA19', 20, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8e519f873401519f88eb000000', 'SYS-110', '812E50717769230AF521B44F1AF17763', 25, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519fab9901519fac9ce21000', 'TT-NEW', 'A4CB89D2230D7C653C9961930D709822', 27, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519fab9901219fac9ce20000', 'TAOBAO', 'ECFF6D4F7384E5E3472F7D6B4FD0ECA7', 12, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519fab9901519gac9ce20000', 'BAIDU', '3A4626309996ED24A1F9FAD9F105019D', 12, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('DE4C3062E83B41968C10EA4103E230B9', 'UNIHZ', '2C59DA891BA522D9A93D408238B18BF6', 10, to_date('15-12-2015 16:43:11', 'dd-mm-yyyy hh24:mi:ss'), to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b519fab9901519fac9ce20000', 'PD-NEW', '7AB58DAEE9E428798759199F116E6F6E', 22, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b51a37fcf0151a38096280000', 'PLSQL Developer', '23C40DE8158F5FED811442A56EDFDD2D', 50, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
insert into T_USER (id, username, password, age, last_login_time, create_time)
values ('4028ac8b51a9f4de0151a9f5f72e0000', 'NUMBER', 'FE4CB237F975615E883200A765A7B53C', 20, null, to_date('18-12-2015 11:03:20', 'dd-mm-yyyy hh24:mi:ss'));
commit;
