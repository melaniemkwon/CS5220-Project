INSERT INTO public.users(
	user_id, address1, address2, city, country, phone_cell, phone_home, phone_work, state, zip, email, first_name, last_name, role)
	VALUES (1, '123 street', 'Apartment 3', 'Los Angeles', 'USA', '123-123-1234', '321-321-3214', '000-000-0000', 'CA', '12345-1235', 'abc@gmail.com', 'John', 'Smith', 'ADMIN'),
    (2, '123 street', 'Apartment 3', 'Los Angeles', 'USA', '123-123-1234', '321-321-3214', '000-000-0000', 'CA', '12345-1235', 'def@gmail.com', 'Jane', 'Doe', 'STAFF'),
    (3, '123 street', 'Apartment 3', 'Los Angeles', 'USA', '123-123-1234', '321-321-3214', '000-000-0000', 'CA', '12345-1235', 'ghj@gmail.com', 'Michael', 'ABC', 'USER');