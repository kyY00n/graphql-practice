create table category
(
    id   int auto_increment
        primary key,
    name varchar(20) not null
);

create table category_templates
(
    id              bigint auto_increment
        primary key,
    category_id     int          not null,
    label           varchar(200) not null,
    type            varchar(20)  not null,
    data_key        varchar(50)  not null,
    required        bit          not null,
    sequence        smallint     not null,
    placeholder     varchar(100) null,
    help_text       varchar(100) null,
    checkbox_values varchar(200) null,
    initial_value   varchar(100) null
);

INSERT INTO category (id, name)
VALUES (1, '체험권');
INSERT INTO category_templates (id, category_id, label, type, data_key, required, sequence, placeholder, help_text,
                                checkbox_values, initial_value)
VALUES (1, 1, '추천 대상', 'TEXTAREA', 'recommendTo', true, 0, '예) 몸이 뻐근한 분, 건강한 몸을 만들고 싶은 분',
        '이 체험을 추천하고 싶은 사람은 누구인지 알려주세요.', null, null);
INSERT INTO category_templates (id, category_id, label, type, data_key, required, sequence, placeholder, help_text,
                                checkbox_values, initial_value)
VALUES (2, 1, '가게 소개', 'TEXTAREA', 'storeInfo', true, 1, '예) 저희 가게는 ....',
        '체험하는 공간이 어떤지, 얼마나 전문성이 있는지 소개한다면 믿음을 가질 수 있어요.', null, null);
INSERT INTO category_templates (id, category_id, label, type, data_key, required, sequence, placeholder, help_text,
                                checkbox_values, initial_value)
VALUES (3, 1, '이용 안내', 'TEXTAREA', 'serviceInfo', false, 2, '예) 체험 소요시간, 유의사항, 예약방법, 준비물 등',
        '체험 신청 전 알아야 하는 사항이 있다면 알려주세요.', null, null);