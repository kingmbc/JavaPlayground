package practice;
import java.lang.management.ManagementFactory;
import java.util.List;

public class DynamicTimeWarping {
	public static void main(String[] args) {
		int[] s = {2, 5, 2, 5, 3};
		int[] t = {0, 3, 6, 0, 6, 1};
		DynamicTimeWarping m = new DynamicTimeWarping();
		double a = m.DTWDistance(s, t);
		System.out.println(a);
		List<String> arg = ManagementFactory.getRuntimeMXBean().getInputArguments();
		
		DynamicTimeWarping.runningFromIntelliJ();
		
	}
	public double DTWDistance(int[] s, int[] t){
		double[][] dtw = new double[s.length][t.length];
		
		
		int i, j;
		double cost = 0;
		for (i = 1; i < s.length; i++)
			dtw[i][0] = 3000;
		for (i = 1; i < t.length; i++)
			dtw[0][i] = 3000;
		
		dtw[0][0] = 0;
		
		for(i = 1; i < s.length; i++){
			for(j = 1; j < t.length; j++){
				cost = d(s[i], t[j]);
				dtw[i][j] = cost + Math.min(dtw[i-1][j], Math.min(dtw[i][j-1], dtw[i-1][j-1]));
			}
		}
		return dtw[s.length-1][t.length-1];
	}
	
	public double d(double a, double b){
		double result = Math.sqrt(Math.pow((a - b), 2));
		return result;
	}
	
	public static boolean runningFromIntelliJ() 
	{ 
	    String classPath = System.getProperty("java.class.path");
	    String libraryPath = System.getProperty("java.library.path");
	    return classPath.contains("IntelliJ IDEA");
	} 

}
