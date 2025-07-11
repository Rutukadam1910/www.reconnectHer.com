package com.reconnectHer.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoadmapService {

    private final RestTemplate restTemplate;

    public RoadmapService() {
        this.restTemplate = new RestTemplate();
    }

    public String fetchRoadmap(String careerOption) {
        String baseUrl = "https://roadmap.sh/api";
        String roadmapUrl;

        switch (careerOption.toLowerCase()) {
            case "frontend":
                roadmapUrl = baseUrl + "/frontend";
                break;
            case "backend":
                roadmapUrl = baseUrl + "/backend";
                break;
            case "devops":
                roadmapUrl = baseUrl + "/devops";
                break;
            default:
                roadmapUrl = baseUrl + "/frontend"; // Default to frontend if no match
                break;
        }

        return restTemplate.getForObject(roadmapUrl, String.class);
    }
}
