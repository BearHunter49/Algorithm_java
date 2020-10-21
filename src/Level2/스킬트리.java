package Level2;

public class 스킬트리 {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF"}));
    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        int lengthOfSkill = skill.length();
        for (String skill_tree: skill_trees){
            int next_index = 0;
            char next_skill = skill.charAt(next_index);
            int is_success = 1;

            for (int i = 0; i < skill_tree.length(); i++){
                if (skill.contains(String.valueOf(skill_tree.charAt(i)))){  // 스킬트리에 포함됨
                    if (next_skill != skill_tree.charAt(i)){  // 순서에 안맞음
                        is_success = 0;
                        break;
                    }else{  // 순서에 맞음
                        next_index++;
                        if (next_index < lengthOfSkill){  // Out of index 체크
                            next_skill = skill.charAt(next_index);
                        }
                    }
                }
            }

            if (is_success == 1){  // 괜찮은 스킬트리
                answer++;
            }
        }

        return answer;
    }
}
