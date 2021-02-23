package com.yesido.rpc.service.im.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yesido.rpc.consts.RPCConst;
import com.yesido.rpc.proto.RPCResult;
import com.yesido.rpc.service.im.server.hystrix.RPCServerServiceHystrix;

/**
 * imserver RPC服务
 * 
 * @author yesido
 * @date 2019年10月16日 下午6:01:16
 */
@FeignClient(value = RPCConst.SERVICE_IM_SERVER, fallbackFactory = RPCServerServiceHystrix.class)
public interface RPCServerService {

    /**
     * 设置服务器停止
     */
    @RequestMapping(value = RPCConst.URI_IM_SERVER + "/server/status/stop", method = RequestMethod.POST)
    RPCResult<Boolean> stopSrever();

    /**
     * 设置服务启动
     */
    @RequestMapping(value = RPCConst.URI_IM_SERVER + "/server/status/start", method = RequestMethod.POST)
    RPCResult<Boolean> startSrever();
}
