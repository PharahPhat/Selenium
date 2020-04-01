package com.interop.common.constants.utils;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.sandata.core.Wrapper;
import com.sandata.core.config.TestConfiguration;
import com.sandata.core.config.TestContext;
import org.testng.Assert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class RabbitMQUtils {
    private static final Wrapper baseObj = new Wrapper();
    private static final ConnectionFactory FACTORY = new ConnectionFactory();

    private RabbitMQUtils() {
    }

    /**
     * NOTE: MUST PURGE QUEUE BEFORE PERFORM METHOD UPLOAD AND VERIFY ON QUEUE
     *
     * @param queueName
     * @param expectedMessage
     * @throws IOException
     * @throws InterruptedException
     */
    public static void verifyIsExpectedMessPushedToQueue(String queueName, String expectedMessage) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        List<String> listMessages = getMessagesFromQueue(queueName);
        Assert.assertTrue(listMessages.contains(expectedMessage), String.format("No message contains %s", expectedMessage));
    }

    public static int getTotalMessageInQueue(String queueName) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        int totalMessage = countMessageOnQueue(queueName);
        int timeAttempt = 20;
        baseObj.info("Starting to get message on RabbitMQ");
        baseObj.info(" Waiting for the message");
        while (totalMessage == 0 && timeAttempt > 0) {
            totalMessage = countMessageOnQueue(queueName);
            timeAttempt--;
            baseObj.sleep(15000);
        }
        return totalMessage;
    }

    public static int countMessageOnQueue(String queueName) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        loadDefaultFactory();
        try (Connection conn = FACTORY.newConnection();
             Channel channel = conn.createChannel()) {
            AMQP.Queue.DeclareOk queueStatus = channel.queueDeclarePassive(queueName);
            return queueStatus.getMessageCount();
        } catch (IOException e) {
            baseObj.error("countMessageOnQueue: Cannot create connection to channel", e);
        }
        return 0;
    }

    public static void purseMessage(String queueName) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        loadDefaultFactory();
        try (Connection conn = FACTORY.newConnection();
             Channel channel = conn.createChannel()) {
            channel.queuePurge(queueName);
        } catch (IOException e) {
            baseObj.error("purseMessage: Cannot create connection to channel", e);
        }
    }

    public static String getFirstMessageInQueue(String queueName) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        loadDefaultFactory();
        try (Connection conn = FACTORY.newConnection();
             Channel channel = conn.createChannel()) {
            return new String(channel.basicGet(queueName, true).getBody());
        } catch (IOException e) {
            baseObj.error("getFirstMessageInQueue: Cannot create connection to channel", e);
        }
        return null;
    }

    public static List<String> getMessagesFromQueue(String queueName) throws TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        int totalMessage = getTotalMessageInQueue(queueName);
        List<String> listMessage = new ArrayList<>();
        for (int i = 1; i <= totalMessage; i++) {
            String body = getFirstMessageInQueue(queueName);
            baseObj.info("Message on Rabbit MQ : " + body);
            listMessage.add(body);
        }
        return listMessage;
    }

    private static void loadDefaultFactory() throws URISyntaxException, NoSuchAlgorithmException, KeyManagementException {
        TestConfiguration config = TestContext.get();
        FACTORY.setUri(config.getEnvironment("URI_RabbitMQ"));
    }

    public static <T> T parseSpecificMessageOnQueueToModel(List<String> listMessages, Class<T> clazz, String expectedContain) {
        for (String message : listMessages) {
            if (message.contains(expectedContain)) {
                return new Gson().fromJson(message, clazz);
            }
        }
        return null;
    }
}
