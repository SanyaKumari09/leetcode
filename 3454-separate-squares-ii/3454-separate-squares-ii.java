class Solution {

    class SegmentTree {
        int[] count;
        long[] length;
        long[] xs;

        SegmentTree(long[] xs) {
            this.xs = xs;
            int n = xs.length;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r,
                    int ql, int qr, int val) {

            if (qr < l || r < ql) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid + 1, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r + 1] - xs[l];
            } else if (l == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2]
                             + length[node * 2 + 1];
            }
        }

        void add(int l, int r, int val) {
            if (l > r) return;
            update(1, 0, xs.length - 2, l, r, val);
        }

        long covered() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<long[]> events = new ArrayList<>();
        TreeSet<Long> set = new TreeSet<>();

        for (int[] s : squares) {
            long x = s[0];
            long y = s[1];
            long len = s[2];

            events.add(new long[]{y, 1, x, x + len});
            events.add(new long[]{y + len, -1, x, x + len});

            set.add(x);
            set.add(x + len);
        }

        long[] xs = new long[set.size()];
        int idx = 0;
        for (long v : set) xs[idx++] = v;

        events.sort((a, b) -> Long.compare(a[0], b[0]));

        SegmentTree st = new SegmentTree(xs);

        long prevY = events.get(0)[0];
        double totalArea = 0;

        for (long[] e : events) {
            long y = e[0];

            totalArea +=
                    (double) st.covered() * (y - prevY);

            int l = Arrays.binarySearch(xs, e[2]);
            int r = Arrays.binarySearch(xs, e[3]) - 1;

            st.add(l, r, (int) e[1]);
            prevY = y;
        }

        double half = totalArea / 2.0;

        st = new SegmentTree(xs);
        prevY = events.get(0)[0];
        double area = 0;

        for (long[] e : events) {
            long y = e[0];

            long width = st.covered();
            double gain = (double) width * (y - prevY);

            if (area + gain >= half) {
                return prevY + (half - area) / width;
            }

            area += gain;

            int l = Arrays.binarySearch(xs, e[2]);
            int r = Arrays.binarySearch(xs, e[3]) - 1;

            st.add(l, r, (int) e[1]);
            prevY = y;
        }

        return 0.0;
    }
}