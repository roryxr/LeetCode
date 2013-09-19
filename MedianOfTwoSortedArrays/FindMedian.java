public class FindMedian {
	public static void main(String[] args) {
		int[] a = {1, 2};
		int[] b = {1, 2, 3};
		double result = findMedian(a, b);
		System.out.println("The median is " + result);
	}

	public static double findMedian(int[] a1, int[] a2) {
		int size1 = a1.length;
		int size2 = a2.length;
		if(size1 == 0) return (size2 % 2 == 0)? ((a2[size2/2-1]+a2[size2/2])/2.0):a2[size2/2];
		if(size2 == 0) return (size1 % 2 == 0)? ((a1[size1/2-1]+a1[size1/2])/2.0):a1[size1/2];
		if(size1 == 1 && size2 == 1) return (a1[0] + a2[0]) / 2.0;
		if(size1 == 1) {
			if((size1+size2) % 2 == 0) return findSmallMedian(a1, 0, 0, a2, size2/2-1, size2/2+1);
			else return findSmallMedian(a1, 0, 0, a2, size/2-1, size/2);
		}
		if(size2 == 1) {
			if((size1+size2) % 2 == 0) return findSmallMedian(a1, size1/2-1, size1/2+1, a2, 0, 0);
			else return findSmallMedian(a1, size1/2-1, size1/2, a2, 0, 0);
		}
		return findMedianRecursive(a1, a2, 0, size1-1, 0, size2-1);
	}

	public static double getTwoSmall(int x, int y, int z) {
		if(x <= y){
				if(y <= z) return (x+y)/2.0;
				else return (x+z)/2.0;
		} else {
			if(x <= z) return (x+y)/2.0;
			else return (y+z)/2.0;
		}
	}

	public static double findMedianRecursive(int[] a1, int[] a2, int lb1, int ub1, int lb2, int ub2) {
		int mid1 = (lb1 + ub1) / 2;
		int mid2 = (lb2 + ub2) / 2;
		if(ub1 - lb1 == 1){
			return getMedianFinal(a1, a2, lb1, ub1, lb2, ub2);
		} else if(ub2 - lb2 == 1) {
			return getMedianFinal(a1, a2, lb1, ub1, lb2, ub2);
		}
		
		if(a1[mid1] < a2[mid2]) return findMedianRecursive(a1, a2, mid1, ub1, lb2, mid2);
		else return findMedianRecursive(a1, a2, lb1, mid1, mid2, ub2);
	}

	public static double getMedianFinal(int[] a1, int[] a2, int lb1, int ub1, int lb2, int ub2) {
		int remain = (a1.length + a2.length) / 2 - lb1 - lb2;
		boolean isOdd = (a1.length + a2.length) % 2 == 1;
		System.out.println("a1 from " + lb1 + " to " + ub1 + " a2 from " + lb2 + " to " + ub2);
		if(ub1 - lb1 == 1 && ub2 - lb2 == 1) {
			if(isOdd) return Math.min(Math.max(a1[lb1], a2[lb2]), Math.min(a1[ub1], a2[ub2]));
			else return (Math.max(a1[lb1], a2[lb2]) + Math.min(a1[ub1], a2[ub2])) / 2.0;
		} else if (ub1 - lb1 == 1) {
			if(isOdd) return Math.min(Math.min(a1[lb1], a1[ub1]), a2[lb2+remain]);
			else {
				if(lb2+remain-1 == ub2) return getTwoSmall(a1[lb1], a1[ub1], a2[lb2+remain-1]);
				else return findTwoMinAvg(a1[lb1], a1[ub1], a2[lb2+remain-1], a2[lb2+remain]);
			}
		} else {
			if(isOdd) return Math.min(Math.min(a2[lb2], a2[ub2]), a1[lb1+remain]);
			else {
				if(lb1+remain-1 == ub1) return getTwoSmall(a2[lb2], a2[ub2], a1[lb1+remain-1]);
				else return findTwoMinAvg(a2[lb2], a2[ub2], a1[lb1+remain-1], a1[lb1+remain]);
			}
		}
	}

	public static double findTwoMinAvg(int x1, int y1, int x2, int y2) {
		return (Math.min(x1, y2) + Math.min(x2, y1)) / 2.0;
	}

	// second method which runs in time O( m+n ), find median while merging.
	public static double findMedian2(int[] a1, int[] a2) {
		int m = a1.length;
		int n = a2.length;
		int[] merged = new int[m+n];
		int count = 0, p1 = 0, p2 = 0;
		int end = m + n -1;
		while(count <= end) {
			if(p1 == m) {
				for(int i = count; i<= end; i++) {
					merged[i] = a2[p2++];
					count++;
				}
			} else if(p2 == n) {
				for(int i = count; i<= end; i++) {
					merged[i] = a1[p1++];
					count++;
				}
			}
			else if(a1[p1] <= a2[p2]) {
				merged[count++] = a1[p1++];
			} else {
				merged[count++] = a2[p2++];
			}
		}
		System.out.println(merged[end/2] + " & " + merged[end/2+1]);
		if(end == 0) return merged[0];
		if((m + n) % 2 == 0) return (merged[end/2] + merged[end/2 + 1]) / 2.0;
    else return merged[end/2];
	}
}
