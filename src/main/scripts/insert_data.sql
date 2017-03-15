insert into form (id,available,create_date,description,finished,name,submit_date,update_date,user_user_id) values(100,true,'2017-03-01 04:05:01','Law Offices of Meisa Banh 801 S. Garfield Avenue, Suite 100B Alhambra, CA  91801',false, 'CONSULAR PROCESSING GENERAL INFORMATION',null,null,1);


insert into page(id, page_number,form_id) values(100,1,100);

insert into block(id,description,name,page_id) values(100,'','',100);

insert into item(dtype,id,available,description,required,type,name,order_id,max,min,text_length,block_id,matchField_id,answer_id) values('item_text',100,'t','','f',0,'1. NAME OF APPLICANT',0,1,0,-1,100,null,null);

insert into page(id, page_number,form_id) values(101,2,100);
insert into block(id,description,name,page_id) values(107,'','',101);

insert into item(dtype,id,available,description,required,type,name,order_id,max,min,text_length,block_id,matchField_id,answer_id) values('item_selection',120,'t','','f',2,'8. MARITAL STATUS:',0,1,1,-1,107,null,null);

INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (100, '', 'Single', 0,'0',120);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (101, '', 'Married', 1,'1',120);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (102, '', 'Divorced', 2,'2',120);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (103, '', 'Widowed', 3,'3',120);

INSERT INTO selection_answer(id, user_user_id) VALUES (100, 1);
INSERT INTO selection_answer_selections(selection_answer_id, selection_selection_id)
    VALUES (100, 101);

insert into block(id,description,name,page_id) values(108,'','',101);
insert into item(dtype,id,available,description,required,type,name,order_id,max,min,text_length,block_id,matchField_id,answer_id) values('item_selection',121,'f','','f',1,'APPLICANT’S ORIGINAL OR CERTIFIED COPY OF BIRTH CERTIFICATE', 0,1,0,-1,108,null,null);

INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (104, '', 'SYS_CHECKED', 0,'0',121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (105, '', 'SYS_UNCHECKED', 0,'1',121);

INSERT INTO selection_answer(id, user_user_id) VALUES (101, 1);

INSERT INTO selection_answer_selections(selection_answer_id, selection_selection_id)
    VALUES (101, 105);