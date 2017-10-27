INSERT INTO `communication` (`id`, `name`, `description`) VALUES
         (261, 'Order Received', 'Notifies a member when their order is received'),
         (264, 'Order Shipped', 'Notifies a member when their order is shipped'),
         (1343, 'Future Fill Held', 'Notifies a member when their order is held due to refill too soon'),	
         (1344, 'Future Fill Split', 'Notifies a member when part of their order is held due to refill too soon'),
         (1907, 'Future Fill Release Reminder',	'The Future Fill Release Reminder alert will be triggered by LINKS and sent to CMP when a prescription is released from future fill'), 
         (1904, 'Ship Consent Initial',	'Initial consent from member'),
         (1905, 'Ship Consent Followup', 'Followup consent from member'),
         (1906, 'Ship Consent Final', 'Final followup consent from member')	

;
INSERT INTO `program` (`id`, `name`, `description`) VALUES
         (1, 'Prescription Alerts', 'PBM Communications including Order Status and Refill Reminder alerts')
;
INSERT INTO `program_configuration` 
         (`name`, `description`, `chan_email_priority`, `chan_ivr_priority`, `chan_sms_priority`, 
          `chan_mail_priority`, `chan_mobile_priority`, `chan_mandatory`, `effective`, `expiration`, 
          `program_id`, `communication_id`) VALUES
         ('Prescription Alerts Order Status', 'Order Status Program-level Configuration', 2, 3, 1, 0, 0, 'Email', 
          '2017-1-1', '9999-12-31', 1, 261)
;