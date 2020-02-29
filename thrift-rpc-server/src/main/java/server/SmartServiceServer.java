package server;

import com.sdt.thrift.rpc.SmartService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import service.impl.SmartServiceImpl;

/**
 * Created by Fe on 2019/11/26.
 */
public class SmartServiceServer implements Runnable {
    @Override
    public void run() {
        TServerSocket serverTransport = null;
        try {
            serverTransport = new TServerSocket(7912);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverTransport);
        TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
        TProcessor processor = new SmartService.Processor<>(new SmartServiceImpl());
        targs.protocolFactory(proFactory);
        targs.processor(processor);
        TServer server = new TThreadPoolServer(targs);
        System.out.println("Start SmartServiceServer");
        server.serve();
    }
}
