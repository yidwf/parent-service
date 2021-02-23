package com.yesido.rpc.service.im.restful;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yesido.rpc.consts.RPCConst;
import com.yesido.rpc.dto.GroupDetailDto;
import com.yesido.rpc.proto.RPCResult;
import com.yesido.rpc.service.im.restful.hystrix.RPCGroupServiceHystrix;

/**
 * RPC群组服务
 * 
 * @author yesido
 * @date 2019年9月11日 下午2:18:00
 */
@FeignClient(value = RPCConst.SERVICE_IM_RESTFUL, fallbackFactory = RPCGroupServiceHystrix.class)
public interface RPCGroupService {

    @RequestMapping(value = RPCConst.URI_IM_RESTFUL + "/group/detail", method = RequestMethod.POST)
    RPCResult<GroupDetailDto> getDetail(@RequestParam("groupId") String groupId);
}
