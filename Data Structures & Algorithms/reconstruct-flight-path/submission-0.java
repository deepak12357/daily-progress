class Solution {

    List<String> result = new ArrayList<>();

    public void dfs(Map<String, ArrayList<String>> graph,
                    List<String> temp,
                    String node,
                    int totalTickets) {

        if (!result.isEmpty()) {
            return; // itinerary already found
        }
        if (temp.size() == totalTickets + 1) {
            result = new ArrayList<>(temp);
            return;
        }
        ArrayList<String> neighs = graph.get(node);
        if (neighs == null) {
            return;
        }
        for (int i = 0; i < neighs.size(); i++) {
            String neigh = neighs.get(i);
            if (neigh.equals("*")) {
                continue;
            }
            neighs.set(i, "*");
            temp.add(neigh);
            dfs(graph, temp, neigh, totalTickets);
            temp.remove(temp.size() - 1);
            neighs.set(i, neigh);

            if (!result.isEmpty()) {
                return;
            }
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, ArrayList<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new ArrayList<>())
                 .add(ticket.get(1));
        }
        for (List<String> list : graph.values()) {
            Collections.sort(list);
        }
        List<String> temp = new ArrayList<>();
        temp.add("JFK");
        dfs(graph, temp, "JFK", tickets.size());
        return result;
    }
}