
INSERT IGNORE INTO floors (`number`)
VALUES (0), (1), (2), (3), (4), (5), (6), (7), (8), (9), (10), (11), (12), (13), (14), (15), (16), (17), (18), (19), (20);

INSERT IGNORE INTO estate_types (`type`)
VALUES ('1-СТАЕН'), ('2-СТАЕН'), ('3-СТАЕН'), ('4-СТАЕН'), ('МНОГОСТАЕН'), ('МЕЗОНЕТ'), ('АТЕЛИЕ, ТАВАН');

INSERT IGNORE INTO ad_types (`type`)
VALUES ('ПРОДАВА'), ('ДАВА ПОД НАЕМ');

INSERT IGNORE INTO estate_features (`feature`)
VALUES ('В строеж'), ('С преход'), ('Асансьор'), ('С гараж'), ('С паркинг'), ('Лизинг'), ('Ипотекиран'), ('Бартер'),
       ('Интернет връзка'), ('С действащ бизнес'), ('Обзаведен'), ('Видео наблюдение'), ('Контрол на достъпа'), ('Охрана'),
       ('Саниран');