package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    private TcpConnection tcp;
    private Connection connection;

    public Disconnected(TcpConnection tcp) {
        this.tcp = tcp;
        this.connection = tcp.getState();
    }
    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        System.out.println("connected");
        if (!connection.equals(null)) {
            this.tcp.getState().connect();
        }
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Already disconnected!");
    }

    @Override
    public void write(String data) {
        System.out.println("Error! Not connected!");
    }
}
// END
