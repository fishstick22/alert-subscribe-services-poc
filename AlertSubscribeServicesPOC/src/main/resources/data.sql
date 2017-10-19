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
INSERT INTO `program_configuration` (`name`, `description`, `program_id`) VALUES
         ('Prescription Alerts Order Status', 'Order Status Program-level Configuration', 1)
;