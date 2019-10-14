import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import java.util.Random;

//kamel run MQTTSender.java --dev -d camel-jackson

public class MQTTSender extends RouteBuilder {

  private static Random ran = new Random(); 

  @Override
  public void configure() throws Exception {
    from("timer:tick?fixedRate=true&period=2000")
      .setBody(method(this, "genRandoSingalInput()"))
      .marshal(new JacksonDataFormat())
      .log("To MQTT --- ${body}")
      .to("mqtt:mqtt?publishTopicName=mytopic&host=tcp://broker-amq-mqtt.usecase.svc:1883&userName=amq&password=password");
  }

  public static class SingalInput {
    public String type;
    public int value;
  }

  public static SingalInput genRandoSingalInput(){
      SingalInput signal = new SingalInput();
      switch(ran.nextInt(3))  {
        case 0:
          signal.type = "HR";
          break;
        case 1:
          signal.type = "BT";
          break;
        case 2:
          signal.type = "BP";
          break;
      }
      signal.value = ran.nextInt(600);
      return signal;
  }

}
