SELECT * FROM parser.log_entry;

SELECT * FROM parser.log_entry WHERE date >= '2016-01-01 00:13:00' AND date <= '2017-02-02 00:13:00';


SELECT (v.ip, COUNT(v)) FROM parser.log_entry v WHERE v.date >= '2017-01-01 00:00:12' AND v.date <= '2017-01-02 00:00:12' AND COUNT(v)>=10 GROUP BY v.ip ;

