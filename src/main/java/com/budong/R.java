package com.budong;

import java.util.regex.Pattern;

public class R {
    public static String hostAddress = "localhost:8090";

    public static String requestToHost(String mappingOrRestResource) {
        return requestToHostWithScheme("http", mappingOrRestResource);
    }

    public static String requestToHost(String controllerResource, String mappingResource) {
        return requestToHostWithScheme("http", controllerResource, mappingResource);
    }

    public static String requestToHostWithScheme(String scheme, String mappingOrRestResource) {
        if (!Pattern.matches("[a-zA-Z가-힣]+://$", scheme)) {
            scheme = scheme + "://";
        }

        if(!Pattern.matches("^/[a-zA-Z가-힣]+/$",mappingOrRestResource)) {
            mappingOrRestResource = "/" + mappingOrRestResource;
            mappingOrRestResource = mappingOrRestResource.replaceAll("/+","/");
        }
        return scheme + R.hostAddress + mappingOrRestResource;
    }

    public static String requestToHostWithScheme(String scheme, String controllerResource, String mappingResource) {
        return requestToHostWithScheme(scheme, controllerResource + mappingResource);
    }

    public static class path {
        public static final String INDEX = "index";
        public static final String chat_home = "chatHome";
        public static final String login_home = "member/memberLogin";

        public static final String graph_year = "test/graph";
        public static final String graph_year_month = "test/graphYearMonth";
        public static final String graph_year_districtCode_avg = "test/graphYearDistrictCode";

        public static final String khw_main = "khw/main";
        public static final String news_title = "khw/news";
        public static final String news_contents = "khw/newsContent";

        public static final String real_estate = "dealInfo/RealEstate";
        public static final String apartment_deal_info = "dealInfo/APTDealList";
    }

    public static class controller {
        public static final String chat = "chat";
        public static final String main = "/";
        public static final String news = "news";
        public static final String real_estate_deal_info = "dealInfo";
    }

    public static class mapping {
        public static final String INDEX = "/";
        public static final String real_estate = "/realEstate.do";
        public static final String apartment_deal_info = "/apt_dealInfo.do";

        public static final String check_id = "/checkId.do";
        public static final String chat_home = "/chatHome.do";
        public static final String move_chat_room = "/moveChatRoom.do";
        public static final String request_web_socket = "/chatting";

        public static final String graph_year_avg = "/graph/year";
        public static final String graph_year_month_avg = "/graph/yearMonth";
        public static final String graph_year_districtCode_avg = "/graph/yearDistrictCode";

        public static final String login = "/login.do";
        public static final String logout = "/logout.do";
        public static final String login_home = "/loginHome.do";
        public static final String insert_member = "/insertMember.do";

        public static final String khw_main = "/khw";
        public static final String news_title = "/title.news";
        public static final String news_contents = "/content.news";
    }

    public static class rest {
        public static final String apartment_deal_info_avg_by_year = "/rest/apartmentDealPriceAvg/year";
        public static final String apartment_deal_info_avg_by_year_districtCode = "/rest/apartmentDealPriceAvg/yearDistrictCode";
        public static final String apartment_deal_info_avg_by_year_month = "/rest/apartmentDealPriceAvg/month";
    }
}
