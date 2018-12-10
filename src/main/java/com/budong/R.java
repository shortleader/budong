package com.budong;

import java.util.regex.Pattern;

public class R {
    public static String hostAddress = "localhost:8090";

    public static String requestToHost(String mappingOrRestResource) {
        return requestToHost("http", mappingOrRestResource);
    }

    public static String requestToHost(String suffixOrScheme, String mappingOrRestResource) {
        if (!Pattern.matches("[a-zA-z]+://(\\n|$)", suffixOrScheme)) {
            suffixOrScheme = suffixOrScheme + "://";
        }
        return suffixOrScheme + R.hostAddress + mappingOrRestResource;
    }

    public static class path {
        public static final String INDEX = "index";
        public static final String chat_home = "chatHome";
        public static final String graph_year = "test/graph";
        public static final String graph_year_districtCode_avg = "test/graphYearDistrictCode";
        public static final String graph_year_month = "test/graphYearMonth";
        public static final String login_home = "member/memberLogin";
        public static final String news_contents = "khw/newsContent";
        public static final String news_title = "khw/news";
    }

    public static class mapping {
        public static final String INDEX = "/";
        public static final String chat_home = "/chatHome.do";
        public static final String check_id = "/checkId.do";
        public static final String graph_year_avg = "/graph/year";
        public static final String graph_year_districtCode_avg = "/graph/yearDistrictCode";
        public static final String graph_year_month_avg = "/graph/yearMonth";
        public static final String insert_member = "/insertMember.do";
        public static final String login = "/login.do";
        public static final String login_home = "/loginHome.do";
        public static final String logout = "/logout.do";
        public static final String move_chat_room = "/moveChatRoom.do";
        public static final String news_contents = "/content.news";
        public static final String news_title = "/title.news";
        public static final String request_web_socket = "chatting";
    }

    public static class rest {
        public static final String apartment_deal_info_avg_by_year = "/rest/apartmentDealPriceAvg/year";
        public static final String apartment_deal_info_avg_by_year_districtCode = "/rest/apartmentDealPriceAvg/yearDistrictCode";
        public static final String apartment_deal_info_avg_by_year_month = "/rest/apartmentDealPriceAvg/month";
    }
}
