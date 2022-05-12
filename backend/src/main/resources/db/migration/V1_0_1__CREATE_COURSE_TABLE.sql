create table user_access.user
(
    id           bigserial    not null,
    username     varchar(20)  not null,
    password     varchar(100) not null,
    name         text         not null,
    gender       int          not null,
    is_admin     boolean      not null default false,
    birthday     timestamp(3) not null,
    phone_num    varchar(15),
    home_address text,
    constraint user_pk PRIMARY KEY (id),
    constraint username_unique unique (username)
);
