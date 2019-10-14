#!/bin/bash
kamel kit create --image=lburgazzoli/camel-k-quarkus:1.0.2-SNPASHOT camel-quarkus
kamel run --dev ChannelHR.yaml --kit camel-q