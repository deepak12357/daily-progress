class Solution {

    LinkedList<String> result = new LinkedList<>();

    void dfs(String airport,
             Map<String, PriorityQueue<String>> graph) {

        PriorityQueue<String> pq = graph.get(airport);

        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), graph);
        }

        result.addFirst(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        dfs("JFK", graph);

        return result;
    }
}