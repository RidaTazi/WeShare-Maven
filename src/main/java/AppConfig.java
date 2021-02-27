import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;


@ApplicationPath("/api")
public class AppConfig extends Application {
    public AppConfig(@Context HttpServletRequest request) {
        System.out.println("no auth");
    }
}
