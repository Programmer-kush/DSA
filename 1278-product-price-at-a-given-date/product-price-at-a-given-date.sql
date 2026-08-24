# Write your MySQL query statement below
select product_id,
new_price as price
from Products 
where change_date in (
    select max(p2.change_date)
    from Products p2
    where p2.product_id = Products.product_id and p2.change_date <= '2019-08-16'
) 
group by product_id

UNION

SELECT product_id, 10 AS price
FROM Products
GROUP BY product_id
HAVING MIN(change_date) > '2019-08-16';