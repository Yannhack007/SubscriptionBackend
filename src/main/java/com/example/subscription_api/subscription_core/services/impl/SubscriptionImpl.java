package com.example.subscription_api.subscription_core.services.impl;

import com.example.subscription_api.common.DTO.Transaction.Mobile.PaymentMobileRequest;
import com.example.subscription_api.common.DTO.subscriptions.SubscriptionUpdateRequest;
import com.example.subscription_api.common.exceptions.ResourceNotFoundException;
import com.example.subscription_api.common.helpers.TimestampUtil;
import com.example.subscription_api.subscription_core.models.Plan;
import com.example.subscription_api.subscription_core.models.Subscription;
import com.example.subscription_api.subscription_core.models.TransactionMobile;
import com.example.subscription_api.subscription_core.repositories.PlanRepository;
import com.example.subscription_api.subscription_core.repositories.SubscriptionRepository;
import com.example.subscription_api.subscription_core.services.SubscriptionInterface;
import com.example.subscription_api.subscription_core.services.TransactionMobileInterface;
import com.example.subscription_api.subscription_core.type.Status;
import com.example.subscription_api.subscription_payment.InitMobilePaymentInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SubscriptionImpl implements SubscriptionInterface {
    private SubscriptionRepository subscriptionRepository;
    private TransactionMobileInterface mobileInterface;
    private PlanRepository planRepository;
    private InitMobilePaymentInterface paymentInterface;

    public Subscription createMobile(PaymentMobileRequest request, UUID planId){
        TransactionMobile transactionMobile = mobileInterface.create(request);
        Optional<Plan> optionalPlan = planRepository.findById(planId);
        if (optionalPlan.isEmpty()) {
            throw new ResourceNotFoundException("Plan with ID: " + planId+ " does not exist");
        }

        Plan existingPlan = optionalPlan.get();

        Subscription subscription = new Subscription();
        subscription.setSubscription_id(UUID.randomUUID());
        subscription.setClient_id(request.getPayer_reference());
        subscription.setPlanId(planId);
        subscription.setStatus(Status.PENDING.toString());
        subscription.setStart_date(LocalDateTime.now());
        subscription.setEnd_date(LocalDateTime.now().plusDays(existingPlan.getDuration()));
        subscription.setTransactionId(transactionMobile.getTransaction_id());
        TimestampUtil.markCreated(subscription);
        TimestampUtil.markUpdated(subscription);
        request.setTransaction_reference(transactionMobile.getTransaction_id());
        paymentInterface.InitPayment(request).block();

        return subscriptionRepository.save(subscription);
    }
    public List<Subscription> getList(UUID serviceId){
        List<Plan> plans = planRepository.findByServiceId(serviceId);
        if (plans.isEmpty()){
            throw new ResourceNotFoundException("This service don't have plan");
        }

        List<Subscription> subscriptions = new ArrayList<>();
        for (Plan plan : plans) {
            subscriptions.addAll(subscriptionRepository.findByPlanId(plan.getPlan_id()));
        }
        return subscriptions;
    }
    public Subscription update(SubscriptionUpdateRequest request){
        Subscription subscription = subscriptionRepository.findByTransactionId(request.getTransactionId());

        if (subscription==null){
            throw new ResourceNotFoundException("Subscription with Transaction ID: " + request.getTransactionId()+ " does not exist");
        }

        subscription.setStatus(request.getStatus());
        TimestampUtil.markUpdated(subscription);
        return subscriptionRepository.save(subscription);
    }
}
