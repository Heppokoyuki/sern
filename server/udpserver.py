from socket import *
import sys

import subprocess

#ipval = [(s.connect(('8.8.8.8',80)),s.getsockname()[0],s.close()) for s in [socket(AF_INET,SOCK_DGRAM)]][0][1]

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
        s.sendto("ipval", address)

s.close()
sys.exit()

