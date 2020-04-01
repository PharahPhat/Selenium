package com.sandata.entity.exportDWH.ExportConfigurationV1;

public class MessageQueueInformation {
    public String queueName;
    public String exchangeName;
    public String routingKey;
    public String requestTimeout;
    public String maxPendingCycle;

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public String getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(String requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public String getMaxPendingCycle() {
        return maxPendingCycle;
    }

    public void setMaxPendingCycle(String maxPendingCycle) {
        this.maxPendingCycle = maxPendingCycle;
    }
}
