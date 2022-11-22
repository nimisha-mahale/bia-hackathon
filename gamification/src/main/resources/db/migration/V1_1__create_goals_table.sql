CREATE TABLE GOALS(
goal_id NUMERIC AUTO_INCREMENT PRIMARY KEY,
goal_name VARCHAR (50) NOT NULL,
event_name VARCHAR (50) NOT NULL,
points NUMERIC NOT NULL,
CONSTRAINT CK_event_name CHECK (event_name IN ('CURRENT_ACCOUNT_OPENED',
                                               'SAVINGS_ACCOUNT_OPENED',
                                               'BANKING_APP_OPENED',
                                               'HOME_INSURANCE_PURCHASED',
                                               'STANDING_ORDER_SETUP',
                                               'CUSTOMER_REFERRAL'))
);

INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (1, 'Open current account', 'CURRENT_ACCOUNT_OPENED',300);
INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (2, 'Open savings account', 'SAVINGS_ACCOUNT_OPENED',200);
INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (3, 'Open banking app', 'BANKING_APP_OPENED',100);
INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (4, 'Purchasing home insurance', 'HOME_INSURANCE_PURCHASED',300);
INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (5, 'Standing order setup', 'STANDING_ORDER_SETUP',200);
INSERT INTO GOALS (goal_id, goal_name,event_name,points) VALUES (6, 'Customer referral', 'CUSTOMER_REFERRAL',100);