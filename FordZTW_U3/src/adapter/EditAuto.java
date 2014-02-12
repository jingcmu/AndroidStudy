package adapter;

public interface EditAuto {
	public void editOptionPrice(String ModelName, String OptionsetName, String OptionName, float newprice);
	public void editOptionSetName(String ModelName, String OptionsetName, String newName);
}
