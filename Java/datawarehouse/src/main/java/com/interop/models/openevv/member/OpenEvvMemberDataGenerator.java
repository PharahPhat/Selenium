package com.interop.models.openevv.member;

import com.interop.common.StateAccount;
import org.apache.commons.lang.RandomStringUtils;

public class OpenEvvMemberDataGenerator {
    private OpenEvvMemberDataGenerator() {
    }

    public static OpenEvvMember getOpenEVVMemberByState(StateAccount stateAccount, int countAddress, int countDesignee, int countContact, int countPhone) {
        String id;
        String clientCounty = "";
        switch (stateAccount.getStateEnum()) {
            case HAWAII:
                id = RandomStringUtils.randomNumeric(10);
                clientCounty = "01 Oahu";
                break;
            case ARIZONA:
                id = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomNumeric(8);
                break;
            default:
                id = RandomStringUtils.randomNumeric(10);
                break;
        }
        OpenEvvMember openEvvMember = OpenEvvMember.builder()
                .addClientId(id)
                .clientCustomId(id)
                .clientOtherId(id)
                .addMultiAddress(countAddress)
                .addMultiDesign(countDesignee)
                .addMultiContact(countContact)
                .addMultiPhone(countPhone)
                .build();
        String finalClientCounty = clientCounty;
        openEvvMember.getClientAddress().forEach(x -> x.setClientCounty(finalClientCounty));
        openEvvMember.getClientDesignee().forEach(x -> x.setClientId(id));

        return openEvvMember;
    }

    public static OpenEvvMember getOpenEVVMemberByState(StateAccount stateAccount) {
        return getOpenEVVMemberByState(stateAccount, 1, 1, 1, 1);
    }
}
