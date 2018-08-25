package chapter9;

public class FutureData implements Data {
	private RealData realData;
	private boolean ready = false;
	
	@Override
	public synchronized String getContent() {
		while (!ready) {
			try {
				wait();
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		return realData.getContent();
	}
	
	
	public synchronized void setRealData(RealData realData) {
		if (ready) {
			return ;
		}
		
		this.realData = realData;
		this.ready = true;
		notifyAll();
	}
}
