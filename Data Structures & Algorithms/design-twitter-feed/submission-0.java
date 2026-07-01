
class Twitter {

    long time = 0;

    class Tweet {
        int id;
        long timestamp;
        Tweet next;

        public Tweet(int id, long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    class Person {
        int id;
        HashSet<Integer> followees = new HashSet<>();
        Tweet head;

        Person(int id) {
            this.id = id;
            head = new Tweet(-1, -1);
        }
    }

    HashMap<Integer, Person> personList;

    public Twitter() {
        personList = new HashMap<>();
    }

    public Person getOrInsert(int userId) {
        if (!personList.containsKey(userId)) {
            personList.put(userId, new Person(userId));
        }
        return personList.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        Person p = getOrInsert(userId);

        Tweet t = new Tweet(tweetId, ++time);
        t.next = p.head;
        p.head = t;
    }

    public List<Integer> getNewsFeed(int userId) {
        Person user = getOrInsert(userId);

        Set<Integer> followees = new HashSet<>(user.followees);
        followees.add(userId);

        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> Long.compare(b.timestamp, a.timestamp));

        for (int uid : followees) {
            Tweet t = personList.get(uid).head;
            if (t.id != -1) {
                pq.offer(t);
            }
        }

        List<Integer> feed = new ArrayList<>();

        while (!pq.isEmpty() && feed.size() < 10) {
            Tweet cur = pq.poll();
            feed.add(cur.id);

            if (cur.next.id != -1) {
                pq.offer(cur.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        Person follower = getOrInsert(followerId);
        getOrInsert(followeeId);

        follower.followees.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!personList.containsKey(followerId)) {
            return;
        }

        personList.get(followerId).followees.remove(followeeId);
    }
}