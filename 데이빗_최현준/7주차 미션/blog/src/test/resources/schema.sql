drop table if exists post;
create table post (
    post_id bigint not null auto_increment,
    content varchar(255),
    title varchar(255),
    writer varchar(255),
    primary key (post_id)
);