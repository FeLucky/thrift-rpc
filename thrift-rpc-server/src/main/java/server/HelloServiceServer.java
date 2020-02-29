package server;

import com.sdt.thrift.rpc.HelloService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import service.impl.HelloServiceImpl;
/**
 * Created by Fe on 2019/11/26.
 */
public class HelloServiceServer implements Runnable {
    @Override
    public void run() {
        TServerSocket serverTransport = null;
        try {
            serverTransport = new TServerSocket(7911);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverTransport);
        TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
        TProcessor processor = new HelloService.Processor<>(new HelloServiceImpl());
        targs.protocolFactory(proFactory);
        targs.processor(processor);
        TServer server = new TThreadPoolServer(targs);
        System.out.println("Start HelloServiceServer");
        server.serve();

    }
}
