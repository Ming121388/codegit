package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.GoodMapper;
import sy.model.Good;

@Service("goodService")
public class GoodServiceImpl implements GoodServiceI {
	private GoodMapper goodmapper;

	public GoodMapper getGoodmapper() {
		return goodmapper;
	}

	@Autowired
	public void setGoodmapper(GoodMapper goodmapper) {
		this.goodmapper = goodmapper;
	}

	@Override
	public List<Good> getAll() {
		return goodmapper.getAll();
	}
	
	public Good getGoodByName(String name){
		return goodmapper.selectByName(name);
	}

}
