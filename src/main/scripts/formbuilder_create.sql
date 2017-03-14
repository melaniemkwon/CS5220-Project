insert into form (id,available,create_date,description,finished,name,submit_date,update_date) values(101,true,2017-03-01 04:05:01,'Law Offices of Meisa Banh 801 S. Garfield Avenue, Suite 100B 
Alhambra, CA  91801',,false, 'CONSULAR PROCESSING GENERAL INFORMATION',null,null);
insert into page(id, page_number,form_id) values(100,1,100);

1.
insert into block(id,description,name,page_id) values(100,'','',100);
insert into item(id,description,required,item_type,name,order_id,max,min,input_text,textLength,block_id,matchField_id,answer_id) 
values (100,'(Last, First, Middle):',true, TEXT, '1. NAME OF APPLICANT',1,null,null,'',1024,100,null,null);
2.
insert into block(id,description,name,page_id) values(101,'','',100);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (101, '(Mo./Day/Year):', true, 0, '2. DATE OF BIRTH', 0, 0, 0, '', 1024, 101, null, null);
3.
insert into block(id,description,name,page_id) values(102,'','',100);  
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (102, '(City and Country):', true, 0, '3. PLACE OF BIRTH', 0, 0, 0, '', 1024, 102, null, null);

4.
insert into block(id,description,name,page_id) values(103,'','',100);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (103, '', true, 0, '4. NATIONALITY:', 0, 0, 0, '', 1024, 103, null, null);


6. CURRENT RESIDENCE
insert into block(id,description,name,page_id) values(105,'','6. CURRENT RESIDENCE',100);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (108, '', true, 0, 'Street Address:', 0, 0, 0, '', 1024, 105, null, null);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (109, '', true, 0, 'City:', 0, 0, 0, '', 1024, 105, null, null);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (110, '', true, 0, 'State:', 0, 0, 0, '', 1024, 105, null, null);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (111, '', true, 0, 'Zip:', 0, 0, 0, '', 1024, 105, null, null);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (112, '', true, 0, 'Country:', 0, 0, 0, '', 1024, 105, null, null);

insert into page(id, page_number,form_id) values(101,2,100);

8. MARITAL STATUS:
insert into block(id,description,name,page_id) values(107,'','8. MARITAL STATUS:',101);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (120, '', true, 2, '8. MARITAL STATUS:', 0, 0, 0, '', 1024, 105, null, 100);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (100, '', 'Single', 0,'Single',107);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (101, '', 'Married', 1,'Married',107);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (102, '', 'Divorced', 2,'Divorced',107);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (103, '', 'Widowed', 2,'Widowed',107)


Answer: 8
INSERT INTO selection_answer(id, user_user_id) VALUES (100, 100);
INSERT INTO selection_answer_selections(selection_answer_id, selection_selection_id)
    VALUES (100, 101);
    

9.

insert into block(id,description,name,page_id) values(108,'','9. HOW MANY TIMES HAVE YOU BEEN MARRIED? ',101);
INSERT INTO item(id, description, required, item_type, name, order_id, max, min, input_text, textlength, block_id, matchfield_id, answer_id)
VALUES (121, '', true, 3, '9. HOW MANY TIMES HAVE YOU BEEN MARRIED?', 0, 1, 1, '', 1024, 105, null, 101);

INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (104, '', '0', 0,0,121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (105, '', '1', 0,0,121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (106, '', '2', 0,0,121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (107, '', '3', 0,0,121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (108, '', '4', 0,0,121);
INSERT INTO selections(selection_id, description, name, order_id, value, item_id)
VALUES (109, '', '5', 0,0,121);


Answer: 9
INSERT INTO selection_answer(id, user_user_id) VALUES (101, 100);
INSERT INTO selection_answer_selections(selection_answer_id, selection_selection_id)
    VALUES (101, 105);

