import server.HelloServiceServer;
import server.SmartServiceServer;

/**
 * Created by Fe on 2019/11/26.
 */
public class ServiceServerApplication {
    public static void main(String[] args){
        new Thread(new HelloServiceServer()).start();
        new Thread(new SmartServiceServer()).start();
    }
}
