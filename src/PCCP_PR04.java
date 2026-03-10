import java.util.*;
public class PCCP_PR04 {

	// 문제 : https://school.programmers.co.kr/learn/courses/15008/lessons/121683
	// PCCP 1번 수준 문제

	public String solution(String input_string) {
		String answer = "";
		Set<String> answers = new HashSet<>();


		Map<String, Integer> maps = new HashMap<>(); // 문자열, 마지막 나타난 index


		String[] arr = input_string.split("");

		for(int i = 0 ;i<arr.length; i++){

			if(maps.get(arr[i]) != null){
				int last_index = maps.get(arr[i]);
				if(i - 1 != last_index){ // 직전이 마지막이 아닌 경우
					answers.add(arr[i]);

				}
			}

			maps.put(arr[i], i);
		}


		// 알파벳 정렬 후 조건에 맞게 출력


		List<String> results = new ArrayList<>(answers);
		Collections.sort(results);


		if(answers.size() == 0){
			answer += "N";
		}
		else{
			for(String s : results){
				answer += s;
			}
		}






		return answer;
	}
}
