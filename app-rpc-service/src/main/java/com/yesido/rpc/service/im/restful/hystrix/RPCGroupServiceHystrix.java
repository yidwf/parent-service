package com.yesido.rpc.service.im.restful.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yesido.rpc.dto.GroupDetailDto;
import com.yesido.rpc.proto.RPCResult;
import com.yesido.rpc.service.im.restful.RPCGroupService;

import feign.hystrix.FallbackFactory;

/**
 * RPCGroupService服务熔断降级
 * 
 * @author yesido
 * @date 2019年9月11日 下午2:53:06
 */
@Service
public class RPCGroupServiceHystrix implements FallbackFactory<RPCGroupService> {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${feign.hystrix.error.printStackTrace:false}")
    private boolean printStackTrace;

    @Override
    public RPCGroupService create(Throwable cause) {
        if (cause != null && printStackTrace) {
            LOGGER.error("RPCGroupService请求服务降级：", cause);
        } else if (cause != null && cause.getMessage() != null) {
            LOGGER.error("RPCGroupService请求服务降级：{}", cause.getMessage());
        }
        return service;
    }

    protected RPCGroupService service = new RPCGroupService() {
        @Override
        public RPCResult<GroupDetailDto> getDetail(String groupId) {
            return RPCResult.fallback();
        }
    };

}
