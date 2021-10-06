#!/bin/bash

#-i, --include Include HTTP headers in the output.!!!!!
# More command options: https://gist.github.com/subfuzion/08c5d85437d5d4f00e58
response=$(curl -i --request POST localhost:8080/public/login \
  -H 'Content-type:application/json' \
  -d '{"username": "krzysieksr", "password": "dupa"}')

token=$(echo "$response" | grep "Authorization" | awk '{print $2}')

curl -X POST localhost:8080/cart/1 -H "Accept: application/json" -H "Authorization: Bearer $token"

curl -X PATCH localhost:8080/cart/1 -H "Accept: application/json" -H "Authorization: Bearer $token" \
  -H 'Content-type:application/json' -d \
  '{"productId": "2", "amount": "4"}'

curl -v localhost:8080/order/1 -H "Accept: application/json" -H "Authorization: Bearer $token" | json_pp
