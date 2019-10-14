#!/bin/bash

kamel kit create --image=lburgazzoli/camel-k-quarkus:1.0.2-SNAPSHOT camel-quarkus
oc create -f channel-bp.yaml
oc create -f channel-bt.yaml
oc create -f channel-hr.yaml
oc new-app --template=amq63-basic --param=MQ_USERNAME=amq --param=MQ_PASSWORD=password --param=MQ_PROTOCOL=mqtt,amqp,openwire
