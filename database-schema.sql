CREATE TABLE `log_entry` (\n  `id` int(11) NOT NULL,\n  `date` datetime DEFAULT NULL,\n  `ip` varchar(255) DEFAULT NULL,\n  `request` varchar(255) DEFAULT NULL,\n  `status` varchar(255) DEFAULT NULL,\n  `user_agent` varchar(255) DEFAULT NULL,\n  PRIMARY KEY (`id`)\n) ENGINE=MyISAM DEFAULT CHARSET=latin1


CREATE TABLE `blocked_ip` (\n  `id` int(11) NOT NULL,\n  `ip` varchar(255) DEFAULT NULL,\n  `reason` varchar(255) DEFAULT NULL,\n  `requests` bigint(20) DEFAULT NULL,\n  PRIMARY KEY (`id`)\n) ENGINE=MyISAM DEFAULT CHARSET=latin1
