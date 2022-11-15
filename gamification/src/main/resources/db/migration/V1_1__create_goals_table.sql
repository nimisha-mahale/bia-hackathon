CREATE TABLE GOALS(
goal_id NUMERIC AUTO_INCREMENT PRIMARY KEY,
goal_name VARCHAR (50) NOT NULL,
event_name VARCHAR (50) NOT NULL,
points NUMERIC NOT NULL,
CONSTRAINT CK_event_name CHECK (event_name IN ('CURRENT_ACCOUNT_OPENED',
                                                   'SAVINGS_ACCOUNT_OPENED',
                                                   'BANKING APP OPENED',
                                                   'HOME_INSURANCE_PURCHASED',
                                                   'STANDING_ORDER_SETUP',
                                                   'CUSTOMER_REFERRAL'))
);