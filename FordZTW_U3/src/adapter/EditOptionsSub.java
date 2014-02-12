package adapter;

import model.Automobile;
import scale.EditOptions;
class EditOptionsSub extends EditOptions {
	EditOptionsSub(Automobile Model, String OptionsetName,
							 String OptionName, float newprice) {
		super(Model, OptionsetName, OptionName, newprice);
	}

	EditOptionsSub(Automobile Model, String OptionsetName,
			 		String newName) {
	super(Model, OptionsetName, newName);
	}
}
