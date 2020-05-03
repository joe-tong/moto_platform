package com.tulin.api.order;

import com.tulin.common.base.controller.ServerResponse;
import com.tulin.platform_model.vo.response.UnHandledOrderDTO;

import java.util.List;

public interface OrderService {

    ServerResponse<List<UnHandledOrderDTO>> getAllUnhandledOrder(long pageNum, long pageSiz);
}
