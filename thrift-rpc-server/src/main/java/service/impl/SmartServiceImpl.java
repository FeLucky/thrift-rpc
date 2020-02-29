package service.impl;

import com.sdt.thrift.rpc.SmartService;
import com.sdt.thrift.rpc.struct.User;
import org.apache.thrift.TException;

/**
 * Created by Fe on 2019/11/26.
 */
public class SmartServiceImpl implements SmartService.Iface{
    @Override
    public User getUserById(int uid) throws TException {
        User user = new User();
        user.setId(1);
        user.setUsername("ZS");
        user.setPassword("Aa123456");
        user.setNickname("ls");
        user.setCreateTime("20191126");
        System.out.println("Hello "+user.getUsername());
        return user;
    }
}
