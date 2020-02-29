import com.sdt.thrift.rpc.SmartService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by Fe on 2019/11/26.
 */
public class SmartServiceClient {
    public static void main(String [] agrs) {
        try {
            TTransport transport = new TSocket("localhost",7912);
            transport.open();
            TProtocol protocol = new TBinaryProtocol(transport);
            SmartService.Client client = new SmartService.Client(protocol);
            System.out.print(client.getUserById(1));
            transport.close();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}
