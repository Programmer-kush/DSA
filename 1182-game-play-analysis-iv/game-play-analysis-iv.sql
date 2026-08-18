# Write your MySQL query statement below
select round(sum(DATEDIFF(e2.event_date, e1.event_date)=1)/count(distinct e2.player_id),2) as fraction  
from Activity e1 join Activity e2
on e1.player_id=e2.player_id
AND e1.event_date = (
    SELECT MIN(e3.event_date)
    FROM Activity e3
    WHERE e3.player_id = e1.player_id
);