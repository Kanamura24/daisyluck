create table if not exists items(
    id bigint unsigned auto_increment primary key comment 'ID',
    title varchar(30) not null unique key comment 'title',
    deadline date not null comment 'deadline',
    status bool not null default false comment 'status',
    elem_noun varchar(30) not null unique key comment 'elemNoun',
    elem_time varchar(30) not null unique key  comment 'elemTime'
);