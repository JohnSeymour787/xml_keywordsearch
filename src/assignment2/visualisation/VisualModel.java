package assignment2.visualisation;

/**
 * VisualModel is responsible for representing the frequency of a single keyword
 *
 * @author Quinn Chan - 103053395
 */
public class VisualModel implements Comparable<VisualModel> {
	private int freq;
	private String keyword;

	VisualModel (String keyword, int freq) {
		this.keyword = keyword;
		this.freq = freq;
	}

	public int compareTo(VisualModel e) {
		return this.freq - e.freq;
	}
	
	public String getKeyword() {
	      return this.keyword;
	   }
	   
	   public void setKeyword(String keyword) {
	      this.keyword = keyword;
	   }
	   
	   public int getFreq() {
	      return this.freq;
	   }
	   
	   public void setFreq(int freq) {
	      this.freq = freq;
	   }
}
