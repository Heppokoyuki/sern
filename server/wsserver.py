from websocket_server import WebsocketServer
import socket
import subprocess



def new_client(client, server):
    server.send_message(client,"connected")

def received_process(client, server, message):
    print('recieved')
    server.send_message(client,"message is " + message)
    print('message is ' + message)
    if message == "v_Up":
        server.send_message(client,"volume up")
        cmd = 'sudo pactl set-sink-volume 0 +5%'
        subprocess.call(cmd.split())
        cmd = 'sudo pactl set-sink-volume 1 +5%'
        subprocess.call(cmd.split())
    elif message == "v_Down":
        server.send_message(client,"volume down")
        cmd = 'sudo pactl set-sink-volume 1 -5%'
        subprocess.call(cmd.split())
        cmd = 'sudo pactl set-sink-volume 0 -5%'
        subprocess.call(cmd.split())
    elif message == "pi_Restart":
        server.send_message(client,"reboot")
        cmd = 'sudo reboot'
        subprocess.call(cmd.split())
    elif message == "pi_Shutdown":
        server.send_message(client,"shutdown")
        cmd = 'sudo shutdown now'
        subprocess.call(cmd.split())
    elif message[0:5] == "v_Set":
        val = message[6:]
        server.send_message(client,"volume set " + val)
        cmd = 'sudo pactl set-sink-volume 1 ' + val
        subprocess.call(cmd.split())
        cmd = 'sudo pactl set-sink-volume 0 ' + val
        subprocess.call(cmd.split())


server = WebsocketServer(9999, host='192.168.1.119')
server.set_fn_new_client(new_client)#if client connected
server.set_fn_message_received(received_process)#if message recieved from client
server.run_forever()
