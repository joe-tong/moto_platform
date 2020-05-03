package com.tulin.platform_system.controller;

import com.tulin.api.order.OrderService;
import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_model.vo.response.UnHandledOrderDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "摩的司机")
@RequestMapping("/driver/")
@RestController
@CrossOrigin
public class DriverController {

    @Resource
    private OrderService orderService;

    @ApiOperation("订单列表")
    @GetMapping("/order/list")
    public ServerResponse<List<UnHandledOrderDTO>> getOrderList(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize) {

        return orderService.getAllUnhandledOrder(pageNum, pageSize);
    }
}
