# Spring ecommerce 
Simple spring mvc rest api with security and postgres database. Done for software engineering lab course. 

# Endpoints
Deployed on google cloud https://io-labs-ak.ew.r.appspot.com/api

Recieve auth token. In endpoint body pass username and password, either as admin or customer.

POST https://io-labs-ak.ew.r.appspot.com/api/getToken

You have to be authenticated by recieved token to access endpoints. Token exipres every 30 seconds.

Get all resources

GET https://io-labs-ak.ew.r.appspot.com/api/product/all

GET https://io-labs-ak.ew.r.appspot.com/api/customer/all

GET https://io-labs-ak.ew.r.appspot.com/api/order/all

Get resource by id

GET https://io-labs-ak.ew.r.appspot.com/api/product?id=1

GET https://io-labs-ak.ew.r.appspot.com/api/customer?id=1

GET https://io-labs-ak.ew.r.appspot.com/api/order?id=1

Post resource

POST https://io-labs-ak.ew.r.appspot.com/api/admin/product

POST https://io-labs-ak.ew.r.appspot.com/api/admin/customer

POST https://io-labs-ak.ew.r.appspot.com/api/order

Change resource

PUT https://io-labs-ak.ew.r.appspot.com/api/admin/order?id=1

PATCH https://io-labs-ak.ew.r.appspot.com/api/admin/order?id=1


