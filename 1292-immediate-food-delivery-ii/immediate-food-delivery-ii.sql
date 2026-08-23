select round(100 * avg(order_date= customer_pref_delivery_date),2) 
as immediate_percentage
from Delivery 
where order_date = (
    select MIN(order_date)
    from Delivery d2
    where d2.customer_id=Delivery.customer_id
)