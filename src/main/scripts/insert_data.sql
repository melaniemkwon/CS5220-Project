-- insert form
insert into forms (author_user_id, available, create_date, description, title, update_date, id) values (?, ?, ?, ?, ?, ?, ?)

-- insert checkbox item and its selection choices
insert into items (available, description, form_id, helpText, index, required, type, title, num_checkboxes, item_type, id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, 'CHECKBOX', ?)
insert into selections (index, item_id, value, id) values (?, ?, ?, ?)
insert into selections (index, item_id, value, id) values (?, ?, ?, ?)
insert into selections (index, item_id, value, id) values (?, ?, ?, ?)