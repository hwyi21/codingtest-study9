package solution;

public class Solution {

	public Solution() {
		int n=5;
		int[] lost = {2, 4};
		int[] reserve = {1,3,4,5};
		
		solution(n, lost, reserve);
	}
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int no = lost.length; //수업을 받지 못하는 학생의 수
        
        //여분의 체육복을 갖고있는 학생이 체육복을 잃어버린 경우
        //1. 잃어버린 학생의 번호와 여분의 체육복을 가진 학생의 번호를 -1로 바꿈
        //2. 수업을 받지 못하는 학생 수 -1
        for(int i=0; i<reserve.length; i++) {
        	for(int j=0; j<lost.length; j++) {
        		if(reserve[i]==lost[j]) {
        			lost[j] = -1;
        			reserve[i] = -1;
        			no--;    
        			break;
        		}
        	}
        }
        
        
        for(int i=0; i<reserve.length; i++) {
        	for(int j=0; j<lost.length; j++) {
        		//여분의 체육복을 가진 학생의 앞번호인 경우
        		if(reserve[i]!=-1&&lost[j]==(reserve[i]-1)) {
        			no--; //수업을 받지 못하는 학생 수 -1
        			//잃어버린 체육복의 학생은 이미 빌렸기 때문에 번호를 -1로 바꿈
        			lost[j]=-1;
        			break;
        		//여분의 체육복을 가진 학생의 뒷번호인 경우
        		}else if(reserve[i]!=-1&&lost[j]==(reserve[i]+1)) {
        			no--;
        			lost[j]=-1;
        			break;
        		}
        	}
        }
        
        // 전체 학생 수 - 최종적으로 체육복을 빌리지 못한 학생의 수
        answer = n-no; 
        return answer;
    }
	
	public static void main(String[] args) {
		new Solution();

	}

}
