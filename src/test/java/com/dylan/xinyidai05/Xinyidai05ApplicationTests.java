package com.dylan.xinyidai05;

import com.dylan.xinyidai05.infrastructure.persitence.service.finace.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.BDDMockito.given;


@SpringBootTest
class Xinyidai05ApplicationTests {

    @MockBean
    private PaymentService paymentService;

    @Test
    @Rollback(false)
    void contextLoads() {
        int a = 10;
        given(paymentService.count()).willReturn(a);
        int count = paymentService.count();
        assertEquals(a, count);
    }
}
