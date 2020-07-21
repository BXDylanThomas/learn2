package com.dylan.xinyidai05;

import com.dylan.xinyidai05.infrastructure.persitence.mapper.finace.PaymentMapper;
import com.dylan.xinyidai05.infrastructure.persitence.service.finace.PaymentService;
import com.dylan.xinyidai05.interfaces.facade.PaymentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author baoxiang
 * @create 2020-07-06 17:42
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PaymentController.class)
public class WebMvcsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;
    @MockBean
    private PaymentMapper mapper;

    @Test
    public void test() throws Exception {

        given(paymentService.count()).willReturn(100);
        given(mapper.selectCount(any())).willReturn(100);

        mockMvc.perform(get("/payment/get")).andExpect(content().string("100"));
    }
}
 