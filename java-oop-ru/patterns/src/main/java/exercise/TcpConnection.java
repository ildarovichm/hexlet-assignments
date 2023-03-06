package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.List;
import java.util.ArrayList;

// BEGIN
public class TcpConnection implements Connection {
    private String ip;
    private int port;

    private Connection connection;

    public TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public Connection getState() {
        return connection;
    }

    public void setState(Connection connection) {
        this.connection = connection;
    }
    @Override
    public String getCurrentState() {
//        try {
//            Connection c = this.connection;
//            String s = c.getCurrentState();
//            return s;
//        } catch (NullPointerException ex) {
//            throw new NullPointerException();
//        }
//        Connection c = this.connection;
        String s = this.connection.getCurrentState();
        return s;
    }

    @Override
    public void connect() {
        if (!this.getState().equals(null)) {
            this.setState(new Connected(this));
        }
        this.getState().connect();

    }

    @Override
    public void disconnect() {
        //System.out.println("connected");
//        if (!connection.equals(null)) {
//            this.getState().disconnect();
//        }
        this.getState().disconnect();
//        if (!connection.equals(null)) {
//            if (connection.equals(this.getState())) {
//                System.out.println(connection);
//                System.out.println(this.getState());
//                this.setState(new Disconnected(this));
//            }
//        }
//        System.out.println(this.getCurrentState());
    }

    @Override
    public void write(String data) {
        this.getState().write(data);
    }
}
// END
