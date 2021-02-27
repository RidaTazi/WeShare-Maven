package Config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api-auth")
public class AppConfigAuth extends Application {
    public AppConfigAuth() {
        System.out.println("with auth");
    }
}
