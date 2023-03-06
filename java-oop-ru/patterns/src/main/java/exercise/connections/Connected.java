package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{
    private TcpConnection tcp;
    private Connection connection;

    public Connected(TcpConnection tcp) {
        this.tcp = tcp;
        this.connection = tcp.getState();
    }
    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Already connected!");
        //this.tcp.setState(new Connected(this.tcp));
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");
        this.tcp.setState(new Disconnected(tcp));
    }

    @Override
    public void write(String data) {
        System.out.println("write data");
    }
}
// END
