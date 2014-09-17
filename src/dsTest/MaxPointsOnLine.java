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
		//ѭ��ÿһ���㣬ͳ��������������ߵ�б��
		for (int i = 0; i < points.length; i++) {
			//��¼ÿ��б�ʶ�Ӧ�˼�����
			Map<Double, Integer> pointCount = new HashMap<Double, Integer>();
			//��¼б��
			Set<Double> kSet = new HashSet<Double>();
			//��¼��ǰ����ظ����������ٻ���1����Ϊ��ѭ���ӵ�ǰ�㿪ʼ
			int duplicteNode = 0;
			for (int j = 0; j < points.length; j++) {
				if (points[i].y == points[j].y && points[i].x == points[j].x) {
					duplicteNode++;
					continue;
				}

				double k = 0;
				//���������x�ᴹֱ
				if (points[i].x == points[j].x) {
					k = Double.MAX_VALUE;
				} else {
					k = (float) (points[i].y - points[j].y)
							/ (points[i].x - points[j].x);
				}
				//ͳ�Ƹ���б�ʶ�Ӧ�ĵ���
				if (!kSet.contains(k)) {
					kSet.add(k);
					pointCount.put(k, 1);
				} else {
					pointCount.put(k, pointCount.get(k) + 1);
				}
			}

			// ����entrySetѭ��Map
			// ���ʵ�ָ���
			// �����������ֻ��һ�����ظ���Σ���ôpointCount�н���û���κ�Ԫ�أ������ĸ���������¼��duplicteNode�У�
			// ��ʱ����Ҫ�����жϣ�����ʹ��duplicteNodeȷ�����ֵ
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
				// ����keySetѭ��Map
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
