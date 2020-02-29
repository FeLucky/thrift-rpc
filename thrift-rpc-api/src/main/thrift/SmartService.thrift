namespace java org.wtx.thrift.api

include "SmartTypes.thrift"

service SmartService{

SmartTypes.User getUserById(i32 uid)

}
