# 安装参考：
https://www.cnblogs.com/lnice/p/9668750.html  （windows版本）
https://blog.csdn.net/xuzhelin/article/details/71515208 （Linux版本）


# kafka配置
#Licensed to the Apache Software Foundation (ASF) under one or more
#contributor license agreements.  See the NOTICE file distributed with
#this work for additional information regarding copyright ownership.
#The ASF licenses this file to You under the Apache License, Version 2.0
#(the "License"); you may not use this file except in compliance with
#the License.  You may obtain a copy of the License at
#http://www.apache.org/licenses/LICENSE-2.0
#Unless required by applicable law or agreed to in writing, software
#distributed under the License is distributed on an "AS IS" BASIS,
#WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#See the License for the specific language governing permissions and
#limitations under the License.

#see kafka.server.KafkaConfig for additional details and defaults

############################# Server Basics #############################

#The id of the broker. This must be set to a unique integer for each broker.
broker.id=2

############################# Socket Server Settings #############################
port=9092
host.name=192.168.18.113
#The address the socket server listens on. It will get the value returned from 
#java.net.InetAddress.getCanonicalHostName() if not configured.
#FORMAT:

listeners=PLAINTEXT://192.168.18.113:9092
advertised.listeners=PLAINTEXT://192.168.18.113:9092

num.network.threads=3

num.io.threads=8

socket.send.buffer.bytes=102400

socket.receive.buffer.bytes=102400

socket.request.max.bytes=104857600


############################# Log Basics #############################

log.dirs=.\logs\kafka

#每个topic的分区个数，若是在topic创建时候没有指定的话会被topic创建时的指定参数覆盖
#(如果一个topic对应一个文件，那这个文件所在的机器I/O将会成为这个topic的性能瓶颈，而partition解决了这个问题)
num.partitions=3

num.recovery.threads.per.data.dir=1

############################# Internal Topic Settings  #############################

#副本数
offsets.topic.replication.factor=3
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1
default.replication.factor=3

############################# Log Flush Policy #############################
#log.flush.interval.messages=10000

#log.flush.interval.ms=1000

############################# Log Retention Policy #############################
log.retention.hours=168

#log.retention.bytes=1073741824

log.segment.bytes=1073741824

log.retention.check.interval.ms=300000

############################# Zookeeper #############################

zookeeper.connect=localhost:2181,localhost:2182,localhost:2183

zookeeper.connection.timeout.ms=6000


############################# Group Coordinator Settings #############################
group.initial.rebalance.delay.ms=0
max.in.flight.requests.per.connection=1


# zookeeper配置

dataDir=./zkData
dataLogDir=./logs/zk
clientPort=2182
maxClientCnxns=100
tickTime=2000
initLimit=10
syncLimit=5

server.1=192.168.18.113:2888:3888
server.2=192.168.18.113:2889:3889
server.3=192.168.18.113:2890:3890
