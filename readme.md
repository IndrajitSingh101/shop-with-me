Consul start using vagrant

Vagrant up 

vagrant ssh n1
consul agent -server -bootstrap-expect 1 -data-dir /tmp/consul -ui -client 0.0.0.0 -node=consul-agent1 -bind=172.20.20.10 &

vagrant ssh n2
consul agent   -node=agent-two   -bind=172.20.20.11   -enable-script-checks=true   -data-dir=/tmp/consul   -config-dir=/etc/consul.d

in order to destroy vagrant env:
vagrant destroy


/Users/indrajitsingh/study/streaming/kafka/bin/zookeeper-server-stop.sh /Users/indrajitsingh/study/streaming/kafka/config/zookeeper.properties

/Users/indrajitsingh/study/streaming/kafka/bin/kafka-server-start.sh /Users/indrajitsingh/study/streaming/kafka/config/server-1.properties 

/Users/indrajitsingh/study/streaming/kafka/bin/kafka-server-start.sh /Users/indrajitsingh/study/streaming/kafka/config/server-2.properties


/Users/indrajitsingh/study/softwares/mongodb/bin/mongod --dbpath /Users/indrajitsingh/study/set-me-up/data