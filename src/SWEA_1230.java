
import java.util.*;
import java.io.*;

public class SWEA_1230 {
	public static void main(String[] args) throws Exception {

		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= T; test_case++) {

			int code_len = Integer.parseInt(br.readLine()); // 원본 암호문의 길이
			StringTokenizer st = new StringTokenizer(br.readLine());

			List<String> codeList = new LinkedList<>();
			for (int i = 0; i < code_len; i++) {
				codeList.add(st.nextToken());
			}
			int command_len = Integer.parseInt(br.readLine()); // 명령어의 개수

			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {

				String input = st.nextToken();

				if (input.equals("I")) {
					int idx = Integer.parseInt(st.nextToken()); // idx 번째에
					int count = Integer.parseInt(st.nextToken()); // count 개를 삽입

					for (int i = 0; i < count; i++) {
						codeList.add(idx++, st.nextToken());
					}

				} else if (input.equals("A")) {
					int count = Integer.parseInt(st.nextToken());
					for (int i = 0; i < count; i++) {
						codeList.add(st.nextToken());
					}
				} else if (input.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					for (int i = 0; i < count; i++) {
						codeList.remove(idx);
					}
				}

			}

			StringBuilder sb = new StringBuilder("#");
			sb.append(test_case).append(" ");
			for (int i = 0; i < 10; i++) {
				sb.append(codeList.get(i)).append(" ");
			}

			System.out.println(sb);

		}
	}
}