INSERT INTO client (name) VALUES
    ('Boba Fett'),
    ('Anakin Skywalker'),
    ('Obi-Wan Kenobi'),
    ('Master Yoda'),
    ('Palpatine'),
    ('Han Solo'),
    ('Luke Skywalker'),
    ('Chewbacca'),
    ('Ahsoka Tano'),
    ('Princess Leia');

INSERT INTO planet (id, name) VALUES
    ('COR001', 'Coruscant'),
    ('MUS002', 'Mustafar'),
    ('BES003', 'Bespin'),
    ('SCA004', 'Scarif'),
    ('TAT005', 'Tatooine');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    ('2023-11-26 12:23:00', 3, 'COR001', 'TAT005'),
    ('2024-01-15 11:02:00', 3, 'TAT005', 'SCA004'),
    ('2024-05-15 14:15:00', 1, 'BES003', 'TAT005'),
    ('2024-07-05 21:49:00', 2, 'MUS002', 'COR001'),
    ('2024-04-30 09:00:00', 5, 'TAT005', 'COR001'),
    ('2024-03-26 12:30:00', 6, 'BES003', 'COR001'),
    ('2024-07-03 20:22:00', 7, 'BES003', 'MUS002'),
    ('2023-12-24 12:12:00', 8, 'TAT005', 'COR001'),
    ('2024-01-05 09:00:00', 9, 'COR001', 'TAT005'),
    ('2024-06-07 13:00:00', 10, 'COR001', 'MUS002');