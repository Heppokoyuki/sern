#include <WiFi.h>
#include <WiFiUdp.h>

WiFiServer server(80);

const char ssid[] = "http://twitter.com/heppoko_yuki"; // SSID
const char pass[] = "mokemoke";  // password
const int localPort = 12;      // ポート番号

const IPAddress ip(192, 168, 4, 2); //IP address
const IPAddress subnet(255, 255, 255, 0);

int num=0;

WiFiUDP udp;

void setup() {
  Serial.begin(115200);

  WiFi.softAP(ssid, pass);
  delay(100);
  WiFi.softAPConfig(ip, ip, subnet);

  Serial.print("AP IP address: ");
  IPAddress myIP = WiFi.softAPIP();
 // server.begin();
  Serial.println(myIP);

  Serial.println("Starting UDP");
  udp.begin(localPort);  //udp begin

  Serial.print("SSID: ");
  Serial.println(ssid);

  Serial.print("Local port: ");
  Serial.println(localPort);

  server.begin();

}

void loop() {
  
  if(num%1000000==0){Serial.println("usuge");num=0; } //  Serial.println(udp.read());}
  num++; 
  //Serial.println(udp.parsePacket()); //print
  udp.parsePacket();
  int packet = udp.parsePacket();//udp.parsePacket();
  if (packet) {
    Serial.println("recieved");
    Serial.println(packet);
    Serial.println(udp.read()); //print
  }
//  delay(1);
}
