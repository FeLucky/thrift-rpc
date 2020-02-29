import com.sdt.thrift.rpc.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Fe on 2019/11/26.
 */
public class HelloServiceClient {
    public static void main(String [] agrs){
        try {
            TTransport transport = new TSocket("localhost",7911);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client client = new HelloService.Client(protocol);
            client.sayHello();
            transport.close();
        }catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }



    }
}
