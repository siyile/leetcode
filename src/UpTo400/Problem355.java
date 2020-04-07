package UpTo400;

import java.util.*;

public class Problem355 {
    private static class Twitter {
        class Tweet {
            int time;
            int id;

            public Tweet(int time, int id) {
                this.time = time;
                this.id = id;
            }
        }

        Map<Integer, List<Tweet>> tweets = new HashMap<>();
        Map<Integer, Set<Integer>> followers = new HashMap<>();
        int time = 0;
        /** Initialize your data structure here. */
        public Twitter() {

        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) {
                tweets.put(userId, new ArrayList<>());
            }
            List<Tweet> list = tweets.get(userId);
            list.add(new Tweet(time++, tweetId));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> list = new ArrayList<>();
            
            // [i, j]
            Queue<int[]> q = new PriorityQueue<>((o1, o2) -> tweets.get(o2[0]).get(o2[1]).time - tweets.get(o1[0]).get(o1[1]).time);

            if (tweets.get(userId) != null && tweets.get(userId).size() != 0) {
                q.add(new int[]{userId, tweets.get(userId).size() - 1});
            }

            if (followers.get(userId) != null) {
                for (int id :
                        followers.get(userId)) {
                    if (tweets.get(id) != null && tweets.get(id).size() != 0) {
                        q.add(new int[]{id, tweets.get(id).size() - 1});
                    }
                }
            }


            while (!q.isEmpty()) {
                int[] arr = q.poll();
                list.add(tweets.get(arr[0]).get(arr[1]).id);
                if (--arr[1] >= 0) {
                    q.add(arr);
                }
                if (list.size() == 10) {
                    break;
                }
            }
            return list;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (followeeId == followerId)
                return;
            if (!followers.containsKey(followerId)) {
                followers.put(followerId, new HashSet<>());
            }
            followers.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (followers.containsKey(followerId)) {
                followers.get(followerId).remove(followeeId);
            }
        }
    }

    public static void main(String[] args) {
        Problem355 p = new Problem355();

        Twitter t = new Twitter();

        t.postTweet(1, 5);
        t.getNewsFeed(1);
        t.follow(1, 2);
        t.postTweet(2, 6);
        t.getNewsFeed(1);
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }
}
