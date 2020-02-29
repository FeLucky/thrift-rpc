package service.impl;

import com.sdt.thrift.rpc.HelloService;
import org.apache.thrift.TException;

/**
 * Created by Fe on 2019/11/26.
 */
public class HelloServiceImpl implements HelloService.Iface{
    @Override
    public void sayHello() throws TException {
        System.out.println("Hello thrift");
    }
}
