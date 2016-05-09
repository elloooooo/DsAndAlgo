package dsTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 */
public class MaxPointsOnLine {
	private static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		int maxCount = 0;
		//循环每一个点，统计其他点和它连线的斜率
		for (int i = 0; i < points.length; i++) {
			//记录每个斜率对应了几个点
			Map<Double, Integer> pointCount = new HashMap<Double, Integer>();
			//记录斜率
			Set<Double> kSet = new HashSet<Double>();
			//记录当前点的重复个数，至少会是1，因为自循环从当前点开始
			int duplicteNode = 0;
			for (int j = 0; j < points.length; j++) {
				if (points[i].y == points[j].y && points[i].x == points[j].x) {
					duplicteNode++;
					continue;
				}

				double k = 0;
				//如果连线与x轴垂直
				if (points[i].x == points[j].x) {
					k = Double.MAX_VALUE;
				} else {
					k = (float) (points[i].y - points[j].y)
							/ (points[i].x - points[j].x);
				}
				//统计各个斜率对应的点数
				if (!kSet.contains(k)) {
					kSet.add(k);
					pointCount.put(k, 1);
				} else {
					pointCount.put(k, pointCount.get(k) + 1);
				}
			}

			// 利用entrySet循环Map
			// 这个实现更好
			// 如果输入数据只是一个点重复多次，那么pointCount中将会没有任何元素，这个点的个数仅仅记录在duplicteNode中，
			// 此时就需要做出判断，仅仅使用duplicteNode确定最大值
			if (pointCount.size() != 0) {
				Iterator<Entry<Double, Integer>> iter = pointCount.entrySet()
						.iterator();
				while (iter.hasNext()) {
					Map.Entry<Double, Integer> entry = (Entry<Double, Integer>) iter
							.next();
					if (entry.getValue() + duplicteNode > maxCount) {
						maxCount = entry.getValue() + duplicteNode;
					}
				}
			} else {
				maxCount = duplicteNode;
			}

			/*if (pointCount.size() != 0) {
				// 利用keySet循环Map
				Iterator<Double> iter = pointCount.keySet().iterator();
				while (iter.hasNext()) {
					int counts = pointCount.get(iter.next()) + duplicteNode;
					if (counts > maxCount) {
						maxCount = counts;
					}
				}
			} else {
				maxCount = duplicteNode;
			}*/

		}

		return maxCount;
	}

	public static void main(String[] args) {
		Point[] points = { new Point(1, 4), new Point(1, 4), new Point(1, 4),
				new Point(2, 3), new Point(2, 3), new Point(1, 1),
				new Point(4, 4), new Point(6, -1), new Point(2, 2),
				new Point(3, 3), new Point(0, 0) };
		// Point[] points = {new Point(0,0)};
		MaxPointsOnLine m = new MaxPointsOnLine();
		int res = m.maxPoints(points);
		System.out.println(res);

	}

}
