#pip3 install websocket-server
#wscat -c ws:192.169.1.99:9999
from websocket_server import WebsocketServer

def new_client(client, server):
    server.send_message(client,"connected")

def received_process(client, server, message):
    print('recieved')
    server.send_message(client,"message is " + message)
    if message == "volume_up":
        server.send_message(client,"volume up")
    elif message == "volume_down":
        server.send_message(client,"volume down")

server = WebsocketServer(9999, host='192.168.100.118')
server.set_fn_new_client(new_client)#if client connected
server.set_fn_message_received(received_process)#if message recieved from client
server.run_forever()
