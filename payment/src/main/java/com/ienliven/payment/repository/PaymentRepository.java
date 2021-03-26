package com.ienliven.payment.repository;

import com.ienliven.payment.data.PaymentDetails;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<PaymentDetails> {
}
