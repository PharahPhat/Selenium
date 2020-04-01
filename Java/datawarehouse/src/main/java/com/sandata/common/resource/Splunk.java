package com.sandata.common.resource;

public class Splunk {
    private Splunk(){}
    public final static String LOGIN = "/en-GB/account/login";
    public final static String SEARCH = "/en-GB/splunkd/__raw/servicesNS/splunk/search/search/jobs";
    public final static String SUMMARY = "/en-GB/splunkd/__raw/servicesNS/splunk/search/search/jobs/%s/summary?output_mode=json";
}
