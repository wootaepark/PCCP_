package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

// lv 2 : 정답률 56% => 2026년 9월 pccp 3번 문제와 비슷하다.
// https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
public class HotelRoom {

	public static void main(String[] args) {
		String[][] input = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
			{"18:20", "21:20"}};

		int answer = solution(input);
		System.out.println(answer);
	}

	public static int solution(String[][] book_time) {

		int[][] times = new int[book_time.length][2];
		for (int i = 0; i < book_time.length; i++) {
			int start = change(book_time[i][0]);
			int end = change(book_time[i][1]) + 10;
			times[i][0] = start;
			times[i][1] = end;
		}

		Arrays.sort(times, (a, b) -> a[0] - b[0]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < times.length; i++) {
			int start = times[i][0];
			int end = times[i][1];

			if (pq.isEmpty()) {
				pq.offer(end);
				continue;
			}

			if (pq.peek() <= start) {
				pq.poll();
			}
			pq.offer(end);
		}

		return pq.size();
	}

	public static int change(String time) {
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
}


