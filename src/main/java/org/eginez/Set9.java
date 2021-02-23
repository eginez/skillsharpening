package org.eginez;

import java.util.*;
import java.util.stream.Collectors;

public class Set9 {
    public static class RequestInfo {
        long timestamp;

        public RequestInfo() {
            this.timestamp = System.currentTimeMillis();
        }

        public String toString() {
            return String.format("%d", timestamp);
        }

    }
    public static class RateLimiter {
        private int limit;
        private Map<String, Stack<RequestInfo>> requests;

        public RateLimiter(int limit) {
            this.limit = limit;
            requests = new HashMap<>();

        }

        public boolean addAndCheckCall(String clientId) {
            if (!requests.containsKey(clientId)) {
                Stack<RequestInfo> rs = new Stack<>();
                rs.push(new RequestInfo());
                requests.put(clientId, rs);
                return true;
            }

            final long now = System.currentTimeMillis();
            long count = requests.get(clientId).stream()
                    .filter(r -> now - r.timestamp <= 1000)
                    .count();

            clean(clientId);
            if (count + 1 <= limit) {
                requests.get(clientId).push(new RequestInfo());
                return true;
            }
            return false;
        }

        private void clean(String clientId) {
            assert requests.containsKey(clientId);

            List<RequestInfo> toRemove = requests.get(clientId).stream()
                    .filter(r -> System.currentTimeMillis() - r.timestamp > 1000)
                    .collect(Collectors.toList());
            requests.get(clientId).removeAll(toRemove);
        }
    }
}
