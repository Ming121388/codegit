package sy.service;

import java.util.List;
import sy.model.Good;

public interface GoodServiceI {
	
	List<Good> getAll();
	
	Good getGoodByName(String name);
	

}
