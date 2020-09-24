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
        int no = lost.length; //������ ���� ���ϴ� �л��� ��
        
        //������ ü������ �����ִ� �л��� ü������ �Ҿ���� ���
        //1. �Ҿ���� �л��� ��ȣ�� ������ ü������ ���� �л��� ��ȣ�� -1�� �ٲ�
        //2. ������ ���� ���ϴ� �л� �� -1
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
        		//������ ü������ ���� �л��� �չ�ȣ�� ���
        		if(reserve[i]!=-1&&lost[j]==(reserve[i]-1)) {
        			no--; //������ ���� ���ϴ� �л� �� -1
        			//�Ҿ���� ü������ �л��� �̹� ���ȱ� ������ ��ȣ�� -1�� �ٲ�
        			lost[j]=-1;
        			break;
        		//������ ü������ ���� �л��� �޹�ȣ�� ���
        		}else if(reserve[i]!=-1&&lost[j]==(reserve[i]+1)) {
        			no--;
        			lost[j]=-1;
        			break;
        		}
        	}
        }
        
        // ��ü �л� �� - ���������� ü������ ������ ���� �л��� ��
        answer = n-no; 
        return answer;
    }
	
	public static void main(String[] args) {
		new Solution();

	}

}
