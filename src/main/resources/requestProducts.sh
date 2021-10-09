#!/bin/bash

# See all products list
curl -v localhost:8080/products | json_pp

# See details about product with productId
for productId in 2 4 6 8 10 12; do
curl -v localhost:8080/products/details/$productId | json_pp
done
