

package cn.slyang.framework.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TreeUtil {

	public TreeUtil() {
	}

	public static List<Map<String, Object>> getTreeArray(List list, String nodeKey, String superNodeKey, String arrayKey, Class c) {
		TreeUtil treeUtil = new TreeUtil();
		List<Map<String, Object>> mapList = treeUtil.beanArrToListMap(list, c);
		List<Map<String, Object>> l = null;
		Map<String, Object> map = treeUtil.listToMap(mapList, nodeKey);
		l = treeUtil.getNode(map, nodeKey, superNodeKey, arrayKey);
		return l;
	}

	public static List<Map<String, Object>> getTreeArray(List<Map<String, Object>> list, String nodeKey, String superNodeKey, String arrayKey) {
		TreeUtil treeUtil = new TreeUtil();
		List<Map<String, Object>> l = null;
		Map<String, Object> map = treeUtil.listToMap(list, nodeKey);
		l = treeUtil.getNode(map, nodeKey, superNodeKey, arrayKey);
		return l;
	}

	public static List<Map<String, Object>> getTreeArrayNotDisabledNode(List<Map<String, Object>> list, String nodeKey, String superNodeKey, String arrayKey, String disabledKey, String disabledValue) {
		TreeUtil treeUtil = new TreeUtil();
		List<Map<String, Object>> l = null;
		Map<String, Object> map = treeUtil.listToMap(list, nodeKey);
		treeUtil.removeDisabledNode(map, disabledKey, disabledValue, superNodeKey, "");
		l = treeUtil.getNode(map, nodeKey, superNodeKey, arrayKey);
		return l;
	}

	public Map<String, Object> listToMap(List<Map<String, Object>> list, String nodeKey) {
		Map<String, Object> map = new LinkedHashMap();

		for (int i = 0; i < list.size(); ++i) {
			Map<String, Object> m = (Map) list.get(i);
			if (map.get(m.get(nodeKey)) == null) {
				map.put(m.get(nodeKey) + "", m);
			} else if (map.get(m.get(nodeKey)) != null && map.get(m.get(nodeKey)) instanceof Map) {
				List<Map<String, Object>> l = new ArrayList();
				l.add((Map) map.get(m.get(nodeKey)));
				l.add(m);
				map.put(m.get(nodeKey) + "", l);
			} else if (map.get(m.get(nodeKey)) != null && map.get(m.get(nodeKey)) instanceof List) {
				List<Map<String, Object>> l = (List) map.get(m.get(nodeKey));
				l.add(m);
				map.put(m.get(nodeKey) + "", l);
			}
		}

		return map;
	}

	public Map<String, Object> removeDisabledNode(Map<String, Object> objMap, String disabledKey, String disabledValue, String superNodeKey, String disabledCode) {
		Set<String> set = objMap.keySet();
		Iterator<String> it = set.iterator();
		String disabledCode3 = "";

		while (true) {
			while (true) {
				String key;
				Map m;
				Object l;
				while (true) {
					if (!it.hasNext()) {
						String[] s = disabledCode3.split("@");

						for (int i = 0; i < s.length; ++i) {
							objMap.remove(s[i]);
						}

						String disabledCode2 = disabledCode + disabledCode3;
						if (disabledCode2.length() != disabledCode.length()) {
							this.removeDisabledNode(objMap, disabledKey, disabledValue, superNodeKey, disabledCode2);
						}

						return objMap;
					}

					key = (String) it.next();
					m = null;
					l = null;
					if (objMap.get(key) instanceof Map) {
						m = (Map) objMap.get(key);
						l = new ArrayList();
						((List) l).add(m);
						break;
					}

					if (objMap.get(key) instanceof List) {
						l = (List) objMap.get(key);
						break;
					}
				}

				int n = 0;

				for (int i = 0; i < ((List) l).size(); ++i) {
					m = (Map) ((List) l).get(i);
					if (m.get(disabledKey) != null && !m.get(disabledKey).toString().equals(disabledValue) || m.get(superNodeKey) != null && StringUtils.isNotEmpty(m.get(superNodeKey) + "") && disabledCode.indexOf("@" + m.get(superNodeKey) + "@") != -1) {
						((List) l).remove(i);
						((List) l).add(i, (Object) null);
						++n;
					}
				}

				if (n == ((List) l).size() && n > 0) {
					if (disabledCode3.length() == 0) {
						disabledCode3 = disabledCode3 + "@";
					}

					disabledCode3 = disabledCode3 + key + "@";
				} else if (((List) l).size() > 1) {
					objMap.put(key, l);
				} else {
					objMap.put(key, m);
				}
			}
		}
	}

	public List<Map<String, Object>> getNode(Map<String, Object> map, String nodeKey, String superNodeKey, String arrayKey) {
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		ArrayList list = new ArrayList();

		while (true) {
			Map m;
			Object l;
			do {
				do {
					if (!it.hasNext()) {
						return list;
					}

					String key = (String) it.next();
					m = null;
					l = new ArrayList();
					if (map.get(key) instanceof Map) {
						m = (Map) map.get(key);
						((List) l).add(m);
					} else if (map.get(key) instanceof List) {
						l = (List) map.get(key);
					}
				} while (l == null);
			} while (((List) l).size() <= 0);

			for (int i = 0; i < ((List) l).size(); ++i) {
				m = (Map) ((List) l).get(i);
				if (m.get(superNodeKey) == null || map.get(m.get(superNodeKey)) == null) {
					m.put(superNodeKey, (Object) null);
					m.put(arrayKey, this.getList(m.get(nodeKey) + "", map, superNodeKey, arrayKey));
					list.add(m);
				}
			}
		}
	}

	public List<Map<String, Object>> getList(String id, Map<String, Object> map, String superNodeKey, String arrayKey) {
		List<Map<String, Object>> list = map.get(arrayKey) == null ? null : (ArrayList) map.get(arrayKey);
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		if (map != null && map.size() > 0) {
			while (true) {
				String key;
				Map m;
				Object l;
				do {
					do {
						if (!it.hasNext()) {
							return list;
						}

						key = (String) it.next();
						m = null;
						l = new ArrayList();
						if (map.get(key) instanceof Map) {
							m = (Map) map.get(key);
							((List) l).add(m);
						} else if (map.get(key) instanceof List) {
							l = (List) map.get(key);
						}
					} while (l == null);
				} while (((List) l).size() <= 0);

				for (int i = 0; i < ((List) l).size(); ++i) {
					m = (Map) ((List) l).get(i);
					if ((m.get(superNodeKey) + "").equals(id)) {
						if (list == null) {
							list = new ArrayList();
						}

						Map<String, Object> m2 = new HashMap();
						m2.putAll(map);
						m2.remove(key);
						m.put(arrayKey, this.getList(key, m2, superNodeKey, arrayKey));
						list.add(m);
					}
				}
			}
		} else {
			return list;
		}
	}

	public List<Map<String, Object>> beanArrToListMap(List list, Class clazz) {
		List<Map<String, Object>> mapList = new ArrayList();

		for (int i = 0; i < list.size(); ++i) {
			Object obj = list.get(i);
			mapList.add(beanToMap(obj, clazz));
		}

		return mapList;
	}

	public static HashMap<String, Object> beanToMap(Object bean, Class clazz) {
		HashMap<String, Object> map = new HashMap();
		if (null == bean) {
			return map;
		} else {
			BeanInfo beanInfo = null;

			try {
				beanInfo = Introspector.getBeanInfo(clazz);
			} catch (IntrospectionException var16) {
				var16.printStackTrace();
			}

			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			PropertyDescriptor[] var5 = descriptors;
			int var6 = descriptors.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				PropertyDescriptor descriptor = var5[var7];
				String propertyName = descriptor.getName();
				if (!"class".equals(propertyName)) {
					Method method = descriptor.getReadMethod();

					try {
						Object result = method.invoke(bean);
						if (null != result) {
							map.put(propertyName, result);
						} else {
							map.put(propertyName, "");
						}
					} catch (IllegalArgumentException var13) {
						var13.printStackTrace();
					} catch (IllegalAccessException var14) {
						var14.printStackTrace();
					} catch (InvocationTargetException var15) {
						var15.printStackTrace();
					}
				}
			}

			return map;
		}
	}

	public static Object mapToBean(Class clazz, HashMap map) {
		Object object = null;

		try {
			object = clazz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
			PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
			PropertyDescriptor[] var5 = descriptors;
			int var6 = descriptors.length;

			for (int var7 = 0; var7 < var6; ++var7) {
				PropertyDescriptor descriptor = var5[var7];
				String propertyName = descriptor.getName();
				if (map.containsKey(propertyName)) {
					Object value = map.get(propertyName);
					Object[] args = new Object[]{value};
					descriptor.getWriteMethod().invoke(object, args);
				}
			}
		} catch (InstantiationException var12) {
			var12.printStackTrace();
		} catch (IllegalAccessException var13) {
			var13.printStackTrace();
		} catch (IntrospectionException var14) {
			var14.printStackTrace();
		} catch (IllegalArgumentException var15) {
			var15.printStackTrace();
		} catch (InvocationTargetException var16) {
			var16.printStackTrace();
		}

		return object;
	}
}
