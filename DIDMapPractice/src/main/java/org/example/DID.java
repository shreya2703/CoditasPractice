package org.example;

import java.util.List;
import java.util.Map;

public class DID {
    private String seasonName;
    private List<String> brandPartners;

    public DID() {
    }

    private Map<Participants, String> participants;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public List<String> getBrandPartners() {
        return brandPartners;
    }

    public void setBrandPartners(List<String> brandPartners) {
        this.brandPartners = brandPartners;
    }

    public Map<Participants, String> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<Participants, String> participants) {
        this.participants = participants;
    }

    public void display() {
        System.out.println("Did Season name " + getSeasonName());
        List<String> l = getBrandPartners();
        System.out.println("Brand Partners");
        for (String v : l) {
            System.out.println(v);
        }

        Map<Participants, String> m = getParticipants();
        for (Map.Entry<Participants, String> p1 : m.entrySet()) {
            System.out.println(p1.getKey() + " " + p1.getValue());
        }


//    @Override
//    public String toString() {
//        return "DID{" +
//                "seasonName='" + seasonName + '\'' +
//                ", brandPartners=" + brandPartners +
//                ", participants=" + participants +
//                '}';
//    }
    }
}

