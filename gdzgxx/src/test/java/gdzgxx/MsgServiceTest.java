package gdzgxx;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.gdzgxx.web.model.MsgExample;
import org.gdzgxx.web.service.MsgService;
import org.junit.Test;

public class MsgServiceTest {

	@Resource(name = "testService")
	private MsgService service;

	@Test
	public void testQuery() {
		MsgExample example = new MsgExample();
		example.createCriteria().andMsgIdIsNotNull();
		service.selectByExampleAndPage(example, 1);
	}

}
