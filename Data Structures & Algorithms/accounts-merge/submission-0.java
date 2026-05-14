class Solution {
    int[] parent;
    int[] rank;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];
        rank = new int[n];

        // init DSU
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        Map<String, Integer> emailToIndex = new HashMap<>();

        // Step 1: Union accounts by email
        for (int i = 0; i < n; i++) {
            List<String> acc = accounts.get(i);

            for (int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);

                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    union(i, emailToIndex.get(email));
                }
            }
        }

        // Step 2: Group emails by parent
        Map<Integer, TreeSet<String>> map = new HashMap<>();

        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int parentIndex = find(entry.getValue());

            map.putIfAbsent(parentIndex, new TreeSet<>());
            map.get(parentIndex).add(email);
        }

        // Step 3: Build result
        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<Integer, TreeSet<String>> entry : map.entrySet()) {
            int index = entry.getKey();
            List<String> list = new ArrayList<>();

            list.add(accounts.get(index).get(0)); // name
            list.addAll(entry.getValue());

            ans.add(list);
        }

        return ans;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}