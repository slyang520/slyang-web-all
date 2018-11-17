package cn.slyang.framework.core;


import cn.slyang.framework.core.utils.JsonUtil;
import cn.slyang.framework.core.utils.TreeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrameWorkApp {

	public static void main(String[] args)  {

		testBuildTree();
	}


	public static void testBuildTree() {

		Map<String, Object> test = new HashMap<>();
		test.put("id", "1");
		test.put("pid", "0");
		test.put("label", "1");

		Map<String, Object> test2 = new HashMap<>();
		test2.put("id", "2");
		test2.put("pid", "0");
		test2.put("label", "2");

		Map<String, Object> test3 = new HashMap<>();
		test3.put("id", "3");
		test3.put("pid", "2");
		test3.put("label", "3");

		Map<String, Object> test4 = new HashMap<>();
		test4.put("id", "4");
		test4.put("pid", "3");
		test4.put("label", "4");

		Map<String, Object> test5 = new HashMap<>();
		test5.put("id", "5");
		test5.put("pid", "4");
		test5.put("label", "5");

		Map<String, Object> test6 = new HashMap<>();
		test6.put("id", "6");
		test6.put("pid", "5");
		test6.put("label", "6");


		List<Map<String, Object>> list = new ArrayList<>();
		list.add(test);
		list.add(test2);
		list.add(test3);
		list.add(test4);
		list.add(test5);
		list.add(test6);

		System.out.println(JsonUtil.toJSONString(TreeUtil.getTreeArray(list, "id", "pid", "children")));

	}


}
