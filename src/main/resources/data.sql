INSERT INTO televisions (id, type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality,
                         smart_tv,
                         wifi, voice_control, hdr, blue_tooth, ambi_light, original_stock, sold, date_of_purchase,
                         current_stock, energy_label)

VALUES (1002, '43PUS6504/12', 'Philips', 'Television400', 1299.99, 54, 456, 'LED', 'Ultra HD/4K', true, true, true,
        true,
        true, false, 789, 567, '2023-01-01', 78, 'A'),
       (1003, 'NH3216SMART', 'Nikkei', 'HD smart TV', 1789.50, 54, 200, 'LED', 'Ultra HD/4K', true, true, false, true,
        true,
        false, 789, 567, '2023-01-01', 78, 'B'),
       (1004, 'B2450HD', 'Brandt', 'HD smart TV', 2890.00, 54, 150, 'LED', 'Ultra HD/4K', true, true, true, true, true,
        false, 789, 567, '2023-01-01', 78, 'B');

INSERT INTO remote_controls (id, name, brand, compatible_with, original_stock, price, battery_type)
VALUES (1002, 'Philips Remote 1', 'Philips', '43PUS6504/12', 678, 15.99, 'AAA'),
       (1003, 'Nikkei Basic Remote', 'Nikkei', 'NH3216SMART', 34, 10.00, 'AAA'),
       (1004, 'Brandt Remote', 'Brandt', 'B2450HD', 22, 8.99, 'AAA');

INSERT INTO wall_brackets(id)
VALUES (2002),
       (2003),
       (2004);

INSERT INTO televisions_wall_bracket_list(television_list_id, wall_bracket_list_id)
VALUES (1002, 2002),
       (1003, 2003),
       (1004, 2004);

UPDATE televisions
SET compatible_remote_control = 1002
WHERE id = 1002;
UPDATE televisions
SET compatible_remote_control = 1003
WHERE id = 1003;
UPDATE televisions
SET compatible_remote_control = 1004
WHERE id = 1004;

INSERT INTO ci_modules (id, name, price, type)
VALUES (2385, 'QCiModule', 34.99, 'Interactive Module'),
       (2386, 'QUEST', 46.89, 'NetflixMasterModule'),
       (2387, 'BirdView', 99.00, 'LaserCiModule');

UPDATE televisions
SET compatible_ci_module = 2385
WHERE id = 1002;
UPDATE televisions
SET compatible_ci_module = 2386
WHERE id = 1003;
UPDATE televisions
SET compatible_ci_module = 2387
WHERE id = 1004;
