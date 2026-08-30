# Write your MySQL query statement below
select round(count(distinct a1.player_id)/(select count(distinct player_id) from Activity),2) as fraction 
from Activity a1 
join Activity a2 
on a1.player_id = a2.player_id
where datediff(a2.event_date,a1.event_date) =1
and (a1.player_id,a1.event_date)  in (
    select distinct player_id,min(event_date)
    from Activity
    group by player_id

)