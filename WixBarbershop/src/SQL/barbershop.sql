use Barbershop;

drop table productOrderDetail;
drop table product;
drop table productOrder;
drop table sysAdmin;
drop table serviceDate;
drop table serviceType;
drop table service;
drop table userAddress;
drop table sysUser;
drop table address;

create table if not exists product(
	productId 	integer auto_increment primary key,
    descript	varchar(255),
    price		integer not null,
    rating		decimal(4,2),
    quantity	integer not null
);

alter table product add constraint check_price check(price >= 0);
alter table product add constraint check_rating check(rating >= 0 and rating <= 10);
alter table product add constraint check_quantity check(quantity >= 0);

create table if not exists productOrder(
	orderId integer auto_increment primary key,
    orderStatus varchar(255) not null,
    orderDate date not null
);

alter table productOrder add constraint chek_po_status check(
	orderStatus = 'ACEPTADO' or 
    orderStatus = 'ENTREGADO' or
    orderStatus = 'EN CAMINO' or
    orderStatus = 'CANCELADO' or
    orderStatus = 'PAGADO'
);

create table if not exists productOrderDetail(
	productId integer,
    orderId integer,
    quantity integer,
    primary key (productId,orderId)
);

alter table productOrderDetail add constraint fk_product foreign key (productId) references product(productId) on delete cascade on update cascade;
alter table productOrderDetail add constraint fk_order foreign key (orderId) references productOrder(orderId) on delete cascade on update cascade;
alter table productOrderDetail add constraint check_quantity check(quantity > 0);

create table if not exists sysAdmin(
	adminId integer auto_increment primary key,
    username varchar(100) unique not null,
    adminPass varchar(100) not null
);

create table if not exists address(
	addressId integer auto_increment primary key,
    city varchar(255),
    detail varchar(255) not null,
    additionalInfo varchar(255),
    neighborhood varchar(255) not null
);

create table if not exists sysUser(
	userId integer auto_increment primary key,
    username varchar(255) not null,
    phone integer,
    usertype varchar(255) not null,
    userPass varchar(255) not null
);

alter table sysUser add constraint check_phone check(phone > 999999999 and phone <= 9999999999);
alter table sysUser add constraint check_type check(userType = 'BARBER' or userType = 'CLIENT');

create table if not exists userAddress(
	userId integer,
    addressId integer,
    primary key (userId, addressId)
);

alter table userAddress add constraint fk_user foreign key (userId) references sysUser(userId) on delete cascade on update cascade;
alter table userAddress add constraint fk_address foreign key (addressId) references address(addressId) on delete cascade on update cascade;

create table if not exists service(
	serviceId integer auto_increment primary key,
    details varchar(255) not null,
    price double
);

alter table service add constraint check_price check(price >= 0);

create table if not exists serviceType(
	typeId integer auto_increment primary key,
    typename varchar(255) not null
);

create table if not exists serviceDate(
	idDate integer auto_increment primary key,
    clientId integer not null,
    barberId integer not null,
    serviceType integer not null,
    addId integer not null,
    serviceId integer not null,
    serviceDate date not null
);

alter table serviceDate add constraint fk_client foreign key (clientId) references sysUser(userId)on delete cascade on update cascade;
alter table serviceDate add constraint fk_barber foreign key (barberId) references sysUser(userId) on delete cascade on update cascade;
alter table serviceDate add constraint fk_type foreign key (serviceType) references serviceType(typeId) on delete cascade on update cascade;
alter table serviceDate add constraint fk_service foreign key (serviceId) references service(serviceId) on delete cascade on update cascade;
alter table serviceDate add constraint fk_address_service foreign key (addId) references address(addressId) on delete cascade on update cascade;

