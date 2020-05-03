package com.tulin.platform_system.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tulin.api.order.OrderService;
import com.tulin.common.base.controller.ServerResponse;
import com.tulin.common.enums.OrderStateEnum;
import com.tulin.common.utlis.DateUtil;
import com.tulin.common.utlis.validator.Validator;
import com.tulin.platform_model.dao.OrderDao;
import com.tulin.platform_model.model.Order;
import com.tulin.platform_model.vo.response.UnHandledOrderDTO;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class OrderServiceImpl extends Validator implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public ServerResponse<List<UnHandledOrderDTO>> getAllUnhandledOrder(long pageNum, long pageSize) {
        notNull("pageNum", pageNum);
        notNull("pageSize", pageSize);

        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state", OrderStateEnum.UNHANDLED.getState());

        IPage<Order> orderIPage = orderDao.selectPage(new Page<Order>(pageNum, pageSize), queryWrapper);
        if (0 == orderIPage.getTotal()) {
            return ServerResponse.createBySuccess();
        }
        List<Order> orders = orderIPage.getRecords();

        List<UnHandledOrderDTO> orderDTOS = new ArrayList<>();
        for (Order order : orders) {
            UnHandledOrderDTO orderDTO = new UnHandledOrderDTO();
            orderDTO.setPublishTime(DateUtil.formatDateTime(order.getCreateTime()));
            orderDTO.setTel(order.getTel());
            orderDTO.setAddress(order.getAddress());
            orderDTO.setLatitude(order.getLatitude());
            orderDTO.setLongitude(order.getLongitude());
            orderDTO.setDistance(order.getMile());
            orderDTOS.add(orderDTO);
        }

        return ServerResponse.createBySuccess(orderDTOS, orderIPage.getTotal());
    }
}
