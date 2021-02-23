package com.yesido.rpc.service.im.server.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yesido.rpc.proto.RPCResult;
import com.yesido.rpc.service.im.server.RPCServerService;

import feign.hystrix.FallbackFactory;

/**
 * RPCServerService服务熔断降级
 * 
 * @author yesido
 * @date 2019年10月16日 下午6:03:10
 */
@Service
public class RPCServerServiceHystrix implements FallbackFactory<RPCServerService> {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${feign.hystrix.error.printStackTrace:false}")
    private boolean printStackTrace;

    @Override
    public RPCServerService create(Throwable cause) {
        if (cause != null && printStackTrace) {
            LOGGER.error("RPCServerService请求服务降级：", cause);
        } else if (cause != null && cause.getMessage() != null) {
            LOGGER.error("RPCServerService请求服务降级：{}", cause.getMessage());
        }
        return service;
    }

    protected RPCServerService service = new RPCServerService() {
        @Override
        public RPCResult<Boolean> stopSrever() {
            return RPCResult.fallback();
        }

        @Override
        public RPCResult<Boolean> startSrever() {
            return RPCResult.fallback();
        }
    };
}
