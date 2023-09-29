CREATE TABLE IF NOT EXISTS couriers
(
    id   bigserial primary key,
    type varchar(20)
);

CREATE TABLE IF NOT EXISTS orders
(
    id     bigserial primary key,
    cost   numeric not null,
    region bigint  not null,
    weight numeric not null,
    order_complete_time timestamp
);

CREATE TABLE IF NOT EXISTS intervals
(
    id        bigserial primary key,
    from_time time not null,
    to_time   time not null
);

CREATE TABLE IF NOT EXISTS orders_delivery_intervals
(
    order_id             bigint not null,
    delivery_interval_id bigint not null,
    primary key (order_id, delivery_interval_id),
    constraint orders_delivery_intervals_orders foreign key (order_id) references orders (id) on delete cascade on update no action,
    constraint orders_delivery_intervals_intervals foreign key (delivery_interval_id) references intervals (id) on delete cascade on update no action
);

CREATE TABLE IF NOT EXISTS couriers_regions
(
    courier_id bigint,
    region     bigint,
    constraint couriers_regions_couriers foreign key (courier_id) references couriers (id) on delete cascade on update no action
);

CREATE table IF NOT EXISTS couriers_orders
(
    courier_id bigserial,
    orders_id   bigserial,
    primary key (courier_id, orders_id),
    constraint couriers_orders_couriers foreign key (courier_id) references couriers (id) on delete cascade on update no action,
    constraint couriers_orders_orders foreign key (orders_id) references orders (id) on delete cascade on update no action
);

CREATE TABLE IF NOT EXISTS couriers_working_hours(
    courier_id bigserial,
    working_hours_id bigserial,
    primary key (courier_id, working_hours_id),
    constraint couriers_working_hours_couriers foreign key (courier_id) references couriers (id) on delete cascade on update no action,
    constraint couriers_working_hours_working_hours foreign key (working_hours_id) references intervals(id) on delete cascade on update no action
);