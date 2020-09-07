package design.singleton;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Connection {

    private static Connection con = null;

    public static Connection getConnectionObject() {
        if (con == null) {
            synchronized (Connection.class) {
                if (con == null)
                    con = new Connection();
                return new Connection();
            }
        }
        return con;
    }
}
