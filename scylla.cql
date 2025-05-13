DROP KEYSPACE IF EXISTS subscription_service;

CREATE KEYSPACE subscription_service
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 3};

USE subscription_service;


CREATE TABLE subscriptions (
    subscription_id UUID,
    user_id UUID,
    payment_date TIMESTAMP,
    update_date TIMESTAMP,
    end_date TIMESTAMP,
    plan_id UUID,
    status TEXT,
    payment_method_id UUID,
    PRIMARY KEY (subscription_id)
);

CREATE TABLE promo_code (
    id UUID ,
    code TEXT,
    validity INT,
    discount INT,
    status TEXT,
    start_date TIMESTAMP,
    PRIMARY KEY ((id), code)
);

CREATE TABLE plans (
    plan_id UUID,
    category TEXT,
    description LIST<TEXT>,
    content TEXT,
    amount DECIMAL,
    duration INT,
    PRIMARY KEY(plan_id)
);

CREATE TABLE payment_methods (
    payment_method_id UUID,
    user_id UUID,
    method_type TEXT,
    card_number TEXT,
    expiration_date TEXT,
    cvc TEXT,
    provider TEXT,
    phone_number TEXT,
    paypal_email TEXT,
    PRIMARY KEY (payment_method_id)
);

CREATE TABLE history (
    payment_id UUID,
    user_id UUID,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    status TEXT,
    method_type TEXT,
    plan_id UUID,
    payment_method_id UUID,
    PRIMARY KEY (user_id)
);