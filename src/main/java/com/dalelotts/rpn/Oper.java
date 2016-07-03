package com.dalelotts.rpn;

import java.math.BigDecimal;

/**
 * Created by paddy on 03/07/16.
 */
public interface Oper {
    BigDecimal compute(BigDecimal a, BigDecimal b);
}
