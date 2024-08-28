INSERT INTO app_user (name, email, password) VALUES
('John Doe', 'john.doe@example.com', 'password123'),
('Jane Smith', 'jane.smith@example.com', 'password123'),
('Alice Johnson', 'alice.johnson@example.com', 'password123'),
('Bob Brown', 'bob.brown@example.com', 'password123'),
('Charlie Davis', 'charlie.davis@example.com', 'password123'),
('Diana Evans', 'diana.evans@example.com', 'password123'),
('Frank Green', 'frank.green@example.com', 'password123'),
('Grace Harris', 'grace.harris@example.com', 'password123'),
('Hank Young', 'hank.young@example.com', 'password123'),
('Ivy King', 'ivy.king@example.com', 'password123'),
('Jack White', 'jack.white@example.com', 'password123'),
('Karen Adams', 'karen.adams@example.com', 'password123'),
('Larry Baker', 'larry.baker@example.com', 'password123'),
('Megan Clark', 'megan.clark@example.com', 'password123'),
('Nathan Moore', 'nathan.moore@example.com', 'password123'),
('Olivia Scott', 'olivia.scott@example.com', 'password123'),
('Paul Turner', 'paul.turner@example.com', 'password123'),
('Quinn Walker', 'quinn.walker@example.com', 'password123'),
('Rachel Hall', 'rachel.hall@example.com', 'password123'),
('Steve Allen', 'steve.allen@example.com', 'password123');



INSERT INTO user_roles (user_id, roles) VALUES
(1, 'RIDER'),
(1, 'DRIVER'),
(2, 'RIDER'),
(2, 'DRIVER'),
(3, 'RIDER'),
(3, 'DRIVER'),
(4, 'RIDER'),
(5, 'RIDER'),
(5, 'DRIVER'),
(6, 'RIDER'),
(6, 'DRIVER'),
(7, 'RIDER'),
(8, 'RIDER'),
(8, 'DRIVER'),
(9, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER'),
(11, 'RIDER'),
(11, 'DRIVER'),
(12, 'RIDER'),
(12, 'DRIVER'),
(13, 'RIDER'),
(14, 'RIDER'),
(14, 'DRIVER'),
(15, 'RIDER'),
(16, 'RIDER'),
(16, 'DRIVER'),
(17, 'RIDER'),
(18, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(19, 'DRIVER'),
(20, 'RIDER');

INSERT INTO rider(id,user_id,rating) values
(1,4,4.9);


INSERT INTO driver (id, user_id, rating, available, current_location) VALUES
(1, 1, 4.5, TRUE, ST_GeomFromText('POINT(77.1025 28.7041)', 4326)), -- Delhi
(2, 2, 4.7, TRUE, ST_GeomFromText('POINT(77.2167 28.6139)', 4326)), -- New Delhi
(3, 3, 4.6, FALSE, ST_GeomFromText('POINT(77.0565 28.4595)', 4326)), -- Gurgaon
(4, 5, 4.8, TRUE, ST_GeomFromText('POINT(77.3260 28.4089)', 4326)), -- Noida
(5, 6, 4.4, TRUE, ST_GeomFromText('POINT(77.2880 28.7041)', 4326)), -- Ghaziabad
(6, 8, 4.3, FALSE, ST_GeomFromText('POINT(76.9946 28.1486)', 4326)), -- Faridabad
(7, 9, 4.9, TRUE, ST_GeomFromText('POINT(76.8131 28.8932)', 4326)), -- Sonipat
(8, 11, 4.2, TRUE, ST_GeomFromText('POINT(77.7083 28.9900)', 4326)), -- Meerut
(9, 12, 4.7, FALSE, ST_GeomFromText('POINT(77.2145 28.5355)', 4326)), -- Greater Noida
(10, 14, 4.6, TRUE, ST_GeomFromText('POINT(76.7996 29.1492)', 4326)), -- Panipat
(11, 16, 4.5, TRUE, ST_GeomFromText('POINT(77.2261 28.2096)', 4326)), -- Palwal
(12, 18, 4.3, TRUE, ST_GeomFromText('POINT(76.8641 28.1736)', 4326)), -- Manesar
(13, 19, 4.4, FALSE, ST_GeomFromText('POINT(77.3776 28.6892)', 4326)); -- Ghaziabad
