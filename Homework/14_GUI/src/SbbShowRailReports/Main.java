package SbbShowRailReports;

import Service.SbbApiService.RailTrafficInformation;
import Service.SbbApiService.SbbApiService;

public class Main {
    public static void main(String[] args) {
        SbbApiService sbbApi = new SbbApiService();

        RailTrafficInformation rti = sbbApi.searchRailTrafficInformation();
    }
}
