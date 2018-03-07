$(function() {
    const socket = new WebSocket('ws://localhost:8000');
    socket.addEventListener('open', function(e) {
        socket.send('Hello, Server');
    });
    $('#slider').slider({
        change: function(event, ui) {
            alert('ui.value');
        }
    });
    $("#rebootbtn").click(function(e) {
        var res = confirm("再起動しますか?");
        if (res == true) {
            alert('再起動実行');
        } else {
            alert('再起動不実行');
        }
    });
});