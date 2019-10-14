# Simple Camel K demo

Make sure you have installed KNative on OpenShift

1. Deploy Camel K operator
2. Setup Ch

```
cd setup
./setup.sh
```

3. Setup Strimzi with Topic name my-topic

4. Run the integration that moves Kafka streams to Channel

```
kamel run -d camel-jackson -d camel-kafka SenderChannels.java

```

5. Run the integration that moves MQTT streams to Kafka

```
kamel run -d camel-kafka -d camel-kafka -d camel-mqtt ReceiverMQTT.java
```

6. Run the listener to Blood Pressure Signal

```
kamel run ChannelBP.java
```

7. Run the listener to Heart Rate Signal

```
kamel run ChannelHR.java
```

8. Run the simulator that sends MQTT signal

```
kamel run -d camel-jackson -d camel-mqtt SenderMQTT.java
```
