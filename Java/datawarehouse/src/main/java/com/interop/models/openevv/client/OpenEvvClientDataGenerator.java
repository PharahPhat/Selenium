package com.interop.models.openevv.client;

import com.interop.common.Commons;
import com.interop.common.State;
import com.interop.common.StateAccount;
import com.interop.models.ProviderIdentification;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class OpenEvvClientDataGenerator {
    private OpenEvvClientDataGenerator() {
    }

    public static OpenEvvClient getDefaultOpenEvvClient() {
        return OpenEvvClient.builder().payerInformation(ClientPayerInformation.builder().build())
                .designees(ClientDesignees.builder().build())
                .address(ClientAddress.builder().build())
                .phone(ClientPhone.builder().build()).build();
    }

    public static OpenEvvClient getOpenEvvClientByState(StateAccount stateAccount, int countClientAddress, int countClientPhone, int countClientDesignee) {
        OpenEvvClient openEvvClient = getDefaultOpenEvvClient();
        if (!StateAccount.loadStateAccount().getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString())) {
            switch (stateAccount.getStateEnum()) {
                case VERMONT:
                    openEvvClient.setClientID("P" + RandomStringUtils.randomNumeric(6));
                    break;
                case ARIZONA:
                    if (!StateAccount.loadStateAccount().getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString())) {
                        openEvvClient.setClientMedicaidID(RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomNumeric(8));
                        openEvvClient.setRecipientIDCustom1(openEvvClient.getClientMedicaidID());
                        openEvvClient.setRecipientIDCustom2(openEvvClient.getClientMedicaidID());
                    }
                    break;
                case HAWAII:
                    openEvvClient.setClientMedicaidID(RandomStringUtils.randomNumeric(10));
                    openEvvClient.setClientTimeZone("US/Hawaii");
                    break;
                default:
                    break;
            }
        }
        openEvvClient.setClientAddress(addMultiClientAddress(countClientAddress, openEvvClient.getClientID()));
        openEvvClient.setClientPhone(addMultiClientPhone(countClientPhone, openEvvClient.getClientID()));
        openEvvClient.setClientDesignees(addMultiClientDesignees(countClientDesignee));
        return openEvvClient;
    }

    public static List<ClientContactV1> setClientContactV1( int numberRecords) {
        List<ClientContactV1> clientContacts = new ArrayList<>();
        for (int i = 0; i < numberRecords; i++) {
            clientContacts.add(ClientContactV1.builder().build());
        }
        return clientContacts;
    }

    public static OpenEvvClient getOpenEvvClientByState(StateAccount stateAccount) {
        return getOpenEvvClientByState(stateAccount, 1, 1, 1);
    }

    public static OpenEvvClientV1 getDefaultOpenEvvClientV1() {
            return OpenEvvClientV1.builder()
                    .address(ClientAddress.builder().build())
                    .phone(ClientPhone.builder().build())
                    .clientContact(ClientContactV1.builder().build())
                    .designees(ClientDesignees.builder().build())
                    .payerInformation(ClientPayerInformation.builder().build())
                    .providerIdentification(ProviderIdentification.builder().withState(StateAccount.loadStateAccount()).build())
                    .build();
        }
    public static OpenEvvClientV1 getOpenEvvClientByStateV1 (State state, int count){
            OpenEvvClientV1 openEvvClient = getDefaultOpenEvvClientV1();
            if (!StateAccount.loadStateAccount().getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString())) {
                switch (state) {
                    case VERMONT:
                        openEvvClient.setClientID(RandomStringUtils.randomAlphanumeric(1).toUpperCase() + RandomStringUtils.randomNumeric(6));
                        break;
                    case ARIZONA:
                        if (!StateAccount.loadStateAccount().getAccountType().equalsIgnoreCase(Commons.AccountType.AMP.toString())) {
                            openEvvClient.setClientMedicaidID(RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomNumeric(8));
                            openEvvClient.setRecipientIDCustom1(openEvvClient.getClientMedicaidID());
                            openEvvClient.setRecipientIDCustom2(openEvvClient.getClientMedicaidID());
                        }
                        break;
                    case HAWAII:
                        openEvvClient.setClientMedicaidID(RandomStringUtils.randomNumeric(10));
                        break;
                    default:
                        break;
                }
            }
            openEvvClient.setClientContact(setClientContactV1(count));
            openEvvClient.getClientAddress().forEach(x -> x.setClientID(openEvvClient.getClientID()));
            openEvvClient.getClientPhone().forEach(x -> x.setClientID(openEvvClient.getClientID()));
            openEvvClient.getClientContact().forEach(x -> x.setClientID(openEvvClient.getClientID()));
            return openEvvClient;
        }

    public static OpenEvvClientV1 getOpenEvvClientByStateV1 (State state){
        return getOpenEvvClientByStateV1(state, 2);
    }

    private static List<ClientAddress> addMultiClientAddress(int count, String clientID) {
        List<ClientAddress> clientAddressList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            clientAddressList.add(ClientAddress.builder().clientID(clientID).build());
        }
        return clientAddressList;
    }

    private static List<ClientPhone> addMultiClientPhone(int count, String clientID) {
        List<ClientPhone> clientPhones = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            clientPhones.add(ClientPhone.builder().clientID(clientID).build());
        }
        return clientPhones;
    }

    public static List<ClientDesignees> addMultiClientDesignees(int count) {
        List<ClientDesignees> clientDesignees = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            clientDesignees.add(ClientDesignees.builder().build());
        }
        return clientDesignees;
    }
}
