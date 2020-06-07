Consul start using vagrant

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

consul docker:

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

Inventory service
Mongo docker :
docker pull mongodb
docker run -p 27017:27017 --name mongodb mongo

Things to start before setting up application in your local:
consul
docker
