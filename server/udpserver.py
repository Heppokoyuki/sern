from socket import *
import sys

import subprocess


HOST = '' 
PORT = 9887

s =socket(AF_INET,SOCK_DGRAM)
s.bind((HOST, PORT))
 

while True:
    msg, address = s.recvfrom(8192)
    if msg == "FindTubeBox":
        cmd = 'sudo systemctl start test2'
        subprocess.call(cmd.split())
        cmd = 'sudo hciconfig hci0 up'
        subprocess.call(cmd.split())
        cmd = 'sudo hciconfig hci0 piscan'
        subprocess.call(cmd.split())
        s.sendto("hello", address)

s.close()
sys.exit()

