package scale;

import model.Automobile;;
public class EditOptions extends Thread{
	private Automobile Model;
	private String OptionsetName;
	private String OptionName;
	private String newName;
	private float newprice;

	protected EditOptions(Automobile Model, String OptionsetName, String OptionName, float newprice) {
		this.Model = Model;
		this.OptionsetName = OptionsetName;
		this.OptionName = OptionName;
		this.newprice = newprice;
		this.newName = null;
	}
	
	protected EditOptions(Automobile Model, String OptionsetName, String newName) {
		this.Model = Model;
		this.OptionsetName = OptionsetName;
		this.newName = newName;
	}
	
	public void run() {
        synchronized(Model) {
        	for(int i=0; i<6; i++) {
        		try {
					Thread.sleep((long)(2000*Math.random()));
					if(this.newName == null)
		        		Model.setOption(OptionsetName, OptionName, newprice);
		        	else
		        		Model.setOptionSet(OptionsetName, newName);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		Model.print();
        	}
        }
    }
}
