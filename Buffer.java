
public class Buffer {
	
	private int content;
	private int maxContent;
	private int minContent;
	
	public Buffer() {
		content = 0;
		maxContent = 25;
		minContent = 0;
	}
	
	public int getContent() {
		return content;
	}
	public boolean isFull() {
		return content == maxContent;
	}
	public boolean isEmpty() {
		return content == minContent;
	}
	public synchronized void pushElement() {
		content++;
	}
	public synchronized void popElement() {
		content--;
	}
}
