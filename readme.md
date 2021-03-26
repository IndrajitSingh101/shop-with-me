# service :

## order:

### Input: OrderEvent
> add/remove items to shopping cart corresponding to shopping cart id

> checkout order

> route to payment service for an order

> update inventory count for an item

output: PaymentEvent

subscribers: inventory / payment 

## payment:

### Input: PaymentEvent

> receive Payment event from order service

> process it against a given vendor

output: PaymentStatusEvent
subscribers : Order


# Consul start using vagrant

Vagrant up

vagrant ssh n1
consul agent -server -bootstrap-expect 1 -data-dir /tmp/consul -ui -client 0.0.0.0 -node=consul-agent1 -bind=172.20.20.10 &

vagrant ssh n2
consul agent -node=agent-two -bind=172.20.20.11 -enable-script-checks=true -data-dir=/tmp/consul -config-dir=/etc/consul.d

in order to destroy vagrant env:
vagrant destroy

/Users/indrajitsingh/study/streaming/kafka/bin/zookeeper-server-stop.sh /Users/indrajitsingh/study/streaming/kafka/config/zookeeper.properties

/Users/indrajitsingh/study/streaming/kafka/bin/kafka-server-start.sh /Users/indrajitsingh/study/streaming/kafka/config/server-1.properties

/Users/indrajitsingh/study/streaming/kafka/bin/kafka-server-start.sh /Users/indrajitsingh/study/streaming/kafka/config/server-2.properties

/Users/indrajitsingh/study/softwares/mongodb/bin/mongod --dbpath /Users/indrajitsingh/study/set-me-up/data

## consul docker:

docker consul pull

server:

docker run \
 -d \
 -p 8500:8500 \
 -p 8600:8600/udp \
 --name=server \
 consul agent -server -ui -node=server-1 -bootstrap-expect=1 -client=0.0.0.0

client :

docker run \
 --name=client-1 \
 consul agent -node=client-1 -join=172.17.0.2

see consul members : docker exec server consul members

## Inventory service
## Mondo DB
Mongo docker :
docker pull mongodb
docker run -p 27017:27017 --name mongodb mongo

Things to start before setting up application in your local:
consul
docker


## Pre-requisite Payment service:
docker pull mysql
docker run -p 3306:3306 --name=mysqltest -e MYSQL_ROOT_PASSWORD=Password -e MYSQL_DATABASE=payment_db -i mysql

## Open-tracing:
docker run -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 jaegertracing/all-in-one:latest
