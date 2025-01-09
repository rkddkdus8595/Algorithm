class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++) {
			String skill_str = skill_trees[i].replaceAll("[^"+skill+"]", "");
			String str = skill.substring(0, skill_str.length());
			
			if(str.equals(skill_str)) {
				answer++;
			}
		}
        return answer;
    }
}