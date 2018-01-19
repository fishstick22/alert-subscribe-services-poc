--select 1 from SYSIBM.SYSDUMMY1
INSERT INTO COMMUNICATION (ID, NAME, DESCRIPTION) 
  VALUES 
     (260, 'Refill Available Notice', 'Notifies a member when one or more of their Rx''s is eligible for refill'),
	 (261, 'Order Received ', 'Notifies a member when their order is received'),
	 (263, 'Refill Expiring Notice', 'Notifies a member when one or more of their Rx''s is about to expire but has at least 1 refill left'),
	 (264, 'Order Shipped', 'Notifies a member when their order is shipped'),
	 (2536, 'SHOW DRUG RX', 'Member Preference Pseudo Key for Show Full Drug Name program')
;
	
INSERT INTO PROGRAM 
     (ID, NAME, DESCRIPTION,
      HOUSE_KPG_CREATE_TIME, HOUSE_KPG_CREATE_TRAN_CD, HOUSE_KPG_CREATE_USER, 
      HOUSE_KPG_UPDATE_TIME, HOUSE_KPG_UPDATE_TRAN_CD, HOUSE_KPG_UPDATE_USER) VALUES
     (101, 'Prescription Alerts', 'PBM Communications including Order Status and Refill Reminder alerts',
      CURRENT_TIMESTAMP, '0', 'CMP', CURRENT_TIMESTAMP, '0', 'CMP'),
     (102, 'Non-Prescription Alerts', 'PBM non-transactional Communications like Portal Registration, Password Recovery',
      CURRENT_TIMESTAMP, '0', 'CMP', CURRENT_TIMESTAMP, '0', 'CMP'),
     (103, 'Show Full Drug Names', 'Program that supports member opt-in to receive full drug names on email alerts',
      CURRENT_TIMESTAMP, '0', 'CMP', CURRENT_TIMESTAMP, '0', 'CMP')
; 

INSERT INTO PROGRAM_PROFILE ( --ID AUTO GENERATED
      DEFAULT_OPT_IN, 
           VISIBLE_IN_UI, 
                CHAN_EMAIL, 
                     CHAN_IVR, 
                          CHAN_SMS, 
                               CHAN_SECURE, 
                                    CHAN_MAIL, 
                                         CHAN_MOBILE, 
                                              EFFECTIVE, EXPIRATION, PROGRAM_ID) VALUES
     ('Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', '2017-1-1',  '9999-12-31', 101 ),
     ('N', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'N', '2017-1-1',  '9999-12-31', 102 ),
     ('N', 'P', 'Y', 'N', 'N', 'N', 'N', 'N', '2017-1-1',  '9999-12-31', 103 )
;

INSERT INTO PROGRAM_CONFIGURATION 
     (CHAN_EMAIL_PRIORITY, 
         CHAN_IVR_PRIORITY, 
            CHAN_SMS_PRIORITY, 
               CHAN_SECURE_PRIORITY,
                  CHAN_MAIL_PRIORITY, 
                     CHAN_MOBILE_PRIORITY, 
                        CHAN_DEFAULT,
                                 REQUIRED,
                                       MANDATORY, 
                                           EFFECTIVE, EXPIRATION, PROGRAM_ID, COMMUNICATION_ID) VALUES
     (2, 3, 1, 0, 0, 0, 'Email', 'N', 'N', '2017-1-1', '9999-12-31', 101, 261),
     (1, 0, 0, 0, 0, 0, 'No',    'N', 'N', '2017-1-1', '9999-12-31', 103, 2536)
;

INSERT INTO CLIENT (ID, CODE, NAME) VALUES 
	 (142, 'AMD', 'AT&T INC.'),
	 (259, 'BCC', 'BLUE CROSS OF CONNECTICUT'),
	 (339, 'BCAL', 'BLUE CROSS OF ALABAMA'),
	 (428, 'BOH', 'BLUE CROSS OF OHIO')
;

INSERT INTO CLIENT_CONFIGURATION 
     (CHAN_EMAIL_PRIORITY, 
         CHAN_IVR_PRIORITY, 
            CHAN_SMS_PRIORITY,
               CHAN_SECURE_PRIORITY,
                  CHAN_MAIL_PRIORITY, 
                     CHAN_MOBILE_PRIORITY, 
                        CHAN_DEFAULT,
                                 REQUIRED,
                                      MANDATORY, 
                                           EFFECTIVE, EXPIRATION, CLIENT_ID, COMMUNICATION_ID) VALUES
     (2, 3, 1, 0, 0, 0, 'Email', 'N', 'N', '2017-1-1', '9999-12-31', 142, 261)
;

INSERT INTO COMMUNICATION (ID, NAME, DESCRIPTION) 
  VALUES 	 
  	 (1230, 'RFM Auto Renewal ', 'Notifies a member when we will be reaching out to their Dr. to get a new RX as part as the ReadyFill at Mail (RFM) program'),
	 (1231, 'RFM Auto Refill ', 'Notifies a member when we will be automatically refilling their Rx as part as the ReadyFill at Mail (RFM) program'),
	 (1232, 'RFM MD Denied ', 'Notifies a member when their Dr. Denied our request for a new Rx as part of the ReadyFill at Mail (RFM) program'),
	 (1233, 'RFM MD Unresponsive ', 'Notifies a member when their Dr. was unresponsive to our request for a new Rx as part of ReadyFill at Mail (RFM) program'),	 
	 (1229, 'Zero Refills Notice', 'Notifies a member when one or more of their Rx''s has no more refills available'),
	 (1343, 'Future Fill Held ', 'Notifies a member when their order is held due to refill too soon'),
	 (1344, 'Future Fill Split ', 'Notifies a member when part of their order is held due to refill too soon'),
	 (1907, 'Future Fill Release Reminder', 'Notifies a member when a prescription is released from future fill'),
	 (1904, 'Ship Consent Initial', 'Initial consent from member'),
	 (1905, 'Ship Consent Followup', 'Followup consent from member'),
	 (1906, 'Ship Consent Final', 'Final followup consent from member'),
	 (1859, 'Doctor Hold', 'Notifies member when Order is Held by Doctor.'),
	 (1861, 'Cannot Fill', 'Notifies member when Order cannot be filled (previously RTP)'),
	 (1341, 'RTP (Return to Participant) w/ MD Contact', 'Notifies a member when their order cannot be filled and we tried to contact their Doctor'),
	 (1342, 'RTP (Return to Participant) w/o MD Contact', 'Notifies a member when their order cannot be filled but we did not reach out to their doctor'),
	 (2514, 'Refill Available Reminder', 'Notifies a member when one or more of their Rx''s is eligible for refill'),
	 (2515, 'Refill Available Warning', 'Notifies a member when one or more of their Rx''s is eligible for refill'),
	 (2516, 'Refill Expiring Reminder', 'Notifies a member when one or more of their Rx''s is about to expire but has at least 1 refill left'),
	 (2517, 'Refill Expiring Warning', 'Notifies a member when one or more of their Rx''s is about to expire but has at least 1 refill left'),
	 (2518, 'Zero Refills Reminder', 'Notifies a member when one or more of their Rx''s has no more refills available'),
	 (2519, 'Zero Refills Warning', 'Notifies a member when one or more of their Rx''s has no more refills available')
  ;

  INSERT INTO CLIENT (ID, CODE, NAME) VALUES 
	 (10203, 'BCBSN', 'BLUE CROSS BLUE SHIELD OF NC'),
	 (11254, 'BCOGA', 'BLUE CROSS/BLUE SHIELD GEORGIA'),
	 (11614, 'BCCAL', 'BLUE CROSS/BS OF CALIFORNIA'),
	 (11643, 'BCOMI', 'BLUE CROSS OF MICHIGAN'),
	 (12130, 'BCBSA', 'BLUE CROSS BLUE SHIELD ASSOC.'),
	 (12675, 'BCORO', 'BLUE CROSS OF ROCHESTER'),
	 (14481, 'ZC342', 'BLUE CROSS IDAHO-HMO'),
	 (14482, 'ZC343', 'BLUE CROSS IDAHO-PPO'),
	 (14606, 'ZCC01', 'BLUE CROSS BLUE SHIELD OF TENN'),
	 (14647, 'ZD110', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14648, 'ZD112', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14649, 'ZD115', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14650, 'ZD118', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14651, 'ZD120', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14652, 'ZD124', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14653, 'ZD133', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14654, 'ZD134', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14655, 'ZD135', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14656, 'ZD136', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14688, 'ZDELA', 'BLUE CROSS BLUE SHIELD OF DELA'),
	 (14709, 'ZE020', 'BLUE CROSS BLUE SHIELD OF TENN'),
	 (14739, 'ZE936', 'BLUE CROSS BLUE SHIELD OF TENN'),
	 (14740, 'ZE937', 'BLUE CROSS BLUE SHIELD OF TENN'),
	 (16058, 'ZT138', 'BLUE CROSS BLUE SHIELD OF TENN'),
	 (17201, 'BCBS1', 'BLUE CROSS BLUE SHIELD OF MN'),
	 (17345, 'ZTCDH', 'BLUE CROSS BLUE SHIELD OF TN'),
	 (18920, 'TXBCS', 'BLUE CROSS BLUE SHIELD OF TX'),
	 (22127, 'BCBAZ', 'BLUE CROSS BLUE SHIELD OF AZ'),
	 (22162, 'BCBSMI', 'BLUE CROSS BLUE SHIELD MI'),
	 (22270, 'BBONT', 'BLUE CROSS BLUE SHIELD'),
	 (22475, 'BCBIL', 'BLUE CROSS BLUE SHIELD OF IL'),
	 (22912, 'X7700', 'AETNA-PPO'),
	 (22913, 'X7705', 'AETNA-SRC'),
	 (22914, 'X7710', 'AETNA-AGB'),
	 (22915, 'X7715', 'AETNA-DISCOUNT CARE'),
	 (22916, 'X7720', 'AETNA-ASH'),
	 (22917, 'X7730', 'AETNA-HMO'),
	 (22918, 'X7750', 'AETNA-MCPP - MEDICAL BNFT'),
	 (22919, 'X7760', 'AETNA-HNO'),
	 (22920, 'X7770', 'AETNA-MED-D PDP S5810'),
	 (22921, 'X7771', 'AETNA-MED-D MAPD H0318'),
	 (22922, 'X7772', 'AETNA-MED-D MAPD H0523'),
	 (22923, 'X7773', 'AETNA-MED-D MAPD H0901'),
	 (22924, 'X7774', 'AETNA-MED-D MAPD H1109'),
	 (22925, 'X7775', 'AETNA-MED-D MAPD H1110'),
	 (22926, 'X7776', 'AETNA-MED-D MAPD H1419'),
	 (22927, 'X7777', 'AETNA-MED-D MAPD H2112'),
	 (22928, 'X7778', 'AETNA-MED-D MAPD H3152'),
	 (22929, 'X7779', 'AETNA-MED-D MAPD H3312'),
	 (22930, 'X7780', 'AETNA-MED-D MAPD H3597'),
	 (22931, 'X7781', 'AETNA-MED-D MAPD H3623'),
	 (22932, 'X7782', 'AETNA-MED-D MAPD H3931'),
	 (22933, 'X7783', 'AETNA-MED-D MAPD H4523'),
	 (22934, 'X7784', 'AETNA-MED-D MAPD H4524'),
	 (22935, 'X7785', 'AETNA-MED-D MAPD H4910'),
	 (22936, 'X7786', 'AETNA-MED-D MAPD H5414'),
	 (22937, 'X7787', 'AETNA-MED-D MAPD H5521'),
	 (22938, 'X7788', 'AETNA-MED-D MAPD H5793'),
	 (22939, 'X7789', 'AETNA-MED-D MAPD H5813'),
	 (22940, 'X7795', 'AETNA-MED-D MAPD UNSPECIFIED'),
	 (22941, 'X7790', 'AETNA-MED-D MAPD H5832'),
	 (22942, 'X7791', 'AETNA-MED-D MAPD H5950'),
	 (22943, 'X7792', 'AETNA-MED-D MAPD H6923'),
	 (22944, 'X7793', 'AETNA-MED-D MAPD H7908'),
	 (22945, 'X7794', 'AETNA-MED-D MAPD H8684'),
	 (23156, 'X6370', 'IBM'),
	 (23157, 'X6371', 'IBM - MVP'),
	 (23158, 'X6372', 'IBM - AETNA'),
	 (23159, 'X6373', 'IBM - ANTHEM'),
	 (23160, 'X6374', 'IBM - UNITED'),
	 (23636, 'X3355', 'AT&T WRAP'),
	 (23695, 'X6349', 'AT&T COMMERCIAL'),
	 (24016, 'X7701', 'AETNA PPO CAREMARK MAIL'),
	 (24366, 'X7702', 'AETNA-PPO ACS JOINT VNTR'),
	 (24367, 'X7762', 'AETNA-HNO ACS JOINT VNTR'),
	 (24421, 'X7741', 'AETNA-MEDD PDP S5810 CMX'),
	 (24422, 'X7742', 'AETNA-MEDD MAPD H8684 CMX'),
	 (24423, 'X7743', 'AETNA-MEDD MAPD H5521 CMX'),
	 (24424, 'X7744', 'AETNA-MEDD MAPD H4524 CMX'),
	 (24425, 'X7745', 'AETNA-MEDD MAPD H3931 CMX'),
	 (24426, 'X7746', 'AETNA-MEDD MAPD H3152 CMX'),
	 (24427, 'X7747', 'AETNA-MEDD MAPD H1110 CMX'),
	 (24428, 'X7748', 'AETNA-MEDD MAPD H0523 CMX'),
	 (24438, 'X7703', 'AETNA-PPO PUBLIC ON HIX'),
	 (24439, 'X7749', 'AETNA-MCPP-MEDCAREMEDICAL'),
	 (24440, 'X7763', 'AETNA-HNO PUBLIC ON HIX'),
	 (24918, 'X3274', 'AT&T EXEC STCOB'),
	 (24948, 'X7796', 'AETNA-MED-D MAPD H6560'),
	 (25277, 'X7798', 'AETNA-MED-D SMOOP TRACK'),
	 (25293, 'X7797', 'AETNA-MED-D SMOOP-DOW'),
	 (25350, 'X7706', 'AETNA-CP INDIVIDUAL'),
	 (25351, 'X7707', 'AETNA-CP GROUP'),
	 (25352, 'X7708', 'AETNA-CP INDIV JOINT VNTR'),
	 (25353, 'X7709', 'AETNA-CP GROUP JOINT VNTR'),
	 (25354, 'X7711', 'AETNA-CP INDIV PUB ON HIX'),
	 (25355, 'X7712', 'AETNA-CP GROUP PUB ON HIX'),
	 (25356, 'X7713', 'AETNA-CP IND JT VN ON HIX'),
	 (25357, 'X7714', 'AETNA-CP GRP JT VN ON HIX'),
	 (25365, 'X7721', 'AETNA-MCPP-MEDCRS MDCL CV'),
	 (25366, 'X7722', 'AETNA-MED-D PDP S5768 CV'),
	 (25367, 'X7723', 'AETNA-MED-D MAPD H1608 CV'),
	 (25368, 'X7724', 'AETNA-MED-D MAPD R6694'),
	 (25369, 'X7725', 'AETNA-MED-D MAPD H1609 CV'),
	 (25370, 'X7726', 'AETNA-MED-D MAPD H1692 CV'),
	 (25371, 'X7727', 'AETNA-MED-D MAPD H2663 CV'),
	 (25372, 'X7728', 'AETNA-MED-D MAPD H2667 CV'),
	 (25373, 'X7729', 'AETNA-MED-D MAPD H2672 CV'),
	 (25374, 'X7731', 'AETNA-MED-D MAPD H3928 CV'),
	 (25375, 'X7732', 'AETNA-MED-D MAPD H3959 CV'),
	 (25376, 'X7733', 'AETNA-MED-D MAPD H5302 CV'),
	 (25377, 'X7734', 'AETNA-MED-D MAPD H5414 CV'),
	 (25378, 'X7735', 'AETNA-MED-D MAPD H5522 CV'),
	 (25379, 'X7736', 'AETNA MEDICARE FUTURE USE'),
	 (25380, 'X7737', 'AETNA-MED-D MAPD H7149 CV'),
	 (25381, 'X7738', 'AETNA-MED-D MAPD H7301 CV'),
	 (25382, 'X7739', 'AETNA MEDICARE FUTURE USE'),
	 (25383, 'X7740', 'AETNA-MED-D MAPD H8649 CV'),
	 (26278, 'X7704', 'AETNA-PPO STRATIGIC FORM'),
	 (26279, 'X7716', 'AETNA-PPO TEXAS HEALTH JV'),
	 (26280, 'X7717', 'AETNA-HNO TEXAS HEALTH JV'),
	 (26281, 'X7718', 'AETNA-PPO BANNER HLTH JV'),
	 (26282, 'X7719', 'AETNA-HNO BANNER HLTH JV'),
	 (26283, 'X7764', 'AETNA-NG MAPD H1100 IH JV'),
	 (26284, 'X7765', 'AETNA-NG MAPD H2829 IH JV'),
	 (35052, 'X7751', 'AETNAREBATES NOADJ PPO'),
	 (35053, 'X7752', 'AETNAREBATES NOADJ HNO'),
	 (35054, 'X7753', 'AETNAREBATES RESERVED'),
	 (35425, 'X7754', 'AETNA'),
	 (35426, 'X7755', 'AETNA')
;