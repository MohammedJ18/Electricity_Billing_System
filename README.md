# Electricity Billing System
# To run the project you need to creat database named "electricity"
and create tables:
 # login(meter_no varchar(20), username varchar(30), name varchar(30), password varchar(30), user varchar(30))
 # customer(name varchar(30), meter varchar(20), address varchar(50), email varchar(30), phone varchar(20))
 # meter_info(meter_number varchar(20), bill_type varchar(20))
 # tax(cost_per_unit varchar(20), meter_rent varchar(20), service_charge varchar(20), service_tax varchar(20), fixed_tax varchar(20))
 # bill(meter varchar(20), month varchar(20), units varchar(20), total_bill varchar(20), status varchar(20))
 
 # and insert initial value in tax table ( '100', '25', '25', '25', '25')
